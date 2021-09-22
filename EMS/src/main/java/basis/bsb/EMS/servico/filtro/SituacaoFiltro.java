package basis.bsb.EMS.servico.filtro;

import basis.bsb.EMS.dominio.Situacao;
import basis.bsb.EMS.dominio.Situacao_;
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

public class SituacaoFiltro implements EntityFiltro<Situacao> {

    private Long id;
    private String descricao;

    @Override
    public Specification<Situacao> filter(){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.and(getPredicates(root, query, criteriaBuilder)
                .toArray(new Predicate[0])));
    }
    private List<Predicate> getPredicates(Root<Situacao> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(Situacao_.id)));

        if (id != null){
            predicates.add(criteriaBuilder.equal(root.get(Situacao_.id),id));
        }

        if (descricao != null){
            predicates.add(criteriaBuilder.equal(root.get(Situacao_.descricao),
                    "%" + descricao + "%"));
        }
        return predicates;
    }
}
