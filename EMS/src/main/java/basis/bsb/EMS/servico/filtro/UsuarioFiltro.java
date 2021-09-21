//package basis.bsb.EMS.servico.filtro;

import basis.bsb.EMS.dominio.Cargo_;
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
//import java.util.List;
//
//
//
//@Getter
//@Setter
//public class UsuarioFiltro implements EntityFiltro<Usuario>{
//
//    private Long id;
//    private String nome;
//    private String cargo;
//    private String cpf;
//
//    @Override
//    public Specification<Usuario> filter(){
//        return (root, query, criteriaBuilder) -> criteriaBuilder.and(getPredicates(root,query,criteriaBuilder)
//                .toArray(new Predicate[0]));
//    }
//
//    private List<Predicate> getPredicates(Root<Usuario> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//
//        List<Predicate> predicates = new ArrayList<>();
//        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(Usuario_.id)));
//
//        if(nome != null){
//            predicates.add(criteriaBuilder.like(root.get(Usuario_.NOME),"%" + nome +"%"));
//        }
//
//        if (cpf != null){
//            predicates.add(criteriaBuilder.like(root.get(Usuario_.CPF),"%" + cpf + "%"));
//        }
//
//        if(cargo != null){
//            predicates.add(criteriaBuilder.like(root.join("cargo").get(String.valueOf(Cargo_.descricao)),"%" + cargo + "%"));
//        }
//
//        if(id != null){
//            predicates.add(criteriaBuilder.equal(root.get(Usuario_.id),id));
//        }
//
//        return predicates;
//    }
//
//}
