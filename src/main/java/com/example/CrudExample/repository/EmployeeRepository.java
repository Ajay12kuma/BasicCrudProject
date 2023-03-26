package com.example.CrudExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CrudExample.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
}
