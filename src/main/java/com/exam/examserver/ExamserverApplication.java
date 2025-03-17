package com.exam.examserver;

import com.exam.examserver.model.Role;
import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;
import com.exam.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication /*implements CommandLineRunner*/ {


	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//	User user=new User();
//	user.setFirstName("shivam");
//	user.setLastName("chaudhari");
//	user.setUsername("shivam_chaudhari19");
//	user.setPassword("744826shivam");
//	user.setPhone("8459787658");
//	user.setAbout("First Admin/ developer");
//	user.setEnable(false);
//
//	Role role=new Role();
//	role.setRoleName("admin");
//	role.setRoleId(44L);
//
//	Set<UserRole> userRoleSet=new HashSet<>();
//
//	UserRole userRole=new UserRole();
//	userRole.setRole(role);
//	userRole.setUser(user);
//
//	userRoleSet.add(userRole);
//
//	this.userService.createUser(user,userRoleSet);
//}
}
