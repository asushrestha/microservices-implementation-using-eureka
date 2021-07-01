package com.ausnepit.departmentservice.service;

import com.ausnepit.departmentservice.entity.Department;

/**
 * @author slap4msth
 * created-date: 2021-03-15
 * package-name: com.ausnepit.departmentservice.service
 * project-name: department-service
 */
public interface DepartmentService {
    Department saveDepartment(Department department);

    Department findDepartmentById(Long id);
}
