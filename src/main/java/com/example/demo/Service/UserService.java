package com.example.demo.Service;

import com.example.demo.Model.DAO.Role;
import com.example.demo.Model.DAO.User;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Role saveRole(Role role) {
        return this.roleRepository.save(role);
    }

    public User saveUser(User user) {

        return this.userRepository.save(user);
    }

    public User saveUser2(User user,int idRole)
    {

        Role role = this.roleRepository.findById(idRole).get();

       List<Role> roleList = new ArrayList<>();
       roleList.add(role);



        if(role!=null) {

            user.setRoleList(roleList);
            return this.userRepository.save(user);
        }
        else
        {
            throw new RuntimeException("Role not found");
        }
    }


    public User saveUser3(User user,List<Role> roleList)
    {
        user.setRoleList(roleList);
        return this.userRepository.save(user);


    }
    public Role findRoleById(int id)
    {
        return this.roleRepository.findById(id).get();
    }



    public List<Role> findAllRoles()
    {
        return this.roleRepository.findAll();
    }


    public List<User> findAllUsers()
    {
        return this.userRepository.findAll();
    }



    public void deleteUser(int id){
         this.userRepository.deleteById(id);
    }

    public User findUserById(int id)
    {
        return this.userRepository.findById(id);
    }

//
//    public void updateUser(int id)
//   {
//       this.userRepository.setId(id);
//
//   }


}
