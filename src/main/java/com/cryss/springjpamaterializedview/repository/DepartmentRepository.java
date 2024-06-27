package com.cryss.springjpamaterializedview.repository;

import com.cryss.springjpamaterializedview.model.projections.EmployeeWithDepartmentDetails;
import com.cryss.springjpamaterializedview.model.recursiveentity.Department;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @EntityGraph(attributePaths = {"employeeDepartmentList"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT d FROM Department d")
    List<Department> findAllDepartmentPaginated(PageRequest pageRequest);



//    @Query("SELECT product FROM Product product JOIN FETCH product.categories categories JOIN FETCH categories.children")
//    List<Product> findProductAndCategories();
//
////    @Query("SELECT new com.cryss.tipsandlearnings.model.response.ProductResponseDTO(product.id, product.name, product.categories) FROM Product AS product JOIN FETCH product.categories")
////    Page<ProductResponseDTO> findProductAndCategoriesPaginated(Pageable pageable);
//
//    @Query("SELECT product FROM Product product JOIN FETCH product.categories WHERE product IN :products")
//    List<Product> findProductAndCategoriesPaginatedCorrect(List<Product> products);
//
}
