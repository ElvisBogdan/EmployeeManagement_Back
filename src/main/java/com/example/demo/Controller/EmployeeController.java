package com.example.demo.Controller;

import com.example.demo.Mapper.EmployeeMapper;
import com.example.demo.Model.DAO.Employee;
import com.example.demo.Model.DTO.EmployeeDTO;
import com.example.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;

    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        Employee employeeAdded = null;
        try {
            employeeAdded = this.employeeService.saveEmployee(employee);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return employeeAdded;
    }


    //    public  ResponseEntity<Employee>userUpdate(@RequestBody Employee employee, @PathVariable int id){
//        Employee employeeToUpdate = employeeService.findEmployeeById(id);
//
//        employeeToUpdate.setId(employee.getId());
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Responded","Update successfully");
//        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(employeeToUpdate);
//
//  }
    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
        System.out.println("Employee was updated");
        Employee updateEmployee = null;
        try {
            updateEmployee = this.employeeService.updateEmployee(employee, id);
        } catch (RuntimeException e) {


            System.out.println(e.getMessage());
        }
        return this.employeeService.updateEmployee(employee, id);
    }


    @DeleteMapping("/deleteEmployee/{id}")
    public Employee deleteEmployee(@PathVariable int id) {
        System.out.println("Employee was deleted");
        Employee deleteEmployee = null;
        try {
            deleteEmployee = this.employeeService.deleteEmployee(id);
        } catch (RuntimeException e) {


            System.out.println(e.getMessage());
        }
        return deleteEmployee;
    }


    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "Successfully");
        List<Employee> employeeList = employeeService.findAllEmployee();
        if (employeeList == null)
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(employeeList);
//        try {
//            employeeList = employeeService.findAllEmployee();
//        }catch (RuntimeException e) {
//            RuntimeException exception;
//        }


        employeeList = employeeService.findAllEmployee();
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(employeeList);


    }

    //    @GetMapping("/getByDepartment/{id}")
//    public List<Employee> getEmployeeByDepartmentId(int departmentId){
//        return this.employeeService.getEmployeeByDepartmentId(departmentId);
//  }
    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "Successfully");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(employeeService.getEmployeeById(id));
    }


    @GetMapping("/getEmployeeByDep/{departmentId}")
    public ResponseEntity<List<Employee>> getEmployeeByDepartmentId(@PathVariable int departmentId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "getEmployeeByDep");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(employeeService.getEmployeeByDepartmentId(departmentId));
    }

    @GetMapping("/getEmployeeByJob/{jobCategoryId}")
    public ResponseEntity<List<Employee>> getEmployeeByJobCategoryId(@PathVariable int jobCategoryId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "getEmployeeByJob");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(employeeService.getEmployeeByJobCategoryId(jobCategoryId));
    }

    @GetMapping("/getEmployeeByDepAndJob/{departmentId}/{jobCategoryId}")
    public ResponseEntity<List<Employee>> getEmployeeByDepAndJob(@PathVariable int departmentId, @PathVariable int jobCategoryId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "getEmployeeByDepAndJob");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(employeeService.getEmployeeByDepAndJob(departmentId, jobCategoryId));
    }

    @GetMapping("/getEmployeeDtoById/{id}")
    public EmployeeDTO getEmployeeDtoById(@PathVariable int id) {
        Employee employee = this.employeeService.getEmployeeById(id);

        EmployeeDTO getEmployeeDtoById = null;
        try {
            getEmployeeDtoById = this.employeeMapper.convertToEmployeeDTO(employee);
        } catch (RuntimeException e) {


            System.out.println(e.getMessage());
        }
        return getEmployeeDtoById;
    }


    @GetMapping("/getAllEmployeeDto")
    public List<EmployeeDTO> getAllEmployeeDto() {
        List<Employee> employees = this.employeeService.findAllEmployee();
        List<EmployeeDTO> employeeDTOS = employees.stream().map(e -> this.employeeMapper.convertToEmployeeDTO(e)).collect(Collectors.toList());
        return employeeDTOS;
    }

}