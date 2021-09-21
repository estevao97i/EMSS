//package basis.bsb.EMS.servico.filtro;
//
//import basis.bsb.EMS.dominio.Evento;
//import basis.bsb.EMS.dominio.Evento_;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.data.jpa.domain.Specification;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//@Setter
//public class EventoFiltro implements EntityFiltro<Evento> {
//
//    private Long id;
//    private String data_evento;
//
//    @Override
//    public Specification<Evento> filter() {
//        return (root, query, criteriaBuilder) -> criteriaBuilder.and(getPredicates(root, query, criteriaBuilder)
//                .toArray(new Predicate[0]));
//    }
//
//    private List<Predicate> getPredicates(Root<Evento> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//
//        List<Predicate> predicates = new ArrayList<>();
//        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(Evento_.id)));
//
//        if (id != null) {
//            predicates.add(criteriaBuilder.equal(root.get(Evento_.id), id));
//        }
//
//        if(data_evento != null){
//            predicates.add(criteriaBuilder.like(root.get(Evento_.DATA_EVENTO), data_evento));
//        }
//
//        return predicates;
//    }
//}