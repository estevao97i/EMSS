package servico;

import basis.bsb.EMS.dominio.Cargo;
import basis.bsb.EMS.repositorio.CargoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CargoServico {

    private final CargoRepositorio cargoRepositorio;

    public List<Cargo> TodosCargo(){
       return cargoRepositorio.findAll();
    }
}
