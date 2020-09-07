package com.example.demo.Service;

import com.example.demo.Model.DAO.Department;
import com.example.demo.Model.DAO.Employee;
import com.example.demo.Model.DAO.JobCategory;
import com.example.demo.Model.DTO.EmployeeDTO;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    public Employee saveEmployee(Employee employee) {
        if (departmentRepository.findById(employee.getDepartment().getId()) != null && jobCategoryRepository.findById(employee.getJobCategory().getId()) != null) {
            return this.employeeRepository.save(employee);

        }else
            throw new RuntimeException("Gata");
    }

    public Employee getEmployeeById(int id) {
        return this.employeeRepository.findById(id);
    }

    public Employee updateEmployee(Employee employee, int id) {

        Employee updatedEmployee = getEmployeeById(id);
        updatedEmployee.setFirstName(employee.getFirstName());
        updatedEmployee.setLastName(employee.getLastName());
        Department department = departmentRepository.findById(employee.getDepartment().getId());
        JobCategory jobCategory = jobCategoryRepository.findById(employee.getJobCategory().getId());
        if (department == null || jobCategory == null) {
            throw new RuntimeException("Department or Jobcategory is null");
        }
        updatedEmployee.setDepartment(employee.getDepartment());
        updatedEmployee.setJobCategory(employee.getJobCategory());
        updatedEmployee.setActive(employee.isActive());
        updatedEmployee.setAddress(employee.getAddress());
        updatedEmployee.setBirthday(employee.getBirthday());
        updatedEmployee.setCP(employee.getCP());
        updatedEmployee.setEmail(employee.getEmail());
        updatedEmployee.setStartDate(employee.getStartDate());
        updatedEmployee.setEndDate(employee.getEndDate());
        updatedEmployee.setHasDrivingLicense(employee.isHasDrivingLicense());
        updatedEmployee.setManager(employee.isManager());
        updatedEmployee.setNoChildren(employee.getNoChildren());
        updatedEmployee.setSalary(employee.getSalary());
        updatedEmployee.setSocialSecurityNumber(employee.getSocialSecurityNumber());
        updatedEmployee.setStudies(employee.getStudies());
        updatedEmployee.setTelephone(employee.getTelephone());

        employeeRepository.save(updatedEmployee);
        return updatedEmployee;

    }

    public Employee deleteEmployee(int id) {
        Employee employee = null;
            employee = employeeRepository.findById(id);
       if(employee == null){
           throw new RuntimeException("mesaj");
       }

        employeeRepository.delete(employee);
       return employee;
    }

    public List<Employee> findAllEmployee() {
        return this.employeeRepository.findAll();
    }

    public List<Employee> getEmployeeByDepartmentId(int departmentId) {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().filter(e -> e.getDepartment() != null).filter(e -> e.getDepartment().getId() == departmentId).collect(Collectors.toList());
    }

    public List<Employee> getEmployeeByJobCategoryId(int jobCategoryId) {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().filter(e -> e.getJobCategory() != null).filter(e -> e.getJobCategory().getId() == jobCategoryId).collect(Collectors.toList());
    }

    public List<Employee> getEmployeeByDepAndJob(int departmentId, int jobCategoryId) {
        List<Employee> employeeList = findAllEmployee();
        return employeeList.stream().filter(e -> e.getDepartment() != null).filter(e -> e.getDepartment().getId()
                == departmentId).filter(e -> e.getJobCategory() != null).filter(e -> e.getJobCategory().getId() == jobCategoryId).collect(Collectors.toList());

    }
}

