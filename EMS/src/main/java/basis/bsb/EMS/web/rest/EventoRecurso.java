package basis.bsb.EMS.web.rest;


import basis.bsb.EMS.servico.DTO.EventoDTO;
import basis.bsb.EMS.servico.DTO.ListaEventoDTO;
import basis.bsb.EMS.servico.EventoServico;
import basis.bsb.EMS.servico.filtro.EventoFiltro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/eventos")
public class EventoRecurso {

    private final EventoServico eventoServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ListaEventoDTO> BuscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(eventoServico.encontrarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ListaEventoDTO>> encontrarTodosOrdenado(){
        return ResponseEntity.ok(eventoServico.encontrarTodosOrdenado());
    }

    @PostMapping
    public ResponseEntity<EventoDTO> salvar(@RequestBody EventoDTO eventoDTO){
        return ResponseEntity.ok(eventoServico.salvar(eventoDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EventoDTO> editar(@RequestBody EventoDTO eventoDTO, @PathVariable Long id){
        eventoDTO.setId(id);
        eventoDTO = eventoServico.editar(eventoDTO);
        return ResponseEntity.ok(eventoDTO);
    }

    @PutMapping(value = "/adia/{id}")
    public ResponseEntity<List<EventoDTO>> adiar(@PathVariable Long id){
        return ResponseEntity.ok(eventoServico.adiaEvento(id));
    }

    @PutMapping(value = "/{id}/formata/{id}")
    public ResponseEntity<List<EventoDTO>> alteraEvento(@PathVariable Long id1, @PathVariable Long id2){
        eventoServico.trocaDataEvento(id1, id2);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        eventoServico.excluirEvento(id);
        return ResponseEntity.noContent().build();

    }
      
    @GetMapping(value = "filtro")
    public ResponseEntity<List<EventoDTO>> buscarTodosFiltro(EventoFiltro filtro){
        return ResponseEntity.ok(eventoServico.buscarTodosFiltro(filtro));

    }
}
