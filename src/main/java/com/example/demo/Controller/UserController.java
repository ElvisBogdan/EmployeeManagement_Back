package com.example.demo.Controller;


import com.example.demo.Model.DAO.Role;
import com.example.demo.Model.DAO.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addRole")
    public Role saveRole(@RequestBody Role role) {
        Role roleAdded = this.userService.saveRole(role);
        return roleAdded;


    }

    @PostMapping("/addUser")
    public User saveUser(@RequestBody User user) {
        User userAdded = this.userService.saveUser(user);
        return userAdded;
    }

    @PostMapping("/addUser2/{idRole}")
    public User saveUser2(@RequestBody User user, @PathVariable int idRole) {
        return this.userService.saveUser2(user, idRole);

    }

    @PostMapping("/addUser3/{roleList}")
    public User saveUser3(@RequestBody User user, @PathVariable List<Role> roleList) {
       return  this.userService.saveUser3(user, roleList);


    }


    @GetMapping("/findRoleBy/{id}")
    public Role findRoleById(@PathVariable int id) {
        return this.userService.findRoleById(id);
    }
    @GetMapping("/findAllRoles")
    public List<Role> findAllRoles() {
        return this.userService.findAllRoles();
    }
    @GetMapping("/deleteUser10/{id}")
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUser(id);
    }
    //@GetMapping("/updateUser/{id}")
    //public void updateUser(@PathVariable int id){
      //   this.userService.updateUser(id);
    //}


    @PostMapping("/updateUser/{id}")
        public  ResponseEntity<User>userUpdate(@RequestBody User user, @PathVariable int id){
        User userToUpdate = userService.findUserById(id);

        userToUpdate.setId(user.getId());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded","Update successfully");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(userToUpdate);
    }



    //@PostMapping("/updateUser")
    //public ResponseEntity<User> updateUser(@RequestParam int id,@RequestParam User user)
      //  User updateUser = null;
    //HttpHeaders httpHeaders = new HttpHeaders();
    //httpHeaders.add(headerName:"Reponse",headerValue:"updateUser");
    //try

    //{
      //  updateUser = userService.updateUser(id, user);

    //}catch(ErrorReponse errorReponse){
       // errorReponse.printStrackTrace();
     //   return ReponseEntity.status(HttpStatus.NOT_FOUND).headers(httpHeaders).body(t:null);
   // }
}
