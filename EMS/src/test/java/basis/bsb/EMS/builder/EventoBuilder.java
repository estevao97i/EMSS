package basis.bsb.EMS.builder;

import basis.bsb.EMS.dominio.Evento;
import basis.bsb.EMS.dominio.Motivo;
import basis.bsb.EMS.dominio.Usuario;
import basis.bsb.EMS.repositorio.EventoRepositorio;
import basis.bsb.EMS.servico.Mapper.EventoMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;

@Component
public class EventoBuilder extends ConstrutorDeEntidade<Evento> {

    @Autowired
    private EventoMapper eventoMapper;

    @Autowired
    private EventoRepositorio eventoRepositorio;

    @Override
    protected Evento construirEntidade() throws ParseException {
        Evento evento = new Evento();
        Motivo motivo = new Motivo();
        UsuarioBuilder usuarioBuilder;

        evento.setDataEvento(LocalDate.now().minusYears(21));
        evento.setJustificativaAdiamento("");
        evento.setValor(50L);
        motivo.setDescricao("asdasdas");
        evento.setMotivo(motivo);
        evento.setUsuario(construir().getUsuario());
        return evento;
    }

    @Override
    protected Evento persistir(Evento entidade) {
        return eventoRepositorio.save(entidade);
    }

    @Override
    protected Collection<Evento> obterTodos() {
        return eventoRepositorio.findAll();
    }

    @Override
    protected Evento obterPorId(Long id) {
        return eventoRepositorio.findById(id).get();
    }

    public void delete() { eventoRepositorio.deleteAll();}
}
