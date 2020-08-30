package com.example.demo.Repository;

import com.example.demo.Model.DAO.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
@Override
    List<Role> findAll();

@Override
Optional<Role> findById(Integer integer);





}
