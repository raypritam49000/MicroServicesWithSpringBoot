package com.student.managment.system.api.utils.repository;

import com.student.managment.system.api.utils.entity.Student;

public interface CustomStudentRepository {
    public boolean saveOrUpdate(Student student);
}
