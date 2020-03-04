<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.*,com.controller.servlets.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Panel</title>
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
	<jsp:include page="slider.jsp"></jsp:include>
	<section class="service-sec" id="benefits">
	<div class="container" align="center">
		<!-- Select Basic -->
		<div class="form-group">
			<div>
				<form action="AdminController" method="post">
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
	</div>

	<div class="container-fluid">
		<div class="row">
			<c:forEach var="tempFood" items="${FOOD_LIST}">
				<c:url var="tempLink" value="AdminController">
					<c:param name="command" value="LOAD_FOOD" />
					<c:param name="id" value="${tempFood.id}" />
				</c:url>
				<c:url var="tempLinkDelete" value="AdminController">
					<c:param name="command" value="DELETE_FOOD" />
					<c:param name="id" value="${tempFood.id}" />
				</c:url>
				<div align="center" class="col-md-3 col-sm-3">
					<div class="feature-gallery">
						<img class="thumb" name="photo"
							src="data:image/jpg;base64,${tempFood.base64Image}" width="400"
							height="400" alt="" title="">
						<div class="fg-overlay" align="center">
							<h2>Name : ${tempFood.foodName}</h2>
							<h2>Price : ${tempFood.foodPrice} TK</h2>
						</div>
					</div>
					<a href="${tempLink}" class="btn btn-lg btn-success"
						style="width: 120px; size: auto; font-size: 22px">Update</a> <a
						style="width: 120px; size: auto; font-size: 22px"
						onclick="if(!(confirm('Are you sure you want to delete this statement?'))) return false;"
						href="${tempLinkDelete}" class="btn btn-lg btn-danger">Delete</a>
				</div>
				<br></br>
			</c:forEach>

		</div>
	</div>

	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
<jsp:include page="jscode.jsp"></jsp:include>