package com.GL.EmployeeDataManegmentProject.Employee.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import com.GL.EmployeeDataManegmentProject.Employee.Entity.User;

@Repository
@EnableJpaRepositories
public interface User_repo extends JpaRepository<User,Integer>  {


	public User FindByUserName(String userName);

}
