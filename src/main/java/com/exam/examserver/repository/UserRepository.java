package com.exam.examserver.repository;

import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
   //finding user by username
   public User findByUsername(String username);
}
