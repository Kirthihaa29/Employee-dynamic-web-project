package com.company.ems.service;

import java.util.List;

import com.company.ems.model.Employee;
import com.company.ems.dao.EmployeeDAO;
import com.company.ems.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDAO employeeDAO=new EmployeeDAOImpl();
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployees();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(id);
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.save(employee);
	}

	@Override
	public Employee update(Employee employee, int id) {
		// TODO Auto-generated method stub
		return employeeDAO.update(employee, id);
	}

	@Override
	public boolean delete(int id) {
		return employeeDAO.delete(id);
	}

}
