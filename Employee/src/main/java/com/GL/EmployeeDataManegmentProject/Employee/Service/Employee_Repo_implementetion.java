package com.GL.EmployeeDataManegmentProject.Employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GL.EmployeeDataManegmentProject.Employee.Entity.Employee;
import com.GL.EmployeeDataManegmentProject.Employee.Repository.Employee_Repo;

@Service
public class Employee_Repo_implementetion {

	@Autowired
	Employee_Repo employee_Repo;
	
	public  List<Employee> FeatchAllData() {
		
		return this.employee_Repo.findAll();
	}
	
	public Optional<Employee> FindById(int id) {
		
		return this.employee_Repo.findById(id);
	}
	
	public Employee SaveEmployee(Employee employee) {
		
		return this.employee_Repo.saveAndFlush(employee);
	}
	
	public  void DeleteEmplyee(Employee employee) {
		this.employee_Repo.delete(employee);
	}
}
