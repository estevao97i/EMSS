package basis.bsb.EMS.servico;


import basis.bsb.EMS.dominio.Motivo;
import basis.bsb.EMS.repositorio.MotivoRepositorio;
import basis.bsb.EMS.servico.DTO.MotivoDTO;
import basis.bsb.EMS.servico.Mapper.MotivoMapper;
import basis.bsb.EMS.servico.excecao.ObjectnotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MotivoServico implements Serializable {

    private final MotivoMapper motivoMapper;
    private final MotivoRepositorio motivoRepositorio;

    public List<MotivoDTO> ListaTodosMotivos(){
        return motivoMapper.toDTO(motivoRepositorio.findAll());
    }

    public MotivoDTO ListarPorId(Long id){
        return motivoMapper.toDTO(motivoRepositorio.findById(id).orElseThrow(ObjectnotFoundException::new));
    }

    public MotivoDTO salvarMotivo(MotivoDTO motivoDTO){
        Motivo motivo = motivoMapper.toEntity(motivoDTO);
        Motivo motivoSalva = motivoRepositorio.save(motivo);
        return motivoMapper.toDTO(motivoSalva);
    }

    public MotivoDTO editarMotivo(MotivoDTO motivoDTO){
        Motivo motivo = motivoMapper.toEntity(motivoDTO);
        Motivo motivoSalva = motivoRepositorio.save(motivo);
        return motivoMapper.toDTO(motivoSalva);
    }

    public void deletarMotivo(Long id){
        motivoRepositorio.deleteById(id);
    }
}
