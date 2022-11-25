package com.GL.EmployeeDataManegmentProject.Employee.Util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.GL.EmployeeDataManegmentProject.Employee.Entity.Role;
import com.GL.EmployeeDataManegmentProject.Employee.Entity.User;
import com.GL.EmployeeDataManegmentProject.Employee.Repository.Employee_Repo;
import com.GL.EmployeeDataManegmentProject.Employee.Repository.User_repo;

@Configuration
public class BootStapAppDataFiles {

	// Creting The objects of Employee repo and user_repo for saving Both the files
	// :-

	@Autowired
	private User_repo user_repo;

	@EventListener(ApplicationReadyEvent.class)
	public void insertingUser(ApplicationReadyEvent applicationReadyEvent) {

		User Employee = new User();

		// Inciallizing the userName and password hear :-

		Employee.setUserName("Employee");
		Employee.setPassword("Emp123");

		// set the Role for the Employee :-

		Role EmpRole = new Role();

		EmpRole.setRole_Name("Employee");

		// Add this Role to the Arrey list of the Role :-

		List<Role> EmpList = new ArrayList<>();

		EmpList.add(EmpRole);

		// Now set the role To The Employee:-
		Employee.setListRole(EmpList);

		// Now Similerly set the The Username password and The role for the Admin also
		// :-

		User AdminUser = new User();
		AdminUser.setUserName("Admin");
		AdminUser.setPassword("Admin123");

		Role AdminRole = new Role();

		AdminRole.setRole_Name("Admin");

		List<Role> adminRole = new ArrayList<>();

		adminRole.add(AdminRole);

		AdminUser.setListRole(adminRole);

		// now set Both the user hear :-

		this.user_repo.saveAndFlush(Employee);
		this.user_repo.saveAndFlush(AdminUser);

	}

}
