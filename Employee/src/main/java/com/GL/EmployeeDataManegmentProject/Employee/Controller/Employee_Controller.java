package com.GL.EmployeeDataManegmentProject.Employee.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.GL.EmployeeDataManegmentProject.Employee.Entity.Employee;
import com.GL.EmployeeDataManegmentProject.Employee.Service.Employee_Repo_implementetion;

@Controller
@RequestMapping("/Employee")
public class Employee_Controller {

	@Autowired
	private Employee_Repo_implementetion employee_Repo_implementetion;

	@GetMapping("/List")
	public String FindallEmployeee(Model model) {

		List<Employee> employees = employee_Repo_implementetion.FeatchAllData();
		model.addAttribute("Employees", employees);
		return "Employee_List";
	}

	@GetMapping("/Form_Emp")
	public String AddEmployee(Model model) {

		Employee employee = new Employee();
		model.addAttribute("Employee", employee);
		return "Employee-form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("Employee") Employee employee) {

		this.save(employee);
		return "redirected:/Employee/List/";

	}

	@PutMapping("/Update")
	public String UpdateEmployee(@RequestParam("id") int id) {

		Optional<Employee> employee = this.employee_Repo_implementetion.FindById(id);

		Employee employee2 = employee.get();
		employee2.setName(employee2.getName());
		employee2.setDeaprtment(employee2.getDeaprtment());
		employee2.setCountry(employee2.getCountry());

		this.employee_Repo_implementetion.SaveEmployee(employee2);
		return "redirected:/Employee/List/";

	}

	@DeleteMapping("/Delete")
	public void DeleteEmployee(@RequestParam("id") int id) {

		Optional<Employee> employee = employee_Repo_implementetion.FindById(id);
		this.employee_Repo_implementetion.DeleteEmplyee(employee.get());
	}

	@GetMapping("/acsess-dined")
	public String DinaiedAcsees() {

		return "Acsees-Dinaied";
	}
}
