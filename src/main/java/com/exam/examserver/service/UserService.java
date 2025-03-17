package com.exam.examserver.service;

import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;

import java.util.Set;

public interface UserService {

 //creating new user
 public User createUser(User user, Set<UserRole> userRole) throws Exception;

 //get user by username
 public User findByUsername(String username);
}
