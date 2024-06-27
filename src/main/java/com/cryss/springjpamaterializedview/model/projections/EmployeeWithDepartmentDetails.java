package com.cryss.springjpamaterializedview.model.projections;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

public interface EmployeeWithDepartmentDetails {
    @Value ("#{target.employee_id}")
    Long getEmployeeId();
    @Value("#{target.employee_name}")
    String getEmployeeName();
    String getEmail();
    @Value("#{target.department_name}")
    String getDepartmentName();
    @Value("#{target.start_time}")
    LocalDateTime getStartTime();
    @Value("#{target.end_time}")
    LocalDateTime getEndTime();
}
