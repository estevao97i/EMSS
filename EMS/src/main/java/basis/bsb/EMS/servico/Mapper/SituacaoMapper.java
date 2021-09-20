package basis.bsb.EMS.servico.Mapper;

import basis.bsb.EMS.dominio.Situacao;
import basis.bsb.EMS.servico.DTO.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface SituacaoMapper extends EntityMapper<SelectDTO, Situacao> {

    @Mapping(source = "id", target = "value")
    @Mapping(source = "situacao", target = "label")
    SelectDTO toDTO(Situacao situacao);

    @InheritInverseConfiguration
    Situacao toEntity(SelectDTO dto);
}
