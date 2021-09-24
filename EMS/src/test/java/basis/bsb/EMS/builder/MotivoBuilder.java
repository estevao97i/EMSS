package basis.bsb.EMS.builder;

import basis.bsb.EMS.dominio.Motivo;
import basis.bsb.EMS.repositorio.MotivoRepositorio;
import basis.bsb.EMS.servico.Mapper.MotivoMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;

@Component
public class MotivoBuilder extends ConstrutorDeEntidade<Motivo> {

    @Autowired
    private MotivoMapper motivoMapper;

    @Autowired
    private MotivoRepositorio motivoRepositorio;

    @Override
    protected Motivo construirEntidade() throws ParseException {
        Motivo motivo = new Motivo();
        motivo.setDescricao("Ferias");
        return motivo;
    }

    @Override
    protected Motivo persistir(Motivo entidade) {
        return motivoRepositorio.save(entidade);
    }

    @Override
    protected Collection<Motivo> obterTodos() {
        return motivoRepositorio.findAll();
    }

    @Override
    protected Motivo obterPorId(Long id) {
        return motivoRepositorio.findById(id).get();
    }

    public void delete(){
        motivoRepositorio.deleteAll();
    }
}

