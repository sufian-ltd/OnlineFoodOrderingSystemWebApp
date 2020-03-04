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
		<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setHeader("Expires", "0"); //proxies
	if(session.getAttribute("email")==null){
		response.sendRedirect("admin-login.jsp");
	}
	%>
	<jsp:include page="navbar.jsp"></jsp:include>
	<%-- 	<jsp:include page="slider.jsp"></jsp:include> --%>
	<section class="service-sec" id="benefits"> <br />
	<div align="center" class="container-fluid">
		<form action="HomeController" method="post">
			<div class="row" style="background-color: #000000">
				<input type="hidden" name="command" value="PURCHASE_FOOD">
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
							<%-- 							<c:choose> --%>
							<%-- 								<c:when test="${isChecked}"> --%>
							<label class="switch"> <input name="checkbox"
								type="checkbox" checked="checked" value="${tempFood.id}">
								<span class="slider round"></span>
							</label>
							<%-- 								</c:when> --%>
							<%-- 								<c:otherwise> --%>
							<!-- 									<label class="switch"> <input name="checkbox" -->
							<%-- 										type="checkbox" value="${tempFood.id}"> <span --%>
							<!-- 										class="slider round"></span> -->
							<!-- 									</label> -->
							<%-- 								</c:otherwise> --%>
							<%-- 							</c:choose> --%>
							<select class="btn btn-sm btn-danger" name="numFood"
								style="font-size: 18px; position: absolute; border-radius: 74px; width: 80px; height: 34px;">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>
						</div>
					</div>
				</c:forEach>
			</div>
			<br></br>
			<h1>Please fill the form to purchase these foods</h1>
			<hr color="#ffffff"></hr>
			<br />
			<div
				style="font-size: 20px; color: white; background-color: #151515;">
				<table border="2"
					title="Please fill the form to purchase these foods">
					<tr style="box-shadow: white; margin: 5px; width: 100px">
						<td>Enter Your Full Name :</td>
						<td align="center"><input align="middle" type="text"
							name="customername" size="50" required="required" /></td>
					</tr>
					<tr>
						<td>Your current Address :</td>
						<td align="center"><input align="middle" type="text"
							name="customeraddress" size="50" required="required" /></td>
					</tr>
					<tr>
						<td>Valid Cell Number :</td>
						<td align="center"><input align="middle" type="text"
							name="customercellno" size="50" required="required" /></td>
					</tr>
					<tr>
						<td align="center">Advance Payment :</td>
						<td align="center"><input align="middle" type="text"
							name="advancepayment" size="50" required="required" /></td>
					</tr>
					<tr>
						<td align="center">Choose service type :</td>
						<td align="center"><select name="servicetype"
							required="required">
								<option>Home delivery</option>
								<option>Order</option>
						</select></td>
					</tr>
					<tr>
						<td align="center">Click Here</td>
						<td align="center"><input type="submit"
							value="Ready to Purchase"></td>
					</tr>
				</table>
			</div>
		</form>

	</div>

	</section>
	<!-- Grid row -->

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

<jsp:include page="jscode.jsp"></jsp:include>