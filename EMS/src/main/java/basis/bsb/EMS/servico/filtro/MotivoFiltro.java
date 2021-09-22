package basis.bsb.EMS.servico.filtro;

import basis.bsb.EMS.dominio.Motivo;
import basis.bsb.EMS.dominio.Motivo_;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MotivoFiltro implements EntityFiltro<Motivo> {

    private Long id;
    private String descricao;

    @Override
    public Specification<Motivo> filter(){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.and(getPredicates(root, query, criteriaBuilder)
                .toArray(new Predicate[0])));
    }
    private List<Predicate> getPredicates(Root<Motivo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(Motivo_.id)));


        if (descricao != null){
            predicates.add(criteriaBuilder.like(root.get(Motivo_.descricao),
                    "%" + descricao + "%"));
        }

        if (id != null){
            predicates.add(criteriaBuilder.equal(root.get(Motivo_.id),id));
        }
        return predicates;
    }
}

