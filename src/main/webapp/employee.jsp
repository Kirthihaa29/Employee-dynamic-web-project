<%@page import="com.company.ems.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="EmployeeServlet" method="POST">
<%
String action=request.getParameter("action");
%>
<input type="hidden" name="action" value="update"/>
<%
Employee employee=(Employee)session.getAttribute("employee");

%>
<table>

<tr>
<td>Id</td>
<td><input type="text" name="id" id="id" value="<%=employee.getId() %>" <%=action.equalsIgnoreCase("view")?"disabled":"" %> /></td>
</tr>


<tr>
<td>First Name</td>
<td><input type="text" name="firstName" id="firstName" value="<%=employee.getFirstName() %>" <%=action.equalsIgnoreCase("view")?"disabled":"" %>  /></td>
</tr>


<tr>
<td>Last Name</td>
<td><input type="text" name="lastName" id="lastName" value="<%=employee.getLastName() %>" <%=action.equalsIgnoreCase("view")?"disabled":"" %> /></td>
</tr>

<tr>
<td>DOB</td>
<td><input type="text" name="dob" id="dob" value="<%=employee.getDob()%>" <%=action.equalsIgnoreCase("view")?"disabled":"" %>/></td>
</tr>

<tr>
<td>Sal</td>
<td><input type="text" name="sal" id="sal" value="<%=employee.getSal() %>" <%=action.equalsIgnoreCase("view")?"disabled":"" %> /></td>
</tr>

<tr>
<td>Dept</td>
<td><input type="text" name="dept" id="dept" value="<%=employee.getDept()%>" <%=action.equalsIgnoreCase("view")?"disabled":"" %>/></td>
</tr>

</table>
<%=action.equalsIgnoreCase("edit")?"<input type='submit' />":"" %><br/>
<a href="EmployeeServlet">List</a>



</form>

</body>
</html>