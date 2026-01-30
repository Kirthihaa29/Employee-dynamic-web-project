<%@page import="com.company.ems.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.company.ems.service.EmployeeServiceImpl"%>
<%@page import="com.company.ems.service.EmployeeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table,tr,th,td{
border:1px solid black; 
padding:20px;
}
</style>
</head>
<body>
<table style="border-collapse:collapse;">
<tr>
<th>Id</th>
<th>FirstName</th>
<th>LastName</th>
<th>Dob</th>
<th>Dept</th>
<th>Action</th>
<%!
public void display(){
	
}
%>
<%
//EmployeeService employeeService=new EmployeeServiceImpl();
//List<Employee> employeeList=employeeService.getAllEmployees();
List<Employee> employeeList=(List<Employee>)session.getAttribute("employeeList");
for(Employee employee:employeeList)
{
	%>
	<tr style="border:1px solid black;">
	<td><%=employee.getId() %></td>
	<td><%=employee.getFirstName() %></td>
	<td><%=employee.getLastName() %></td>
	<td><%=employee.getDob() %></td>
	<td><%=employee.getDept() %></td>
	<td>
		<a href="EmployeeServlet?action=edit&id=<%=employee.getId()%>">Edit</a>&nbsp;
		<a href="EmployeeServlet?action=delete&id=<%=employee.getId()%>">Delete</a>&nbsp;
		<a href="EmployeeServlet?action=view&id=<%=employee.getId()%>">View</a>&nbsp;
	</td>
	</tr>
	<%
}
%>
</table>
</body>
</html>