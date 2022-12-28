package com.springboot.project.Controller;

import com.springboot.project.Entity.Department;
import com.springboot.project.Error.DepartmentNotFoundException;
import com.springboot.project.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

   @Autowired
   private DepartmentService departmentService;

   @GetMapping("/home")
   public String home(){
       return "Welcome to Spring Rest-API";
   }

   //Add department
    @PostMapping("/add")
    public Department createDepartment(@RequestBody Department department){
        return departmentService.save(
                department);
      }
    //Get Department
    @GetMapping("/get")
    public List<Department> getAllDepartment( )
    {
        return  departmentService.findAll();
    }

    //Get Id
    @GetMapping("/{id}")
    public Department getAllDepartmentId(@PathVariable ("id")Long departmentId) throws DepartmentNotFoundException {
        return departmentService.findById(departmentId);

    }

    @GetMapping("/departmentName")
    public ResponseEntity<List<Department>> getDepartmentByName(@RequestParam String departmentName)

    {
        return new ResponseEntity<>(departmentService.findByDepartmentName(departmentName),HttpStatus.OK);
    }

    @GetMapping("/departmentAddress")
    public ResponseEntity<List<Department>> getDepartmentByAddress(@RequestParam String departmentAddress)
    {
        return new ResponseEntity<>(departmentService.findByDepartmentAddress(departmentAddress),HttpStatus.OK);
    }
    @GetMapping("/departmentCode")
    public ResponseEntity<List<Department>> getDepartmentByCode(@RequestParam String departmentCode){
       return new ResponseEntity<>(departmentService.findByDepartmentCode(departmentCode),HttpStatus.OK);
    }
/*
    @GetMapping("/v1/departmentCode")
    public ResponseEntity<List<Department>> getAllDepartment(@RequestParam String departmentCode){

       return new ResponseEntity<>(departmentService.findByDepartmentCodeAsc(departmentCode),HttpStatus.OK);
    }*/

    @GetMapping("/nameAndAddress")
    public ResponseEntity<List<Department>> getDepartmentByNameAndAddress(@RequestParam String departmentName ,@RequestParam String departmentAddress){

       return new ResponseEntity<>(departmentService.findByDepartmentNameAndDepartmentAddress(departmentName,departmentAddress),HttpStatus.OK);
    }

    @GetMapping("/nameOrAddress")
    public ResponseEntity<List<Department>> getDepartmentByNameOrAddress(@RequestParam String departmentName,@RequestParam String departmentAddress){
        return new ResponseEntity<>(departmentService.findByDepartmentNameOrDepartmentAddress(departmentName,departmentAddress),HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteDepartmentByID(@PathVariable("id") Long departmentId)
    {
        departmentService.deleteDepartmentByID(departmentId);
        return "Department Delete Successfully !!!";
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/nameLike")
   public List<Department> findByDepartmentNameLike(@RequestParam String departmentName){
       return departmentService.findByDepartmentNameLike("%"+departmentName+"%");
   }

   @GetMapping("/addressLike")
    public List<Department>findByDepartmentAddressLike(@RequestParam String departmentAddress){
        return departmentService.findByDepartmentAddressLike("%"+departmentAddress+"%");
   }

   @GetMapping("/codeLike")
    public ResponseEntity<List<Department>> findByDepartmentCodeLike(@RequestParam String departmentCode)  {
        return new ResponseEntity<>(departmentService.findByDepartmentCodeLike("%"+departmentCode+"%"),HttpStatus.OK);
    }

    @GetMapping("/idLike")
    public ResponseEntity<List<Department>> findByDepartmentIdLike(@RequestParam Long departmentId)
    {
        return new ResponseEntity<>(departmentService.findByDepartmentIdLike(departmentId),HttpStatus.OK);
    }

    @GetMapping("/codeBetween")
    public ResponseEntity<List<Department>> findByDepartmentCodeBetween(@RequestParam String start, @RequestParam String end){
        return new ResponseEntity<List<Department>>(departmentService.findByDepartmentCodeBetween(start,end),HttpStatus.OK);
    }

    @GetMapping("/numberBetween")
    public ResponseEntity<List<Department>> findByDepartmentNumberBetween(@RequestParam String start, @RequestParam String end ){

        return new ResponseEntity<>(departmentService.findByDepartmentNumberBetween(start,end),HttpStatus.OK);
    }
    //Pending
   @GetMapping("/nameStart")
    public List<Department>  findByDepartmentNameStartingWith (@RequestParam String departmentName){
        return  departmentService.findByDepartmentNameStartingWith("%"+departmentName);

   }

   


}
