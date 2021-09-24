package basis.bsb.EMS.builder;

import basis.bsb.EMS.dominio.Evento;
import basis.bsb.EMS.dominio.Motivo;
import basis.bsb.EMS.dominio.Usuario;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;

public class EventoBuilder extends ConstrutorDeEntidade<Evento> {

    Evento evento = new Evento();
    Motivo motivo = new Motivo();
    UsuarioBuilder usuarioBuilder;

    @Override
    protected Evento construirEntidade() throws ParseException {

        evento.setDataEvento(LocalDate.now().minusYears(21));
        evento.setJustificativaAdiamento("");
        evento.setValor(50L);
        motivo.setDescricao("asdasdas");
        evento.setMotivo(motivo);
        evento.setUsuario(construir().getUsuario());
        return null;
    }

    @Override
    protected Evento persistir(Evento entidade) {
        return null;
    }

    @Override
    protected Collection<Evento> obterTodos() {
        return null;
    }

    @Override
    protected Evento obterPorId(Long id) {
        return null;
    }

}
