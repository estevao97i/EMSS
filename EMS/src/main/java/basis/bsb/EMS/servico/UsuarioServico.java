package basis.bsb.EMS.servico;

import basis.bsb.EMS.dominio.Usuario;
import basis.bsb.EMS.repositorio.UsuarioRepositorio;
import basis.bsb.EMS.servico.DTO.UsuarioDTO;
import basis.bsb.EMS.servico.Mapper.UsuarioEditaMapper;
import basis.bsb.EMS.servico.Mapper.UsuarioMapper;
import basis.bsb.EMS.servico.excecao.ObjectnotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Transactional
@Service
public class UsuarioServico {

    private final  UsuarioRepositorio usuarioRepositorio;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioEditaMapper usuarioEditaMapper;

    public UsuarioDTO encontrarPorId(Long id) {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(ObjectnotFoundException ::new);
        return usuarioMapper.toDTO(usuario);
    }

    public List<UsuarioDTO> buscarTodos(){
        return usuarioMapper.toDTO(usuarioRepositorio.findAll());
    }

    public boolean validaCPF(UsuarioDTO usuarioDTO) {
        if (usuarioRepositorio.existsByCpf(usuarioDTO.getCpf())) {
            throw new ObjectnotFoundException("CPF inválido " + usuarioDTO.getCpf());
        }
            return true;
    }

    public boolean validaEmail(UsuarioDTO usuarioDTO){
        if (usuarioRepositorio.existsByEmail(usuarioDTO.getEmail())){
            return true;
        }
        throw new ObjectnotFoundException("Email inválido "+ usuarioDTO.getEmail());

    }
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
            Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
            Usuario usuarioSalva = usuarioRepositorio.save(usuario);
            return usuarioMapper.toDTO(usuarioSalva);

    }

    public UsuarioDTO editar(UsuarioDTO usuarioDTO){
            Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
            Usuario usuarioAtualiza = usuarioRepositorio.save(usuario);
            return usuarioMapper.toDTO(usuarioAtualiza);
    }

    public void ativarUsuario(Long id){
        UsuarioDTO usuarioDTO = encontrarPorId(id);
        usuarioDTO.setStatus(true);
        editar(usuarioDTO);
    }

    public void inativarUsuario(Long id){
        UsuarioDTO usuarioDTO = encontrarPorId(id);
        usuarioDTO.setStatus(false);
        editar(usuarioDTO);
    }

}
