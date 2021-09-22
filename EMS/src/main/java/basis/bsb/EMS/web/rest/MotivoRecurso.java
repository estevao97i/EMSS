package basis.bsb.EMS.web.rest;


import basis.bsb.EMS.servico.DTO.MotivoDTO;
import basis.bsb.EMS.servico.MotivoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/motivos")
public class MotivoRecurso {

    private final MotivoServico motivoServico;

    @PostMapping
    public ResponseEntity<MotivoDTO> inserir(@RequestBody MotivoDTO motivoDTO){
        return ResponseEntity.ok(motivoServico.salvarMotivo(motivoDTO));
    }
}
