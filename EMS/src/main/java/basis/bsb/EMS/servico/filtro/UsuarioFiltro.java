package basis.bsb.EMS.servico.filtro;

import basis.bsb.EMS.dominio.Usuario;
import basis.bsb.EMS.dominio.Usuario_;
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
public class UsuarioFiltro implements EntityFiltro<Usuario>{

    private Long id;
    private String name;
    private String cargo;

    @Override
    public Specification<Usuario> filter(){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.and(getPredicates(root,query,criteriaBuilder)
                .toArray(new Predicate[0])));
    }

    private List<Predicate> getPredicates(Root<Usuario> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(Usuario_.id)));

        return predicates;
    }

}
