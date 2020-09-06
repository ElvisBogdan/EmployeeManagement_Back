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
import java.util.stream.Collectors;

@Service
public class JobCategoryService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    public JobCategory saveJobCategory(JobCategory jobCategory) {
        return this.jobCategoryRepository.save(jobCategory);
    }

    public JobCategory findJobCategoryById(int id) {

        return this.jobCategoryRepository.findById(id);
    }



    public JobCategory updateJobCategory(JobCategory jobCategory, int id) {
        JobCategory updatedJobCategory = findJobCategoryById(id);
        updatedJobCategory.setName(jobCategory.getName());
        jobCategoryRepository.save(updatedJobCategory);
        return updatedJobCategory;
    }

    public boolean deleteJobCategory(int id) {
        JobCategory jobCategory =null;
        System.out.println("INTRA");
        jobCategory = jobCategoryRepository.findById(id);
      if(jobCategory == null) {
      throw new RuntimeException("adwadawdw");
      }
          jobCategoryRepository.delete(jobCategory);
        return true;
    }




    public List<JobCategory> findAllJobCategory(){
        return this.jobCategoryRepository.findAll();
    }


}
