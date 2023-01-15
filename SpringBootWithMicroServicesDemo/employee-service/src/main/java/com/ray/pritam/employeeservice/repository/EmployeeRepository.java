package com.ray.pritam.employeeservice.repository;

import com.ray.pritam.employeeservice.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    
}
