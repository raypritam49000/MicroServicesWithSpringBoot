package com.employee.service;

import com.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployee(Long id);
    public Boolean deleteEmployee(Long id);
    public Employee updateEmployee(Long id,Employee employee);
}
