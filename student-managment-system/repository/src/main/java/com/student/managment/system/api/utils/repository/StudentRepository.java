package com.student.managment.system.api.utils.repository;

import com.student.managment.system.api.utils.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>,CustomStudentRepository {
}
