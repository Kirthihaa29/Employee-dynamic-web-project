package com.company.ems.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.ems.model.Employee;
import com.company.ems.service.EmployeeService;
import com.company.ems.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService employeeService=new EmployeeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action=request.getParameter("action");
		
		HttpSession httpSession=request.getSession();
		
		if(null!=action && action.equalsIgnoreCase("delete")) {
			int id=Integer.parseInt(request.getParameter("id"));
			employeeService.delete(id);
			
			response.sendRedirect("EmployeeServlet?action=list");
		}
		else if(null!=action && action.equalsIgnoreCase("edit")) {
			int id=Integer.parseInt(request.getParameter("id"));
			Employee employee=employeeService.findById(id);
			httpSession.setAttribute("employee", employee);
			response.sendRedirect("employee.jsp?action="+action);
		}
		else if(null!=action && action.equalsIgnoreCase("view"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			Employee employee=employeeService.findById(id);
			httpSession.setAttribute("employee", employee);
			response.sendRedirect("employee.jsp?action="+action);
			
		}
		else if(null!=action && action.equalsIgnoreCase("update")) {
			int id=Integer.parseInt(request.getParameter("id"));
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String dob=request.getParameter("dob");
			float sal=Float.parseFloat(request.getParameter("sal"));
			String dept=request.getParameter("dept");
			Employee employee=new Employee(id, firstName, lastName, dob, sal, dept);
			employeeService.update(employee, id);			
			httpSession.setAttribute("employee", employee);
			response.sendRedirect("employee.jsp?action="+action);
		}
		else {
			List<Employee> employeeList=employeeService.getAllEmployees();
			httpSession.setAttribute("employeeList", employeeList);
			response.sendRedirect("EmployeeList.jsp");
		}
	}

}
