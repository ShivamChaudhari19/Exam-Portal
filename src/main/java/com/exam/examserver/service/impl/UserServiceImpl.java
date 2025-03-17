package com.exam.examserver.service.impl;

import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;
import com.exam.examserver.repository.RoleRepository;
import com.exam.examserver.repository.UserRepository;
import com.exam.examserver.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;




    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRole) throws Exception {
        User local=this.userRepository.findByUsername(user.getUsername());

        //check if the user is already present
        if(local!=null){
            System.out.println("username already exist!!!");
            throw new Exception("User already present!!!!");
        }else {
            //rest code
            for(UserRole ur:userRole){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRole);
            local=this.userRepository.save(user);
        }
        return  local;
    }

    //get user by username from userRepository
    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

}
