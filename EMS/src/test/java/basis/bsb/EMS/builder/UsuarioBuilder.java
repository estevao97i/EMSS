package basis.bsb.EMS.builder;

import basis.bsb.EMS.dominio.Usuario;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;

public class UsuarioBuilder extends ConstrutorDeEntidade<Usuario> {

    Usuario usuario = new Usuario();

    @Override
    protected Usuario construirEntidade() throws ParseException {
        usuario.setNome("Usuario teste");
        usuario.setStatus(true);
        usuario.setCpf("04799115170");
        usuario.setEmail("fulano@email.com");
        usuario.setDataNascimento(LocalDate.now().minusYears(21));
        return null;
    }

    @Override
    protected Usuario persistir(Usuario entidade) {
        return null;
    }

    @Override
    protected Collection<Usuario> obterTodos() {
        return null;
    }

    @Override
    protected Usuario obterPorId(Long id) {
        return null;
    }


}
