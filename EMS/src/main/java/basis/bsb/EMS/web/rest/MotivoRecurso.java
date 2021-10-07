package basis.bsb.EMS.web.rest;


import basis.bsb.EMS.servico.DTO.MotivoDTO;
import basis.bsb.EMS.servico.MotivoServico;
import basis.bsb.EMS.servico.filtro.MotivoFiltro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/motivos")
public class MotivoRecurso {

    private final MotivoServico motivoServico;

    @PostMapping
    public ResponseEntity<MotivoDTO> inserir(@RequestBody MotivoDTO motivoDTO){
        return ResponseEntity.ok(motivoServico.salvarMotivo(motivoDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MotivoDTO> editar(@RequestBody MotivoDTO motivoDTO, @PathVariable Long id){
        motivoDTO.setId(id);
        return ResponseEntity.ok(motivoServico.editarMotivo(motivoDTO));
    }

    @GetMapping
    public ResponseEntity<List<MotivoDTO>> listarTodos(){
        return ResponseEntity.ok(motivoServico.ListaTodosMotivos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MotivoDTO> listarPorId(@PathVariable Long id){
        return ResponseEntity.ok(motivoServico.ListarPorId(id));
    }

    @GetMapping(value ="filtro")
    public ResponseEntity<List<MotivoDTO>> buscarTodosFiltro(MotivoFiltro filtro){
        return ResponseEntity.ok(motivoServico.buscarTodosFiltro(filtro));
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> deletarMotivo(@PathVariable Long id){
        motivoServico.deletarMotivo(id);
        return ResponseEntity.noContent().build();
    }


}



