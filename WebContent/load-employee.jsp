<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Data</title>
<jsp:include page="ref-link.jsp"></jsp:include>
<link href="food2.css" rel="stylesheet" type="text/css" />

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
	<jsp:include page="nav-slider-admin.jsp"></jsp:include>
	<%-- 	<jsp:include page="slider.jsp"></jsp:include> --%>
	<section class="service-sec" id="benefits"> <br></br>
	<br></br>
	<div class="container" align="center">
		<h1 class="btn btn-block btn-lg btn-primary">Please fill the form
			properly..!!!</h1>
		<hr color="#ffffff"></hr>
		<br></br>
		<form action="AdminController" method="post">
			<input type="hidden" name="command" value="UPDATE_EMPLOYEE" /> <input
				type="hidden" name="id" value="${employee.id}" />
			<table border="2" style="font-size: 20px; color: white;">
				<tbody>
					<tr>
						<td align="center"><label>Employee Name : </label></td>
						<td><input type="text" name="name" value="${employee.name}" /></td>
					</tr>
					<tr>
						<td align="center"><label>Employee Address : </label></td>
						<td><input type="text" name="address"
							value="${employee.address}" /></td>
					</tr>
					<tr>
						<td align="center"><label>Contact Number : </label></td>
						<td><input type="text" name="contact"
							value="${employee.contact}" /></td>
					</tr>
					<tr>
						<td align="center"><label>Employee salary : </label></td>
						<td><input type="number" name="salary"
							value="${employee.salary}" /></td>
					</tr>
				</tbody>
			</table>
			<br /> <input type="submit" value="Click here to Update"
				class="btn btn-block btn-lg btn-warning">
		</form>
	</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
<jsp:include page="jscode.jsp"></jsp:include>