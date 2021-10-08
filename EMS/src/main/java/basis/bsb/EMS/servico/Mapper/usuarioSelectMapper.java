package basis.bsb.EMS.servico.Mapper;
import basis.bsb.EMS.dominio.Usuario;
import basis.bsb.EMS.servico.DTO.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface usuarioSelectMapper extends EntityMapper<Usuario, SelectDTO> {

    @Mapping(source= "id", target = "value")
    @Mapping(source = "nome", target="label")
    SelectDTO toEntity(Usuario usuario);

    @InheritInverseConfiguration
    Usuario toDTO(SelectDTO select);
}
