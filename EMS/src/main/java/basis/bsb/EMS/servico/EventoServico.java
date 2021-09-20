package basis.bsb.EMS.servico;

import basis.bsb.EMS.dominio.Evento;
import basis.bsb.EMS.repositorio.EventoRepositorio;
import basis.bsb.EMS.servico.DTO.EventoDTO;
import basis.bsb.EMS.servico.Mapper.EventoMapper;
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
    private final EventoMapper eventoMapper;

    public EventoDTO encontrarPorId(Long id) {
        Evento evento = eventoRepositorio.findById(id).orElseThrow(() -> new ObjectnotFoundException("Evento nãp encontrado!" + id));
        return eventoMapper.toDTO(evento);
    }

    public List<EventoDTO> encontrarTodos(){
        return eventoMapper.toDTO(eventoRepositorio.findAll());
    }

    public EventoDTO salvar (EventoDTO eventoDTO) {
        Evento evento = eventoMapper.toEntity(eventoDTO);
        Evento eventoSalva = eventoRepositorio.save(evento);
        return eventoMapper.toDTO(eventoSalva);
    }

    public EventoDTO editar (EventoDTO eventoDTO) {
        Evento evento = eventoMapper.toEntity(eventoDTO);
        Evento eventoAtualiza = eventoRepositorio.save(evento);
        return eventoMapper.toDTO(eventoAtualiza);
    }

    public void deletar(Long id) {
        eventoRepositorio.deleteById(id);
    }
    
}
