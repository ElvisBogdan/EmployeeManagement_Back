package com.example.demo.Service;

import com.example.demo.Model.DAO.Department;
import com.example.demo.Model.DAO.Employee;
import com.example.demo.Model.DAO.JobCategory;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    public Department saveDepartment(Department department) {

        return this.departmentRepository.save(department);

    }

    public Department findDepartmentById(int id) {
        return this.departmentRepository.findById(id);
    }

    public Department updateDepartment(Department department, int id) {
        Department updatedDepartment = findDepartmentById(id);
        updatedDepartment.setName(department.getName());
        departmentRepository.save(updatedDepartment);
        return updatedDepartment;
    }

    public boolean deleteDepartment(int id) {
        Department department = null;
        try {
            department = departmentRepository.findById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("No department present for this id ");
        }
        departmentRepository.delete(department);
        return true;
    }

    public List<Department> findAllDepartments()
    {
        return this.departmentRepository.findAll();
    }
}
