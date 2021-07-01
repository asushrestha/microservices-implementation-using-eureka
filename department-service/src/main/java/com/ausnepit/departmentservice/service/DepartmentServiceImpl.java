package com.ausnepit.departmentservice.service;

import com.ausnepit.departmentservice.entity.Department;
import com.ausnepit.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author slap4msth
 * created-date: 2021-03-15
 * package-name: com.ausnepit.departmentservice.service
 * project-name: department-service
 */
@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        log.info("inside save department of DepartmentServiceImpl::{}",department);
        return this.departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentById(Long id) {
        log.info("inside find department by id of DepartmentServiceImpl::{}",id);
        return this.departmentRepository.findDepartmentId(id);
    }
}
