package com.example.CrudExample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CrudExample.model.Employee;
import com.example.CrudExample.repository.EmployeeRepository;
@Service
public class EmployeeserviceImpl implements Employeeservice{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException("not found:::::"+id);
		}
		return employee;
	}
	@Override
	public void deleteEmpById(long id) {
		this.employeeRepository.deleteById(id);
	}

}
