package com.ausnepit.departmentservice.repository;

import com.ausnepit.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author slap4msth
 * created-date: 2021-03-15
 * package-name: com.ausnepit.departmentservice.repository
 * project-name: department-service
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query(value = "select d from Department  d where d.departmentId=:id")
    Department findDepartmentId(Long id);
}
