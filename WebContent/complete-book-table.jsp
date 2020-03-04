<%@page import="com.controller.servlets.HomeController"%>
<%@page import="com.controller.servlets.HomeController.*"%>
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
<link href="checkbox.css" rel="stylesheet" type="text/css" />
</head>
<body style="background-color: #151515">
	<jsp:include page="navbar.jsp"></jsp:include>
	<%-- 	<jsp:include page="slider.jsp"></jsp:include> --%>
	<section class="service-sec" id="benefits"> <br />
	<div align="center" class="container-fluid">
		<form action="HomeController" method="post">
			<div class="row" style="background-color: #000000">
				<input type="hidden" name="command" value="BOOK_TABLE">
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
						<div align="justify">
							<label class="switch"> <input name="checkbox"
								type="checkbox" checked="checked" value="${tempFood.id}">
								<span class="slider round"></span>
							</label> <select class="btn btn-sm btn-danger" name="numFood"
								style="font-size: 18px; position: absolute; border-radius: 74px; width: 120px; height: 34px;">
								<c:forEach var="i" begin="1" end="10" varStatus="loop">
								<c:choose>
									<c:when test="${i==tempFood.numOfFood}">
										<option selected="selected" value="${i}">Items : ${i}</option>
									</c:when>
									<c:otherwise>
										<option value="${i}">Items : ${i}</option>
									</c:otherwise>
								</c:choose>
								</c:forEach>
							</select>
						</div>
					</div>
				</c:forEach>
			</div>
			<br /> <input type="button" value="Total Cost : ${cost} TK"
				style="font-size: 25px; border-radius: 74px; width: 300px; height: 50px;"
				class="form-control btn btn-sm btn-danger"> <input
				type="button" value="Calculate Again"
				style="font-size: 25px; border-radius: 74px; width: 300px; height: 50px;"
				class="form-control btn btn-sm btn-danger"> <br></br>
			<h1 class="btn btn-block btn-lg btn-warning">Please fill the
				form to book a table for these foods</h1>
			<hr color="#ffffff"></hr>
			<br />
			<div
				style="font-size: 20px; color: white; background-color: #151515;">
				<table border="2"
					title="Please fill the form to purchase these foods">
					<tr style="box-shadow: white; margin: 5px; width: 100px">
						<td>Enter Contact Number : </td>
						<td align="center"><input align="middle" type="text"
							name="contact" size="50" required="required" /></td>
					</tr>
					<tr>
						<td>Number of people : </td>
						<td align="center"><input align="middle" type="text"
							name="persons" size="50" required="required" /></td>
					</tr>
					<tr>
						<td align="center">Advance Payment : </td>
						<td align="center"><input align="middle" type="text"
							name="advancepayment" size="50" required="required" /></td>
					</tr>
				</table>
				<br> <input type="submit" value="Click here to Booking Table"
					class="btn btn-block btn-lg btn-success">
			</div>
		</form>

	</div>

	</section>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

<jsp:include page="jscode.jsp"></jsp:include>