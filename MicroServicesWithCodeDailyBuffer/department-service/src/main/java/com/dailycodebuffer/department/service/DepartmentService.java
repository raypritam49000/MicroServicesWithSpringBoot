package com.dailycodebuffer.department.service;

import com.dailycodebuffer.department.entity.Department;

public interface DepartmentService {
    public abstract Department saveDepartment(Department department);
    public abstract Department findDepartmentById(Long departmentId);
}
