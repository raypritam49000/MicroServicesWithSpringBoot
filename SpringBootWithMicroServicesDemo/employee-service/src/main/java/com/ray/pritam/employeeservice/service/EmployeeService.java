package com.ray.pritam.employeeservice.service;

import java.util.List;

import com.ray.pritam.employeeservice.model.EmployeeDto;

public interface EmployeeService {
    public List<EmployeeDto> getEmployees();
    public EmployeeDto getEmployee(Long employeeId);
    public EmployeeDto createEmployee(EmployeeDto employeedDto);
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeedDto); 
    public Boolean deleteEmployee(Long employeeId);
}
