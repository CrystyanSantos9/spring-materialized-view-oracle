//package com.cryss.tipsandlearnings.repository;
//
//import com.cryss.tipsandlearnings.model.recursiveentity.Category;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class CategoryInsertRepository {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Transactional
//    public void insertWithQuery(Category category) {
//      this.entityManager.createNativeQuery("INSERT INTO category (ID, NAME, parentCategory) VALUES (?,?,?)")
//                .setParameter(1, category.getId())
//                .setParameter(2, category.getName ())
//                .setParameter(3, category.getParentCategory ())
//                .executeUpdate ();
//    }
//
//}
//
