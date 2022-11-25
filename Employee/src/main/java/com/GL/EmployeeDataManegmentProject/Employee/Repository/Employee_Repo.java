package com.GL.EmployeeDataManegmentProject.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.GL.EmployeeDataManegmentProject.Employee.Entity.Employee;

@Repository
@EnableJpaRepositories
public interface Employee_Repo extends JpaRepository<Employee,Integer> {

	
}
