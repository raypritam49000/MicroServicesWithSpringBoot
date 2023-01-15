package com.employee.controllers;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.employee.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Response> getAllEmployees() {
        try {
            List<Employee> employees = employeeService.getAllEmployees();

            if (employees.isEmpty() || employees == null || employees.size() <= 0) {
                return new ResponseEntity<Response>(new Response("Employee Not Found", "NOT_FOUND", 404, false, new ArrayList<>()), HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Response>(new Response("Employee List", "SUCCESS", 200, true, employees), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<Response>(new Response(exception.getMessage(),"INTERNAL_SERVER_ERROR",501,false,new ArrayList<>()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getEmployee(@PathVariable("id") Long id) {
        try {
            Employee employee = employeeService.getEmployee(id);

            if (employee == null || employee.getName().equals("") || employee.getCity().equals("") || employee.getSalary().equals("")) {
                return new ResponseEntity<Response>(new Response("Employee Not Found", "NOT_FOUND", 404, false, new ArrayList<>()), HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Response>(new Response("Employee List", "SUCCESS", 200, true, List.of(employee)), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<Response>(new Response(exception.getMessage(),"INTERNAL_SERVER_ERROR",501,false,new ArrayList<>()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Response> createEmployee(@RequestBody Employee employee) {
        try {
            if (employee == null || employee.getName().equals("") || employee.getCity().equals("") || employee.getSalary().equals("")) {
                return new ResponseEntity<Response>(new Response("All Parameters are required !!! ", "BAD_REQUEST", 401, false, new ArrayList<>()), HttpStatus.BAD_REQUEST);
            }
            Employee createEmployee = employeeService.createEmployee(employee);

            if(createEmployee!=null && !employee.getName().equals("") && !employee.getCity().equals("") && !employee.getSalary().equals("")){
                return new ResponseEntity<Response>(new Response("Created Employee", "CREATED", 201, true, List.of(createEmployee)), HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<Response>(new Response("Bad Gateway", "BAD_GATEWAY", 502, true, List.of()), HttpStatus.BAD_GATEWAY);
            }

        } catch (Exception exception) {
            return new ResponseEntity<Response>(new Response(exception.getMessage(),"INTERNAL_SERVER_ERROR",501,false,new ArrayList<>()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee) {
        try {
            if (employee == null || employee.getName().equals("") || employee.getCity().equals("") || employee.getSalary().equals("")) {
                return new ResponseEntity<Response>(new Response("All Parameters are required !!! ", "BAD_REQUEST", 401, false, new ArrayList<>()), HttpStatus.BAD_REQUEST);
            }
            Employee updateEmployee = employeeService.updateEmployee(id, employee);

            if(updateEmployee!=null && !employee.getName().equals("") && !employee.getCity().equals("") && !employee.getSalary().equals("")){
                return new ResponseEntity<Response>(new Response("Update Employee", "UPDATED", 201, true, List.of(updateEmployee)), HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<Response>(new Response("Bad Gateway", "BAD_GATEWAY", 502, false, List.of()), HttpStatus.BAD_GATEWAY);
            }

        } catch (Exception exception) {
            return new ResponseEntity<Response>(new Response(exception.getMessage(),"INTERNAL_SERVER_ERROR",501,false,new ArrayList<>()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteEmployee(@PathVariable("id") Long id) {
        try {

            Boolean isDeleted = employeeService.deleteEmployee(id);

            if(isDeleted){
                return new ResponseEntity<Response>(new Response("Employee Deleted", "SUCCESS", 200, true, List.of()), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<Response>(new Response("Bad Gateway", "BAD_GATEWAY", 502, false, List.of()), HttpStatus.BAD_GATEWAY);
            }

        } catch (Exception exception) {
            return new ResponseEntity<Response>(new Response(exception.getMessage(),"INTERNAL_SERVER_ERROR",501,false,new ArrayList<>()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
