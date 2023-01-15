package com.student.managment.system.api.utils.controller;

import com.student.managment.system.api.utils.Response;
import com.student.managment.system.api.utils.entity.Student;
import com.student.managment.system.api.utils.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Response> getAllStudents() {
        try {
            List<Student> students = studentService.getAllStudent();

            if (students.isEmpty() || students == null || students.size() <= 0) {
                return new ResponseEntity<Response>(new Response("Student Not Found", "NOT_FOUND", 404, false, new ArrayList<>()), HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Response>(new Response("Employee List", "SUCCESS", 200, true, students), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<Response>(new Response(exception.getMessage(),"INTERNAL_SERVER_ERROR",501,false,new ArrayList<>()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getStudent(@PathVariable("id") Long id) {
        try {
            Student student = studentService.getStudent(id);

            if (student == null || student.getName().equals("") || student.getCity().equals("") || student.getSalary().equals("")) {
                return new ResponseEntity<Response>(new Response("Student Not Found", "NOT_FOUND", 404, false, new ArrayList<>()), HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Response>(new Response("Student List", "SUCCESS", 200, true, List.of(student)), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<Response>(new Response(exception.getMessage(),"INTERNAL_SERVER_ERROR",501,false,new ArrayList<>()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Response> createStudent(@RequestBody Student student) {
        try {
            if (student == null || student.getName().equals("") || student.getCity().equals("") || student.getSalary().equals("")) {
                return new ResponseEntity<Response>(new Response("All Parameters are required !!! ", "BAD_REQUEST", 401, false, new ArrayList<>()), HttpStatus.BAD_REQUEST);
            }
            Student createStudent = studentService.createStudent(student);

            if(createStudent!=null && !createStudent.getName().equals("") && !createStudent.getCity().equals("") && !createStudent.getSalary().equals("")){
                return new ResponseEntity<Response>(new Response("Created Student", "CREATED", 201, true, List.of(createStudent)), HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<Response>(new Response("Bad Gateway", "BAD_GATEWAY", 502, true, List.of()), HttpStatus.BAD_GATEWAY);
            }

        } catch (Exception exception) {
            return new ResponseEntity<Response>(new Response(exception.getMessage(),"INTERNAL_SERVER_ERROR",501,false,new ArrayList<>()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Response> updateStudent(@RequestBody Student student) {
        try {
            if (student == null || student.getName().equals("") || student.getCity().equals("") || student.getSalary().equals("")) {
                return new ResponseEntity<Response>(new Response("All Parameters are required !!! ", "BAD_REQUEST", 401, false, new ArrayList<>()), HttpStatus.BAD_REQUEST);
            }
            Boolean isUpdated = studentService.updateStudent(student);

            if(isUpdated){
                return new ResponseEntity<Response>(new Response("Update Student", "UPDATED", 201, true, List.of()), HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<Response>(new Response("Bad Gateway", "BAD_GATEWAY", 502, false, List.of()), HttpStatus.BAD_GATEWAY);
            }

        } catch (Exception exception) {
            return new ResponseEntity<Response>(new Response(exception.getMessage(),"INTERNAL_SERVER_ERROR",501,false,new ArrayList<>()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteStudent(@PathVariable("id") Long id) {
        try {

            Boolean isDeleted = studentService.deleteStudent(id);

            if(isDeleted){
                return new ResponseEntity<Response>(new Response("Student Deleted", "SUCCESS", 200, true, List.of()), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<Response>(new Response("Bad Gateway", "BAD_GATEWAY", 502, false, List.of()), HttpStatus.BAD_GATEWAY);
            }

        } catch (Exception exception) {
            return new ResponseEntity<Response>(new Response(exception.getMessage(),"INTERNAL_SERVER_ERROR",501,false,new ArrayList<>()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
