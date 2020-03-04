<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Employee</title>
<jsp:include page="ref-link.jsp"></jsp:include>

</head>
<body style="background-color: #151515">
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires", "0"); //proxies
		if (session.getAttribute("email") == null) {
			response.sendRedirect("admin-login.jsp");
		}
	%>


	<section class="service-sec" id="benefits">
	<div class="container" align="center">
		<br></br> <br></br>
		<center style="font-size: 20px; color: white;">
			<h1>Please fill the form properly..!!!</h1>
			<hr color="#ffffff"></hr>

			<form method="post" action="AdminController">
				<input type="hidden" name="command" value="SAVE_EMPLOYEE">
				<hr color="#ffffff"></hr>
				<br />
				<table border="1">
					<tr>
						<td align="center">Enter Employee Name : </td>
						<td><input type="text" name="name" size="50" /></td>
					</tr>
					<tr>
						<td align="center">Enter Address : </td>
						<td><input type="text" name="address" size="50" /></td>
					</tr>
					<tr>
						<td align="center">Enter Contact Number : </td>
						<td><input type="text" name="contact" size="50" /></td>
					</tr>
					<tr>
						<td align="center">Enter Employee Salary : </td>
						<td><input type="number" name="salary" size="50" /></td>
					</tr>
				</table>
				<br /> <input type="submit" value="Click here to Save Employee"
					class="btn btn-block btn-lg btn-success">
			</form>
		</center>
	</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
<jsp:include page="jscode.jsp"></jsp:include>
