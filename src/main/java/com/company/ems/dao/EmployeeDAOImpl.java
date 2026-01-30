package com.company.ems.dao;

import java.util.ArrayList;
import java.util.List;

import com.company.ems.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	List<Employee> employeeList=new ArrayList<>();

	public EmployeeDAOImpl() {
		super();
		employeeList.add(new Employee(101,"Aaa","Bbb","27/09/2004",60000,"IT"));
		employeeList.add(new Employee(102,"Ccc","Ddd","29/08/2005",70000,"IT"));
		employeeList.add(new Employee(103,"Eee","Fff","30/07/1995",90000,"HR"));
		employeeList.add(new Employee(104,"Ggg","Hhh","30/10/2004",50000,"SALES"));
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeList;
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		for(int i=0;i<employeeList.size();i++) {
			if(employeeList.get(i).getId()==id) {
				return employeeList.get(i);
			}
		}
		return null;
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		employeeList.add(employee);
		return employee;
	}

	@Override
	public Employee update(Employee employee, int id) {
		// TODO Auto-generated method stub
		for(int i=0;i<employeeList.size();i++) {
			if(employeeList.get(i).getId()==id) {
				employeeList.set(i, employee);
			}
		}
		return employee;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		for(int i=0;i<employeeList.size();i++) {
			if(employeeList.get(i).getId()==id) {
				employeeList.remove(i);
				flag=true;
			}
		}
		return flag;
	}

}
