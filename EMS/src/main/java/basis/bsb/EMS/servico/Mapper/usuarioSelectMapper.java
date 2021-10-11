package basis.bsb.EMS.servico.Mapper;
import basis.bsb.EMS.dominio.Usuario;
import basis.bsb.EMS.servico.DTO.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface usuarioSelectMapper extends EntityMapper<SelectDTO, Usuario> {

    @Mapping(source= "id", target = "value")
    @Mapping(source = "nome", target="label")
    SelectDTO toDTO(Usuario usuario);

    @InheritInverseConfiguration
    Usuario toEntity(SelectDTO select);
}
