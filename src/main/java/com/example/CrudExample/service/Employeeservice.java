package com.example.CrudExample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CrudExample.model.Employee;

public interface Employeeservice {
	List<Employee> getAllEmployees();

	void saveEmployee(Employee employee);

	Employee getEmployeeById(long id);

	void deleteEmpById(long id);
}
