package com.GL.EmployeeDataManegmentProject.Employee.Entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "Deaprtment")
	private String Deaprtment;
	@Column(name = "Country")
	private String Country;

}
