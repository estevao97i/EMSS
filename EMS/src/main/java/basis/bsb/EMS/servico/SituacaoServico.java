package basis.bsb.EMS.servico;


import basis.bsb.EMS.repositorio.SituacaoRepositorio;
import basis.bsb.EMS.servico.DTO.SelectDTO;
import basis.bsb.EMS.servico.Mapper.SituacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SituacaoServico {

    private final SituacaoMapper situacaoMapper;
    private final SituacaoRepositorio situacaoRepositorio;

    public List<SelectDTO> buscarTodos(){
        return situacaoMapper.toDTO(situacaoRepositorio.findAll());
    }
}
