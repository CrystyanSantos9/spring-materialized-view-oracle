package com.cryss.springjpamaterializedview.repository;

import com.cryss.springjpamaterializedview.model.projections.EmployeeWithDepartmentDetails;
import com.cryss.springjpamaterializedview.model.recursiveentity.Employee;
import com.cryss.springjpamaterializedview.model.recursiveentity.EmployeeDepartment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeDepartmentJpaRepository extends JpaRepository<EmployeeDepartment, Long> {

//    @EntityGraph(attributePaths = {"departments"}, type = EntityGraph.EntityGraphType.FETCH)
@Query(
        value = "select * from employee_with_department_details",
        nativeQuery = true
)
List<EmployeeWithDepartmentDetails> getEmployeeWithDepartmentDetails(PageRequest pageRequest);

    /*
    The refresh materialized view statement does not return any result set,
    but Spring Data JPA expects one. To fix this, you need to annotate your method with @Modifying,
    which tells Spring Data JPA that the query is a DML statement and does not return any result.
    You can also use the clearAutomatically attribute to clear the persistence context after the query execution,
    which might be useful if you want to query the refreshed view afterwards.
     */
    @Modifying(clearAutomatically = true)
    @Transactional
    //use @Async instead!
    @Query(
            value = "BEGIN DBMS_MVIEW.REFRESH('employee_with_department_details'); END;",
            nativeQuery = true
    )
    void refreshEmployeeWithDepartmentDetails();

}

