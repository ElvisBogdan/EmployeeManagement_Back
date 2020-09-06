package com.example.demo.Repository;

import com.example.demo.Model.DAO.Employee;
import com.example.demo.Model.DAO.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobCategoryRepository extends JpaRepository<JobCategory,Integer> {
    JobCategory findById(int id);
}
