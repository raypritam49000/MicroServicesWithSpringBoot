package com.student.managment.system.api.utils.service;

import com.student.managment.system.api.utils.entity.Student;
import com.student.managment.system.api.utils.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Boolean deleteStudent(Long id) {
        studentRepository.delete(studentRepository.findById(id).get());
        return true;
    }

    @Override
    public Boolean updateStudent(Student student) {
        return studentRepository.saveOrUpdate(student);
    }
}
