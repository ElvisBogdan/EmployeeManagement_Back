package com.example.demo.Mapper;

import com.example.demo.Model.DAO.Department;
import com.example.demo.Model.DAO.Employee;
import com.example.demo.Model.DTO.EmployeeDTO;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {



        @Autowired
        private EmployeeRepository employeeRepository;
        @Autowired
        private DepartmentRepository departmentRepository;


        public EmployeeDTO convertToEmployeeDTO(Employee employee)
        {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            String department = employee.getDepartment().getName();
            employeeDTO.setId(employee.getId());
            employeeDTO.setEmail(employee.getEmail());
            employeeDTO.setFirstName((employee.getFirstName()));
            employeeDTO.setLastName(employee.getLastName());
            employeeDTO.setDepartment(department);
            return employeeDTO;
        }





}


