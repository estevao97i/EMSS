package basis.bsb.EMS.servico;


import basis.bsb.EMS.repositorio.CargoRepositorio;
import basis.bsb.EMS.servico.DTO.SelectDTO;
import basis.bsb.EMS.servico.Mapper.CargoMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CargoServico {

    private final CargoMapper cargoMapper;
    private final CargoRepositorio cargoRepositorio;

    public List<SelectDTO> listaTodos(){
        return cargoMapper.toDTO(cargoRepositorio.findAll());
    }
}
