package com.example.demo.Repository;

import com.example.demo.Model.DAO.Department;
import com.example.demo.Model.DAO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    Department findById(int id);
}
