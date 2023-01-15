package com.student.managment.system.api.utils.service;

import com.student.managment.system.api.utils.entity.Student;

import java.util.List;

public interface StudentService {
    public Student createStudent(Student student);
    public List<Student> getAllStudent();
    public Student getStudent(Long id);
    public Boolean deleteStudent(Long id);
    public Boolean updateStudent(Student student);
}
