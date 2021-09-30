package basis.bsb.EMS.web.rest;


import basis.bsb.EMS.servico.DTO.SelectDTO;
import basis.bsb.EMS.servico.SituacaoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/situacoes")
public class SituacaoRecurso {

    private final SituacaoServico situacaoServico;

    @GetMapping
    public ResponseEntity<List<SelectDTO>> buscarTodos(){
        return ResponseEntity.ok(situacaoServico.buscarTodos());
    }
}
