package basis.bsb.EMS.builder;

import basis.bsb.EMS.dominio.Situacao;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.util.Collection;

public class SituacaoBuilder extends ConstrutorDeEntidade<Situacao> {

    Situacao situacao = new Situacao();

    @Override
    protected Situacao construirEntidade() throws ParseException {
        situacao.setDescricao("Situacao teste");
        return null;
    }

    @Override
    protected Situacao persistir(Situacao entidade) {
        return null;
    }

    @Override
    protected Collection<Situacao> obterTodos() {
        return null;
    }

    @Override
    protected Situacao obterPorId(Long id) {
        return null;
    }

}