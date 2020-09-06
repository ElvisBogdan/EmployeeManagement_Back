package com.example.demo.Controller;

import com.example.demo.Model.DAO.JobCategory;
import com.example.demo.Service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employee")
public class JobCategoryController {

    @Autowired
    private JobCategoryService jobCategoryService;

    @PostMapping("/saveJobCategory")
    public JobCategory saveJobCategory(@RequestBody JobCategory jobCategory) {

        JobCategory JobCategoryAdded = this.jobCategoryService.saveJobCategory(jobCategory);
        return JobCategoryAdded;
    }

    @GetMapping("/getJobCategoryById/{id}")
    public ResponseEntity<JobCategory> findJobCategoryById(@PathVariable int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "getDepartmentById");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(jobCategoryService.findJobCategoryById(id));
    }


    @PutMapping("/updateJobCategory/{id}")
    public JobCategory updateJobCategory(@RequestBody JobCategory jobCategory, @PathVariable int id) {
        System.out.println("JobCategory was updated");
//        return this.jobCategoryService.updateJobCategory(jobCategory,id);
        JobCategory updateJobCategory = null;
        try {
            updateJobCategory = this.jobCategoryService.updateJobCategory(jobCategory, id);
        } catch (RuntimeException e) {


            System.out.println(e.getMessage());
        }
        return this.jobCategoryService.updateJobCategory(jobCategory, id);
    }


    @DeleteMapping("/deleteJobCategory/{id}")
    public boolean deleteJobCategory(@PathVariable int id) {
//        System.out.println("JobCategory was deleted");
        return this.jobCategoryService.deleteJobCategory(id);

    }


    //    public ResponseEntity<List<JobCategory>> getAllJobCategory(){
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Response","findAllDepartments");
//
//        List<JobCategory> jobCategoryList;
//
//        jobCategoryList = jobCategoryService.findAllJobCategory();
//        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(jobCategoryList);
//    }
    @GetMapping("/getAllJobCategory")
    public ResponseEntity<List<JobCategory>> getAllJobCategory() {


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Response", "findAllJobCategory");

        List<JobCategory> jobCategoryList = jobCategoryService.findAllJobCategory();
        if (jobCategoryList == null)
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(jobCategoryList);

        jobCategoryList = jobCategoryService.findAllJobCategory();
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(jobCategoryList);
    }
}
