package basis.bsb.EMS.builder;

import basis.bsb.EMS.dominio.Situacao;
import basis.bsb.EMS.repositorio.SituacaoRepositorio;
import basis.bsb.EMS.servico.Mapper.SituacaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;

@Component
public class SituacaoBuilder extends ConstrutorDeEntidade<Situacao> {

    @Autowired
    private SituacaoMapper situacaoMapper;

    @Autowired
    private SituacaoRepositorio situacaoRepositorio;

    @Override
    protected Situacao construirEntidade() throws ParseException {
        Situacao situacao = new Situacao();
        situacao.setDescricao("Situacao teste");
        return situacao;
    }

    @Override
    protected Situacao persistir(Situacao entidade) {
        return situacaoRepositorio.save(entidade);
    }

    @Override
    protected Collection<Situacao> obterTodos() {
        return situacaoRepositorio.findAll();
    }

    @Override
    protected Situacao obterPorId(Long id) {
        return situacaoRepositorio.findById(id).get();
    }

    public void delete() {situacaoRepositorio.deleteAll();}
}