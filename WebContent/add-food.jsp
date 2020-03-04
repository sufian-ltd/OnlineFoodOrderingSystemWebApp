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
	if(session.getAttribute("email")==null){
		response.sendRedirect("admin-login.jsp");
	}
	%>


	<jsp:include page="nav-slider-admin.jsp"></jsp:include>
<%-- 	<jsp:include page="slider.jsp"></jsp:include> --%>
	<section class="service-sec" id="benefits">
	<div class="container" align="center">
	<br></br>
	<br></br>
		<center style="font-size: 20px; color: white;">
			<h1>Please fill the form properly..!!!</h1>
						<hr color="#ffffff"></hr>
			
			<form method="post" action="AdminController"
				enctype="multipart/form-data">
				<input type="hidden" name="command" value="SAVE_FOOD"> <select
					name="selectedCatagory">
					<c:forEach var="temp" items="${CATAGORY_LIST}">
						<option>${temp}</option>
					</c:forEach>
				</select>
			<hr color="#ffffff"></hr>
			<br/>
				<table border="1">
					<tr>
						<td align="center">Food Catagory : </td>
						<td><input type="text" name="newcatagory" size="50" /></td>
					</tr>
					<tr>
						<td align="center">Food Name : </td>
						<td><input type="text" name="foodname" size="50" /></td>
					</tr>
					<tr>
						<td align="center">Food Price : </td>
						<td><input type="text" name="foodprice" size="50" /></td>
					</tr>
					<tr>
						<td align="center">Choose Photo : </td>
						<td><input type="file" name="photo" size="50" /></td>
					</tr>
					<tr>
<!-- 					<td align="center"></td> -->
<!-- 						<td align="center"><input class="btn success" type="submit" value="Save Data"></td> -->
<!-- 					</tr> -->
				</table>
				<br/>
				<input type="submit"
					value="Click here to Save"
					class="btn btn-block btn-lg btn-success">
			</form>
		</center>
	</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
<jsp:include page="jscode.jsp"></jsp:include>
