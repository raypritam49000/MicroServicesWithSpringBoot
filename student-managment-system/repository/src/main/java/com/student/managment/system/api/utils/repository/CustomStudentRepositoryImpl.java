package com.student.managment.system.api.utils.repository;

import com.student.managment.system.api.utils.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CustomStudentRepositoryImpl implements CustomStudentRepository{

    private final SessionFactory sessionFactory;

    public CustomStudentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean saveOrUpdate(Student student) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(student);
        return true;
    }
}
