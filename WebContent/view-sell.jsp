<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Food</title>

<jsp:include page="ref-link.jsp"></jsp:include>
<link href="food2.css" rel="stylesheet" type="text/css" />
</head>
<body style="background-color: #000000">
	<jsp:include page="navbar.jsp"></jsp:include>
	<%-- 	<jsp:include page="slider.jsp"></jsp:include> --%>
	<section class="service-sec" id="benefits"> <br />
	<div align="center" class="container-fluid"
		style="background-color: #000000">
		<div class="row">
			<c:forEach var="tempFood" items="${FOOD_LIST}">
				<div class="col-md-3 col-sm-3">
					<div align="center" class="feature-gallery">
						<img class="thumb"
							src="data:image/jpg;base64,${tempFood.base64Image}" width="400"
							height="400" alt="" title="">
						<div class="fg-overlay" align="center">
							<h2>Name : ${tempFood.foodName}</h2>
							<h2>Price : ${tempFood.foodPrice} TK</h2>
							<a href="#" class="btn btn-sm btn-danger">Click here</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<input type="button" value="Total Cost : ${customer.cost} TK"
			style="font-size: 25px; border-radius: 74px; width: 300px; height: 50px;"
			class="form-control btn btn-sm btn-danger"><input
			type="submit" value="Number of Food : ${customer.numberOfFood}"
			style="font-size: 25px; border-radius: 74px; width: 300px; height: 50px;"
			class="form-control btn btn-sm btn-danger">
		<%-- 			<jsp:include page="test4.jsp"></jsp:include> --%>
		<br style="color: silver;"></br>
		<h1>Congratulation..!!! You successfully  purchase these foods...!!!!!</h1>
		<hr color="#ffffff"></hr>
		<br />
		<div style="font-size: 26px; color: green;font-family: cursive;">
			<table>
				<tr>
					<td>Your Full Name :</td>
					<td>${customer.name}</td>
				</tr>
				<tr>
					<td>Your current Address :</td>
					<td>${customer.address}</td>
				</tr>
				<tr>
					<td>Your Cell Number :</td>
					<td>${customer.cellNo}</td>
				</tr>
				<tr>
					<td>Advance Payment :</td>
					<td>${customer.advancePayment}</td>
				</tr>
				<tr>
					<td>Due :</td>
					<td>${customer.due}</td>
				</tr>
				<tr>
					<td>Service type :</td>
					<td>${customer.service}</td>
				</tr>
			</table>
		</div>
	</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

<jsp:include page="jscode.jsp"></jsp:include>