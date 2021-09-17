package servico;

import basis.bsb.EMS.dominio.Usuario;
import basis.bsb.EMS.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class UsuarioServico {

    private final UsuarioRepositorio usuarioRepositorio;

    public Usuario encontraPorId(Long id){
        return usuarioRepositorio.getById(id);
    }

    public List<Usuario> encontrarTodos(){
        return usuarioRepositorio.findAll();
    }

    public Usuario salva(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    public Usuario edita(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    public void deleta(Long id){
        usuarioRepositorio.deleteById(id);
    }
}
