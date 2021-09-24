package basis.bsb.EMS.builder;

import basis.bsb.EMS.dominio.Cargo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.util.Collection;

public class CargoBuilder extends ConstrutorDeEntidade<Cargo> {

    Cargo cargo = new Cargo();

    @Override
    protected Cargo construirEntidade() throws ParseException {
        cargo.setDescricao("fulano é xxy");
        return null;
    }

    @Override
    protected Cargo persistir(Cargo entidade) {
        return null;
    }

    @Override
    protected Collection<Cargo> obterTodos() {
        return null;
    }

    @Override
    protected Cargo obterPorId(Long id) {
        return null;
    }

}
