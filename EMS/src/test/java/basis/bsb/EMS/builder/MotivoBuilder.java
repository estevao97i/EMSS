package basis.bsb.EMS.builder;

import basis.bsb.EMS.dominio.Motivo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.util.Collection;

public class MotivoBuilder extends ConstrutorDeEntidade<Motivo> {

    Motivo motivo = new Motivo();

    @Override
    protected Motivo construirEntidade() throws ParseException {
        motivo.setDescricao("");
        return null;
    }

    @Override
    protected Motivo persistir(Motivo entidade) {
        return null;
    }

    @Override
    protected Collection<Motivo> obterTodos() {
        return null;
    }

    @Override
    protected Motivo obterPorId(Long id) {
        return null;
    }

}

