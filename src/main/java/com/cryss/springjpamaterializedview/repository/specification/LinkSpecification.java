//package com.cryss.tipsandlearnings.repository.specification;
//
//import com.cryss.tipsandlearnings.model.recursiveentity.CategoriaEnum;
//import com.cryss.tipsandlearnings.model.recursiveentity.Link;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Predicate;
//import jakarta.persistence.criteria.Root;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.data.jpa.domain.Specification;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//
//
//public class LinkSpecification implements Specification<Link> {
//
//    public String titulo;
//    public CategoriaEnum categoria;
//
//    public LinkSpecification(String titulo, CategoriaEnum categoria) {
//        this.titulo = titulo;
//        this.categoria = categoria;
//    }
//
//
//    @Override
//    public Predicate toPredicate(Root<Link> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//
//        List<Predicate> predicates = new ArrayList<> ();
//
//        if (StringUtils.isNotEmpty(this.titulo)) {
//            predicates.add(criteriaBuilder.like(root.get("titulo"), "%" + this.titulo + "%"));
//        }
//        if (Objects.nonNull(this.categoria)) {
//            predicates.add(criteriaBuilder.equal(root.get("categoria"), this.categoria));
//        }
//
//        return criteriaBuilder.and(predicates.stream().toArray(Predicate[]::new));
//    }
//
//
//}
