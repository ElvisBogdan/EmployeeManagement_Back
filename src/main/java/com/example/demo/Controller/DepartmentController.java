package com.example.demo.Controller;

import com.example.demo.Model.DAO.Department;
import com.example.demo.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/saveDepartment")
    public Department saveDepartment(@RequestBody Department department) {
        Department departmentAdded = this.departmentService.saveDepartment(department);
        return departmentAdded;
    }

    @GetMapping("/getDepartmentById/{id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "getDepartmentById");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(departmentService.findDepartmentById(id));
    }

    @PutMapping("/updateDepartment/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable int id) {
        System.out.println("Department was updated");
        Department updateDepartment = null;
        try {
            updateDepartment = this.departmentService.updateDepartment(department, id);

        } catch (RuntimeException e) {


            System.out.println(e.getMessage());
        }
        return this.departmentService.updateDepartment(department, id);
    }


    @DeleteMapping("/deleteDepartment/{id}")
    public boolean deleteDepartment(@PathVariable int id) {
        System.out.println("Department was deleted");
        return this.departmentService.deleteDepartment(id);
    }

    //    @GetMapping("/findAllDepartments")
//    public ResponseEntity<List<Department>>getAllDepartments(){
//        List<Department> departmentList = null;
//        try {
//            departmentList = departmentService.findAllDepartments();
//        }catch (RuntimeException e) {
//            RuntimeException exception;
//        }
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Response","findAllDepartments");
//        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(departmentList);
//        }
//    }
    @GetMapping("/getAllDepartment")
    public ResponseEntity<List<Department>> getAllDepartment() {


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "findAllDepartments");

        List<Department> departmentList = departmentService.findAllDepartments();
        if (departmentList == null)
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(departmentList);

        departmentList = departmentService.findAllDepartments();
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(departmentList);
    }

}