package com.ray.pritam.employeeservice.controller;

import java.util.List;
import java.util.Map;

import com.ray.pritam.employeeservice.model.EmployeeDto;
import com.ray.pritam.employeeservice.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    private ResponseEntity<?> getAllEmployees() {
        try {
            List<EmployeeDto> employeeDtos = this.employeeService.getEmployees();

            System.out.println(employeeDtos);

            if (employeeDtos.size() > 0 && employeeDtos != null) {
                return ResponseEntity.ok(Map.of("message", "Employee List", "statusCode",200, "data",
                        employeeDtos, "isSuccess", true));
            } else {
                return ResponseEntity.ok(Map.of("message", "Data Not Found", "statusCode", 404, "data",
                employeeDtos, "isSuccess", false));
            }

        } catch (Exception e) {
            return ResponseEntity.ok(Map.of("message", e.getMessage(), "statusCode",501,"isSuccess", false));
        }
    }

}
