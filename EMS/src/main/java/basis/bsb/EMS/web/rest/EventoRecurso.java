package basis.bsb.EMS.web.rest;


import basis.bsb.EMS.servico.DTO.EventoDTO;
import basis.bsb.EMS.servico.EventoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/eventos")
public class EventoRecurso {

    private final EventoServico eventoServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EventoDTO> BuscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(eventoServico.encontrarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<EventoDTO>> BuscarTotos(){
        return ResponseEntity.ok(eventoServico.encontrarTodos());
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
