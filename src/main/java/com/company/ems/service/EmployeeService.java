package com.company.ems.service;

import java.util.List;

import com.company.ems.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	Employee findById(int id);
	Employee save(Employee employee);
	Employee update(Employee employee,int id);
	boolean delete(int id);
}
