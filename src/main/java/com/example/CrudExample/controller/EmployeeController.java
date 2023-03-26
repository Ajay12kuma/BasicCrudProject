package com.example.CrudExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CrudExample.model.Employee;
import com.example.CrudExample.service.Employeeservice;

@Controller
public class EmployeeController {
	@Autowired
	private Employeeservice employeeservice;
	@GetMapping("/")
	public String viewHomePage(Model model) {   //retriew the current list of employee
		model.addAttribute("listEmplyees", employeeservice.getAllEmployees());
		return "index";
	}
	@GetMapping("/showNewEmployeeForm")   //retriew form for adding employee
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_emp";
	}
	@PostMapping("/saveEmployee")   //for saving the employee details
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeservice.saveEmployee(employee);
		return "redirect:/";
	}
	@GetMapping("/showFormUpdate/{id}")  //for updating the existing employee records
	public String showFormFoUpdate(@PathVariable(value ="id") long id,Model model){
		Employee employee = employeeservice.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "update_employee";
	}
	@GetMapping("/deleteEmployee/{id}") //deleting the employee from list
	public String deleteEmployee(@PathVariable(value ="id") long id) {
		this.employeeservice.deleteEmpById(id);
		return "redirect:/";
	}

}
