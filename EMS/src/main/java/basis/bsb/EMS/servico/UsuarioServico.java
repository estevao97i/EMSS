package basis.bsb.EMS.servico;

import basis.bsb.EMS.dominio.Usuario;
import basis.bsb.EMS.repositorio.EventoRepositorio;
import basis.bsb.EMS.repositorio.UsuarioRepositorio;
import basis.bsb.EMS.servico.DTO.UsuarioDTO;
import basis.bsb.EMS.servico.Mapper.UsuarioMapper;
import basis.bsb.EMS.servico.excecao.ObjectnotFoundException;
import basis.bsb.EMS.servico.filtro.UsuarioFiltro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class UsuarioServico implements Serializable {

    private final UsuarioRepositorio usuarioRepositorio;
    private final UsuarioMapper usuarioMapper;
    private final EventoServico eventoServico;

    public UsuarioDTO encontrarPorId(Long id) {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(ObjectnotFoundException ::new);
        return usuarioMapper.toDTO(usuario);
    }

    public List<UsuarioDTO> buscarTodos(){
        return usuarioMapper.toDTO(usuarioRepositorio.findAll());
    }

    public boolean validaCPF(UsuarioDTO usuarioDTO) {
        if (!usuarioRepositorio.existsByCpf(usuarioDTO.getCpf())) {
            return true;
        }
        throw new ObjectnotFoundException("CPF ja existe no banco " + usuarioDTO.getCpf());
    }

    public boolean validaEmail(UsuarioDTO usuarioDTO){
        if (!usuarioRepositorio.existsByEmail(usuarioDTO.getEmail())){
            return true;
        }
        throw new ObjectnotFoundException("Email já cadastrado no banco "+ usuarioDTO.getEmail());

    }
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        if (validaCPF(usuarioDTO) && validaEmail(usuarioDTO)){
            Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
            usuario.setStatus(true);
            Usuario usuarioSalva = usuarioRepositorio.save(usuario);
            return usuarioMapper.toDTO(usuarioSalva);
        }
        throw new ObjectnotFoundException(" " + usuarioDTO.getCpf());
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
        eventoServico.analisaUsuario(usuarioMapper.toEntity(usuarioDTO));
        usuarioDTO.setStatus(false);
        editar(usuarioDTO);
    }

    public List<UsuarioDTO> buscarTodosFiltro(UsuarioFiltro usuarioFiltro) {
        return usuarioMapper.toDTO(usuarioRepositorio.findAll(usuarioFiltro.filter()));
    }

}
