package basis.bsb.EMS.servico.Mapper;

import basis.bsb.EMS.dominio.Motivo;
import basis.bsb.EMS.servico.DTO.MotivoDTO;
import basis.bsb.EMS.servico.DTO.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {})
public interface MotivoMapper extends EntityMapper<MotivoDTO, Motivo>{

}
