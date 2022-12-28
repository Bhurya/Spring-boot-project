package com.springboot.project.Service;

import com.springboot.project.Entity.Department;
import com.springboot.project.Error.DepartmentNotFoundException;

import java.math.BigDecimal;
import java.util.List;


public interface DepartmentService {

 Department createDepartment(Department department);

  Department save(Department department);


 List<Department> findAll();

 Department findById(Long departmentId) throws DepartmentNotFoundException;

 List<Department> findByDepartmentName(String departmentName);

 List<Department> findByDepartmentAddress(String departmentAddress);

 List<Department> findByDepartmentCode(String departmentCode);

 //List<Department> findByDepartmentCodeAsc(String departmentCode);

 List<Department> findByDepartmentNameAndDepartmentAddress(String departmentName, String departmentAddress);

 List<Department> findByDepartmentNameOrDepartmentAddress(String departmentName, String departmentAddress);

 public void deleteDepartmentByID(Long departmentId);


public Department updateDepartment(Long departmentId, Department department);


 List<Department> findByDepartmentNameLike(String departmentName);

 List<Department> findByDepartmentAddressLike(String departmentAddress);

 List<Department> findByDepartmentNameStartingWith(String departmentName);

 List<Department> findByDepartmentCodeLike(String departmentCode);

 List<Department> findByDepartmentIdLike(Long departmentId);


 List<Department> findByDepartmentCodeBetween(String start, String end);

 List<Department> findByDepartmentNumberBetween(String start, String end);

}
