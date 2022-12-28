package com.springboot.project.Service;

import com.springboot.project.Entity.Department;
import com.springboot.project.Error.DepartmentNotFoundException;
import com.springboot.project.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class DepartmentServiceImpl implements DepartmentService{

@Autowired
private  DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Long departmentId) throws DepartmentNotFoundException {
      Optional<Department> department= departmentRepository.findById(departmentId);

      if (department.isPresent()){
          throw new DepartmentNotFoundException("Id Not Found");
      }
      return department.get();

    }

    @Override
    public List<Department> findByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Override
    public List<Department> findByDepartmentAddress(String departmentAddress) {
        return departmentRepository.findByDepartmentAddress(departmentAddress);
    }

    @Override
    public List<Department> findByDepartmentCode(String departmentCode) {
        return departmentRepository.findByDepartmentCode(departmentCode);
    }

   /* @Override
    public List<Department> findByDepartmentCodeAsc(String departmentCode) {
        return departmentRepository.findByDepartmentCodeAsc(departmentCode);
    }*/

    @Override
    public List<Department> findByDepartmentNameAndDepartmentAddress(String departmentName, String departmentAddress) {
        return departmentRepository.findByDepartmentNameAndDepartmentAddress(departmentName,departmentAddress);
    }

    @Override
    public List<Department> findByDepartmentNameOrDepartmentAddress(String departmentName, String departmentAddress) {
        return departmentRepository.findByDepartmentNameOrDepartmentAddress(departmentName,departmentAddress);
    }

    @Override
    public void deleteDepartmentByID(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB =departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (Objects.nonNull(department.getDepartmentNumber()) &&
                !"".equalsIgnoreCase(department.getDepartmentNumber())){
            depDB.setDepartmentNumber(department.getDepartmentNumber());
        }

        return departmentRepository.save(depDB);

    }

    @Override
    public List<Department> findByDepartmentNameLike(String departmentName) {
        return departmentRepository.findByDepartmentNameLike(departmentName);
    }

    @Override
    public List<Department> findByDepartmentAddressLike(String departmentAddress) {
        return departmentRepository.findByDepartmentAddressLike(departmentAddress);
    }

    @Override
    public List<Department> findByDepartmentNameStartingWith(String departmentName) {
        return departmentRepository.findByDepartmentNameStartingWith(departmentName);
    }

    @Override
    public List<Department> findByDepartmentCodeLike(String departmentCode) {
        return departmentRepository.findByDepartmentCodeLike(departmentCode);
    }

    @Override
    public List<Department> findByDepartmentIdLike(Long departmentId) {
        return departmentRepository.findByDepartmentIdLike(departmentId);
    }

    @Override
    public List<Department> findByDepartmentCodeBetween(String start, String end) {
        return departmentRepository.findByDepartmentCodeBetween(start,end);
    }

    @Override
    public List<Department> findByDepartmentNumberBetween(String start, String end) {
        return departmentRepository.findByDepartmentNumberBetween(start,end);
    }


}
