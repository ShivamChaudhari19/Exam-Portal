package com.exam.examserver.service.impl;

import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;
import com.exam.examserver.repository.RoleRepository;
import com.exam.examserver.repository.UserRepository;
import com.exam.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserServiceImpl implements UserService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;





    @Override
    public User createUser(User user, Set<UserRole> userRole) throws Exception {
        User local=this.userRepository.findByUsername(user.getUsername());
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
}
