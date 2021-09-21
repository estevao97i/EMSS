package basis.bsb.EMS.servico.Mapper;


import basis.bsb.EMS.dominio.Usuario;
import basis.bsb.EMS.servico.DTO.UsuarioEditaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CargoMapper.class})
public interface UsuarioEditaMapper extends EntityMapper<UsuarioEditaDTO, Usuario>{
}
