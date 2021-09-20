package basis.bsb.EMS.servico;

import basis.bsb.EMS.dominio.Usuario;
import basis.bsb.EMS.repositorio.UsuarioRepositorio;
import basis.bsb.EMS.servico.DTO.UsuarioDTO;
import basis.bsb.EMS.servico.Mapper.UsuarioMapper;
import basis.bsb.EMS.servico.excecao.ObjectnotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UsuarioServico {

    private UsuarioRepositorio usuarioRepositorio;
    private UsuarioMapper usuarioMapper;

    public UsuarioDTO encontrarPorId(Long id) {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(ObjectnotFoundException ::new);
        return usuarioMapper.toDTO(usuario);
    }

    public List<UsuarioDTO> buscarTodos( ){
        List<Usuario> usuario = usuarioRepositorio.findAll();
        return usuarioMapper.toDTO(usuario);
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
    public void deletar(Long id){
        usuarioRepositorio.deleteById(id);
    }

    public void ativarUsuario(Long id){
        UsuarioDTO usuarioDTO = encontrarPorId(id);
        usuarioDTO.setStatus(true);
    }

    public void inativarUsuario(Long id){
        UsuarioDTO usuarioDTO = encontrarPorId(id);
        usuarioDTO.setStatus(false);
    }

}
