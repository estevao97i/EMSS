package basis.bsb.EMS.builder;

import basis.bsb.EMS.dominio.Usuario;
import basis.bsb.EMS.repositorio.UsuarioRepositorio;
import basis.bsb.EMS.servico.Mapper.UsuarioMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;

@Component
public class UsuarioBuilder extends ConstrutorDeEntidade<Usuario> {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    protected Usuario construirEntidade() throws ParseException {
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario teste");
        usuario.setStatus(true);
        usuario.setCpf("04799115170");
        usuario.setEmail("fulano@email.com");
        usuario.setDataNascimento(LocalDate.now().minusYears(21));
        return usuario;
    }

    @Override
    protected Usuario persistir(Usuario entidade) {
        return usuarioRepositorio.save(entidade);
    }

    @Override
    protected Collection<Usuario> obterTodos() {
        return usuarioRepositorio.findAll();
    }

    @Override
    protected Usuario obterPorId(Long id) {
        return usuarioRepositorio.findById(id).get();
    }

    public void delete(){
        usuarioRepositorio.deleteAll();
    }

}
