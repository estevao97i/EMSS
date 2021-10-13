package basis.bsb.EMS.builder;

import basis.bsb.EMS.dominio.Cargo;
import basis.bsb.EMS.repositorio.CargoRepositorio;
import basis.bsb.EMS.servico.Mapper.CargoMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;

@Component
public class CargoBuilder extends ConstrutorDeEntidade<Cargo> {

    @Autowired
    private CargoMapper cargoMapper;

    @Autowired
    private CargoRepositorio cargoRepositorio;

    @Override
    protected Cargo construirEntidade() throws ParseException {
        Cargo cargo = new Cargo();
        cargo.setDescricao("fulano é xxy");
        return cargo;
    }

    @Override
    protected Cargo persistir(Cargo entidade) {
        return cargoRepositorio.save(entidade);
    }

    @Override
    protected Collection<Cargo> obterTodos() {
        return cargoRepositorio.findAll();
    }

    @Override
    protected Cargo obterPorId(Long id) {
        return cargoRepositorio.findById(id).get();
    }

    public void delete() { cargoRepositorio.deleteAll(); }
}
