package basis.bsb.EMS.servico;

import basis.bsb.EMS.dominio.Evento;
import basis.bsb.EMS.repositorio.EventoRepositorio;
import basis.bsb.EMS.servico.excecao.ObjectnotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class EventoServico {

    private final EventoRepositorio eventoRepositorio;

    public Evento encontrarPorId(Long id) {
        return eventoRepositorio.findById(id).orElseThrow(()-> new ObjectnotFoundException("Evento não Encontrado!: " +id));
    }

    public List<Evento> encontrarPorTodos(){
        return eventoRepositorio.findAll();
    }

    public Evento salvar (Evento evento) {
        return eventoRepositorio.save(evento);
    }

    public Evento editar (Evento evento) {
        return eventoRepositorio.save(evento);
    }

    public void deletar(Long id) {
        eventoRepositorio.deleteById(id);
    }
    
}
