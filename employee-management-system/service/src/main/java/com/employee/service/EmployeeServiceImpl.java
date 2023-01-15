package com.employee.service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        employeeRepository.delete(employeeRepository.findById(id).get());
        return true;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).get();
        Employee updateEmployee = null;
        if (existingEmployee != null) {
            existingEmployee.setCity(employee.getCity());
            existingEmployee.setName(employee.getName());
            existingEmployee.setSalary(employee.getSalary());
            updateEmployee = this.employeeRepository.save(updateEmployee);
        }
        return updateEmployee;
    }
}
