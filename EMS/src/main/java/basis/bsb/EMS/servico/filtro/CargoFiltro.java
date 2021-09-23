package basis.bsb.EMS.servico.filtro;

import basis.bsb.EMS.dominio.Cargo;
import basis.bsb.EMS.dominio.Cargo_;
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

public class CargoFiltro implements EntityFiltro<Cargo> {

    private Long id;
    private String descricao;

    @Override
    public Specification<Cargo> filter(){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.and(getPredicates(root, query, criteriaBuilder)
                .toArray(new Predicate[0])));
    }
    private List<Predicate> getPredicates(Root<Cargo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(Cargo_.id)));

        if (descricao != null){
            predicates.add(criteriaBuilder.like(root.get(Cargo_.descricao),
                "%" + descricao + "%"));
        }

        if (id != null){
            predicates.add(criteriaBuilder.equal(root.get(Cargo_.id),id));
        }
        return predicates;
    }
}
