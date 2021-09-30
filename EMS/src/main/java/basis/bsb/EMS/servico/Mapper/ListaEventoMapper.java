package basis.bsb.EMS.servico.Mapper;


import basis.bsb.EMS.dominio.Evento;
import basis.bsb.EMS.servico.DTO.ListaEventoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SituacaoMapper.class, MotivoMapper.class, ListaUsuarioMapper.class})
public interface ListaEventoMapper extends EntityMapper<ListaEventoDTO,Evento>{
}
