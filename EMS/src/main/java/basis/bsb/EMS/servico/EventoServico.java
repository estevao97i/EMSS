package basis.bsb.EMS.servico;

import basis.bsb.EMS.dominio.Evento;
import basis.bsb.EMS.repositorio.EventoRepositorio;
import basis.bsb.EMS.servico.DTO.EmailDTO;
import basis.bsb.EMS.servico.DTO.EventoDTO;
import basis.bsb.EMS.servico.DTO.UsuarioDTO;
import basis.bsb.EMS.servico.Mapper.EventoMapper;
import basis.bsb.EMS.servico.excecao.ObjectnotFoundException;
import basis.bsb.EMS.servico.filtro.EventoFiltro;
import basis.bsb.EMS.servico.filtro.UsuarioFiltro;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;

import java.io.Serializable;

import java.util.List;



@Transactional
@RequiredArgsConstructor
@Service
public class EventoServico implements Serializable {

    private final EventoRepositorio eventoRepositorio;
    private final EventoMapper eventoMapper;
    private final EmailServico emailServico;
    private final EventoFiltro eventoFiltro;

    public EventoDTO encontrarPorId(Long id) {
        Evento evento = eventoRepositorio.findById(id).orElseThrow(() -> new ObjectnotFoundException("Evento nãp encontrado!" + id));
        return eventoMapper.toDTO(evento);
    }

    public List<EventoDTO> encontrarTodosOrdenado() {
        return eventoMapper.toDTO(eventoRepositorio.OrderByDate());
    }

    public boolean validaEvento(EventoDTO eventoDTO) {
        if (!eventoRepositorio.existsByDataEvento(eventoDTO.getDataEvento())) {
            return true;
        }
        throw new ObjectnotFoundException("Dois eventos não podem ser cadastrados no mesmo dia" + eventoDTO.getDataEvento());

    }

//    public void realocaEvento(EventoDTO eventoDTO){
//        List<EventoDTO> listaEvento = encontrarTodos();
//        for (EventoDTO data: listaEvento) {
//            if (eventoDTO.getDataEvento())
//        }
//    }

    public EventoDTO salvar(EventoDTO eventoDTO) {
        if (validaEvento(eventoDTO)) {
            Evento evento = eventoMapper.toEntity(eventoDTO);
            Evento eventoSalva = eventoRepositorio.save(evento);
//            evento.getDataEvento().plusWeeks(1);
            return eventoMapper.toDTO(eventoSalva);
        }
        throw new ObjectnotFoundException("Não pode salvar Evento" + eventoDTO.getDataEvento());

    }

    public EventoDTO editar(EventoDTO eventoDTO) {
        Evento evento = eventoMapper.toEntity(eventoDTO);
        Evento eventoAtualiza = eventoRepositorio.save(evento);
        return eventoMapper.toDTO(eventoAtualiza);
    }

    public List<EventoDTO> trocaDataEvento(Long id1, Long id2) {
        Evento evento1 = eventoRepositorio.findById(id1).orElseThrow(() -> new ObjectnotFoundException(""));
        Evento evento2 = eventoRepositorio.findById(id2).orElseThrow(() -> new ObjectnotFoundException(""));

        if (!evento1.getSituacao().equals(2) || !evento1.getSituacao().equals(3) && !evento2.getSituacao().equals(2)
                || !evento2.getSituacao().equals(3)) {
            LocalDate data1 = evento1.getDataEvento();
            LocalDate data2 = evento2.getDataEvento();

            evento1.setDataEvento(data2);
            evento2.setDataEvento(data1);

            eventoRepositorio.save(evento1);
            eventoRepositorio.save(evento2);

            return eventoMapper.toDTO(eventoRepositorio.findAll());
        }
        throw new ObjectnotFoundException("Não pode realizar a troca de Datas entre eventos" + evento1.getDataEvento() + evento2.getDataEvento());


    }

    public List<EventoDTO> adiaEvento(Long id) {
        Evento evento = eventoRepositorio.findById(id).orElseThrow(() -> new ObjectnotFoundException(""));
        LocalDate dataEvento = evento.getDataEvento();
        for (Evento l : eventoRepositorio.OrderByDateAdiamento(dataEvento)) {
            l.setDataEvento(l.getDataEvento().plusWeeks(1));
            eventoRepositorio.save(l);
        }
        return eventoMapper.toDTO(eventoRepositorio.OrderByDate());
    }

        @Scheduled(cron = "00 01 16 * * *")
        public void rotinaDeEmail() {
            EmailDTO emailDTO = new EmailDTO();
            emailDTO.setDestinatario("projeto.formacaobsb@gmail.com");
            emailDTO.setAssunto("teste ");
            emailDTO.setCorpo("esta funcionando!!!!");
            emailDTO.getCopias().add("projeto.formacaobsb@gmail.com");

            emailServico.sendEmail(emailDTO);

        }

    public List<EventoDTO> buscarTodosFiltro(UsuarioFiltro usuarioFiltro) {
        return eventoMapper.toDTO(eventoRepositorio.findAll(eventoFiltro.filter()));
    }

//
    public void excluirEvento(Long id){
        eventoRepositorio.deleteById(id);
    }


    }

