package com.ausnepit.departmentservice.controller;

import com.ausnepit.departmentservice.entity.Department;
import com.ausnepit.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author slap4msth
 * created-date: 2021-03-15
 * package-name: com.ausnepit.departmentservice.controller
 * project-name: department-service
 */
@RestController
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside save department of Department Controller::{}",department);
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/get-by-id/{id}")
    public Department getDepartmentByID(@PathVariable("id")Long id){
        log.info("Inside get department by id of Department controllelr");
        return  departmentService.findDepartmentById(id);
    }
}
