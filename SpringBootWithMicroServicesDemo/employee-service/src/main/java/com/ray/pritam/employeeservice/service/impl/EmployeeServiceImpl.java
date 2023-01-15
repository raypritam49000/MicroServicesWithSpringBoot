package com.ray.pritam.employeeservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.ray.pritam.employeeservice.entity.Employee;
import com.ray.pritam.employeeservice.model.EmployeeDto;
import com.ray.pritam.employeeservice.repository.EmployeeRepository;
import com.ray.pritam.employeeservice.service.EmployeeService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeList = employees.stream()
                .map((employee) -> this.modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
        return employeeList;
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {
        Employee employee = this.employeeRepository.findById(employeeId).get();
        EmployeeDto employeeDto = this.modelMapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeedDto) {
        Employee employee = this.modelMapper.map(employeedDto, Employee.class);
        Employee savedEmployee = this.employeeRepository.save(employee);
        return this.modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeedDto) {
        Employee employee = this.employeeRepository.findById(employeeId).get();
        Employee updateEmployee = null;
        if (employee != null) {
            employee.builder().city(employeedDto.getCity()).email(employeedDto.getEmail()).name(employeedDto.getName())
                    .phone(employeedDto.getPhone());
            updateEmployee = this.employeeRepository.save(employee);
        }
        return this.modelMapper.map(updateEmployee, EmployeeDto.class);
    }

    @Override
    public Boolean deleteEmployee(Long employeeId) {
        Boolean isDeleted = false;
        Employee employee = this.employeeRepository.findById(employeeId).get();
        if (employee != null) {
            this.employeeRepository.delete(employee);
            isDeleted = true;
        }

        return isDeleted;
    }

}
