package com.cryss.springjpamaterializedview.model.recursiveentity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "DEPARTMENT")
@Builder
public class Department implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, columnDefinition = "varchar2(255)")
    @Size(min = 2, max = 255)
    private String code;

    @Column(length = 255, columnDefinition = "varchar2(255)")
    @Size(min = 3, max = 255)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<EmployeeDepartment> employeeDepartmentList = new ArrayList<> ();


    @JsonIgnore
    public void addEmployeeDepartment(EmployeeDepartment employeeDepartment){
        if(Objects.nonNull (employeeDepartment)){
            employeeDepartment.setDepartment (this);
            this.employeeDepartmentList.add (employeeDepartment);
        }
    }

}
