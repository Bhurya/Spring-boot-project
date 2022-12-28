package com.springboot.project.Repository;

import com.springboot.project.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    List<Department> findByDepartmentName(String departmentName);

    List<Department> findByDepartmentAddress(String departmentAddress);

    List<Department> findByDepartmentCode(String departmentCode);

    //List<Department> findByDepartmentCodeAsc(String departmentCode);

    List<Department> findByDepartmentNameAndDepartmentAddress(String departmentName, String departmentAddress);


    List<Department> findByDepartmentNameOrDepartmentAddress(String departmentName, String departmentAddress);

    List<Department> findByDepartmentNameLike(String departmentName);

    List<Department> findByDepartmentAddressLike(String departmentAddress);

    List<Department> findByDepartmentNameStartingWith(String departmentName);

    List<Department> findByDepartmentCodeLike(String departmentCode);

    List<Department> findByDepartmentIdLike(Long departmentId);

    List<Department> findByDepartmentCodeBetween(String start, String end);

    List<Department> findByDepartmentNumberBetween(String start, String end);
}
