package basis.bsb.EMS.web.rest;


import basis.bsb.EMS.servico.CargoServico;
import basis.bsb.EMS.servico.DTO.SelectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/cargos")
public class CargoRecurso {

    private final CargoServico cargoServico;

    @GetMapping
    public ResponseEntity<List<SelectDTO>> buscarTodos(){
        return ResponseEntity.ok(cargoServico.listaTodos());
    }

}
