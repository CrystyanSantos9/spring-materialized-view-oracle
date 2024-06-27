package com.cryss.springjpamaterializedview.repository;

import com.cryss.springjpamaterializedview.model.recursiveentity.Employee;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @EntityGraph(attributePaths = {"departments"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("""
            select e from Employee e
            """)
    List<Employee> findAllEmployeePaginated(PageRequest pageRequest);

//    @EntityGraph(attributePaths = {"children"}, type = EntityGraph.EntityGraphType.FETCH)
//    @Query("""
//            select c from Category c
//            """)
//    List<Category> findAllCategory(PageRequest pageRequest);
//
////    @EntityGraph(attributePaths = {"children"}, type = EntityGraph.EntityGraphType.FETCH)
////    @Query("""
////            select c from Category c
////            """)
////    List<Category> findAllCategoryPaginated(PageRequest pageRequest);
//
//    @EntityGraph(attributePaths = {"children"}, type = EntityGraph.EntityGraphType.FETCH)
//    @Query("""
//            select c from Category c
//            """)
//    Page<Category> findAllCategoryPaginated(Pageable pageable);

}

