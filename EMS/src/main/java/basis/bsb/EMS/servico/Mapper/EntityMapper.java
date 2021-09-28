package basis.bsb.EMS.servico.Mapper;

import java.util.List;

public interface EntityMapper <D,E>{

    E toEntity(D dto);

    D toDTO(E entity);

    List<E> toEntity(List<D> DTOList);

    List<D> toDTO(List<E> entityList);
}
