package basis.bsb.EMS.servico;

import basis.bsb.EMS.dominio.Evento;
import basis.bsb.EMS.repositorio.EventoRepositorio;
import basis.bsb.EMS.servico.DTO.EmailDTO;
import basis.bsb.EMS.servico.DTO.EventoDTO;
import basis.bsb.EMS.servico.Mapper.EventoMapper;
import basis.bsb.EMS.servico.excecao.ObjectnotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Transactional
@RequiredArgsConstructor
@Service
public class EventoServico {

    private final EventoRepositorio eventoRepositorio;
    private final EventoMapper eventoMapper;
    private final EmailServico emailServico;

    public EventoDTO encontrarPorId(Long id) {
        Evento evento = eventoRepositorio.findById(id).orElseThrow(() -> new ObjectnotFoundException("Evento nãp encontrado!" + id));
        return eventoMapper.toDTO(evento);
    }

    public List<EventoDTO> encontrarTodos(){
        return eventoMapper.toDTO(eventoRepositorio.findAll());
    }

    public boolean validaEvento(EventoDTO eventoDTO){
        if(!eventoRepositorio.existsByDataEvento(eventoDTO.getDataEvento())){
            return true;
        }
        throw new ObjectnotFoundException("Dois eventos não podem ser cadastrados no mesmo dia" + eventoDTO.getDataEvento());

    }

    public EventoDTO salvar (EventoDTO eventoDTO) {
        if(validaEvento(eventoDTO)){
            Evento evento = eventoMapper.toEntity(eventoDTO);
            Evento eventoSalva = eventoRepositorio.save(evento);
            evento.getDataEvento().plusWeeks(1);
            return eventoMapper.toDTO(eventoSalva);
        }
        throw new ObjectnotFoundException("Não pode salvar Evento" + eventoDTO.getDataEvento());

    }

    public EventoDTO editar (EventoDTO eventoDTO) {
        Evento evento = eventoMapper.toEntity(eventoDTO);
        Evento eventoAtualiza = eventoRepositorio.save(evento);
        return eventoMapper.toDTO(eventoAtualiza);
    }


    public void ativarEvento(Long id){
        EventoDTO eventoDTO = encontrarPorId(id);
        eventoDTO.setStatus(true);
        editar(eventoDTO);
    }

    public void inativarEvento(Long id){
        EventoDTO eventoDTO = encontrarPorId(id);
        eventoDTO.setStatus(false);
        editar(eventoDTO);
    }

    @Scheduled(cron = "* * * * * 7")
    public void rotinaDeEmail(){
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setDestinatario("projeto.formacaobsb@gmail.com");
        emailDTO.setAssunto("");
        emailDTO.setCorpo("");
        emailDTO.getCopias().add("");

        emailServico.sendEmail(emailDTO);

    }



}
