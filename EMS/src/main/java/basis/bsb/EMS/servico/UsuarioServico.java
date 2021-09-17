package basis.bsb.EMS.servico;

import basis.bsb.EMS.dominio.Usuario;
import basis.bsb.EMS.repositorio.UsuarioRepositorio;
import basis.bsb.EMS.servico.excecao.ObjectnotFoundException;
import liquibase.pro.packaged.id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class UsuarioServico {

    private UsuarioRepositorio usuarioRepositorio;

    public Usuario encontrarPorId(Long id) {
        return usuarioRepositorio.findById(id).orElseThrow(()-> new ObjectnotFoundException("Usuario nao encontrado!:" + id));
    }

    public List<Usuario> encontrarPorTodos(){
        return usuarioRepositorio.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public Usuario editar(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }
    public void deletar(Long id){
        usuarioRepositorio.deleteById(id);
    }

}
