package com.example.demo.Repository;

import com.example.demo.Model.DAO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(int id);
//    @Query("SELECT.....")
//    User setId(int id);

}