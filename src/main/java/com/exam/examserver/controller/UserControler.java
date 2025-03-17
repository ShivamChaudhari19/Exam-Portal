package com.exam.examserver.controller;

import com.exam.examserver.model.Role;
import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;
import com.exam.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserControler {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {


        Role role=new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL USER");
        Set<UserRole> userRoleSet=new HashSet<>();

        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoleSet.add(userRole);

        return this.userService.createUser(user,userRoleSet );
    }


    //fetch user data at the endpoint using username
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username")String username){
        return this.userService.findByUsername(username);
    }

    //delete user by id
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        this.userService.deleteUser(id);
    }



}
