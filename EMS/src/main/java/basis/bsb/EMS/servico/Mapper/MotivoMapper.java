package basis.bsb.EMS.servico.Mapper;

import basis.bsb.EMS.dominio.Motivo;
import basis.bsb.EMS.servico.DTO.MotivoDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface MotivoMapper extends EntityMapper<MotivoDTO, Motivo>{

}
