<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Food</title>
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
	<section class="service-sec" id="benefits">
	<div class="container" align="center">
		<br></br> <br></br>
		<center style="font-size: 20px; color: white;">
			<h1>All Employee list..!!!</h1>
			<input type="button" value="Click here to Add new Employee"
				class="btn btn-block btn-lg btn-success" style="font-size: 22px;"
				onclick="window.location.href='add-employee-form.jsp';return false;" />
			<hr color="#ffffff"></hr>

			<br />
			<table border="1">
				<tr align="center">
					<th align="center">Employee ID</th>
					<th align="center">Employee Name</th>
					<th align="center">Address</th>
					<th align="center">Contact</th>
					<th align="center">Salary</th>
					<th align="center">Update</th>
					<th align="center">Delete</th>
				</tr>
				<c:forEach var="temp" items="${employee}">
					<c:url var="linkUpdate" value="AdminController">
						<c:param name="command" value="LOAD_EMPLOYEE" />
						<c:param name="id" value="${temp.id}" />
					</c:url>
					<c:url var="linkDelete" value="AdminController">
						<c:param name="command" value="DELETE_EMPLOYEE" />
						<c:param name="id" value="${temp.id}" />
					</c:url>
					<tr>
						<td align="center">${temp.id}</td>
						<td align="center">${temp.name}</td>
						<td align="center">${temp.address}</td>
						<td align="center">${temp.contact}</td>
						<td align="center">${temp.salary}</td>
						<td align="center"><a href="${linkUpdate}"> Update</a></td>
						<td align="center"><a href="${linkDelete}"
							onclick="if(!(confirm('Are you sure you want to delete this statement?'))) return false;">
								Delete</a></td>
					</tr>
				</c:forEach>
			</table>
			<br />
		</center>
	</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
<jsp:include page="jscode.jsp"></jsp:include>
