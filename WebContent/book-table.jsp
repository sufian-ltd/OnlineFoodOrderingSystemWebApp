<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<jsp:include page="ref-link.jsp"></jsp:include>
<link href="food2.css" rel="stylesheet" type="text/css" />
<link href="checkbox.css" rel="stylesheet" type="text/css" />

</head>
<body style="background-color: #151515">
	<jsp:include page="navbar.jsp"></jsp:include>
	<section class="service-sec" id="benefits">
	<div class="container" align="center">
		<!-- Select Basic -->
		<div class="form-group">
			<div>
				<form action="HomeController" method="post">
					<input type="hidden" name="command" value="SEARCH"> <select
						style="font-size: 22px; width: !important; height: 50px;"
						name="selectedcatagory" class="form-control btn warning">
						<c:forEach var="temp" items="${CATAGORY_LIST}">
							<c:choose>
								<c:when test="${temp==selected}">
									<option selected="selected">${temp}</option>
								</c:when>
								<c:otherwise>
									<option>${temp}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <br></br> <input type="submit"
						value="Search Food for selecte catagory" style="font-size: 22px;"
						class="btn btn-block btn-lg btn-primary">
				</form>
			</div>

		</div>
		<br />
	</div>
	<div class="container-fluid">
		<form action="HomeController" method="post">


			<input type="submit" class="btn btn-block btn-lg btn-success"
				style="font-size: 22px;"
				value="Click here to Book table for these food">


			<div class="row" style="background-color: #151515">

				<input type="hidden" name="command" value="SELECTED_FOOD_TABLE">
				<input type="hidden" name="selectedcatagory"
					value="${selectedcatagory}">
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
						<div align="justify" class="feature-gallery">
							<label class="switch"> <input name="checkbox"
								type="checkbox" value="${tempFood.id}"> <span
								class="slider round"></span>
							</label> <select class="btn btn-sm btn-danger" name="${tempFood.id}"
								style="font-size: 18px; position: absolute; border-radius: 74px; width: 120px; height: 34px;">
								<c:forEach var="i" begin="1" end="10" varStatus="loop">
									<option value="${i}">Items : ${i}</option>
								</c:forEach>
							</select>
						</div>
					</div>

				</c:forEach>
			</div>
			<input type="submit" class="btn btn-block btn-lg btn-success"
				style="font-size: 22px;"
				value="Click here to Book table for these food">
		</form>
	</div>

	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>

<jsp:include page="jscode.jsp"></jsp:include>


