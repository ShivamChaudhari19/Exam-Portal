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
public class ExamserverApplication implements CommandLineRunner {


	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user=new User();
		user.setUsername("skwewsdsdljs");
		user.setPassword("728sdfsdssf9");
		user.setFirstName("Ssdfsdasdstyam");
		user.setLastName("Chadsfsudhari");
		user.setPhone("845956sdfsf9016");
		user.setAbout("work at nrb sinsdfsdfsfsce 2020");


		Role role =new Role();

		role.setRoleName("usyer");

		Set<UserRole> userRoleSet=new HashSet<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoleSet.add(userRole);
		User user1=this.userService.createUser(user,userRoleSet);

}
}
