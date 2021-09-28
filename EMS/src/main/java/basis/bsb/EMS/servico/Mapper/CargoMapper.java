package basis.bsb.EMS.servico.Mapper;


import basis.bsb.EMS.dominio.Cargo;
import basis.bsb.EMS.dominio.Evento;
import basis.bsb.EMS.servico.DTO.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface CargoMapper extends EntityMapper<SelectDTO, Cargo> {

    @Mapping(source = "id", target = "value")
    @Mapping(source = "descricao", target = "label")
    SelectDTO toDTO(Cargo cargo);

    @InheritInverseConfiguration
    Cargo toEntity(SelectDTO dto);
}
