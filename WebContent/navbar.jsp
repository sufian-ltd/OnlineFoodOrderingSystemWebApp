<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- id contact time date persons advance due cost foods -->
<nav
	class="navbar navbar-expand-lg mb-4 top-bar navbar-static-top sps sps--abv">
	<div class="container">
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarCollapse1"
			aria-controls="navbarCollapse" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<c:url var="linkHome" value="HomeController">
			<c:param name="command" value="home"></c:param>
		</c:url>
		<c:url var="linkAllFood" value="HomeController">
			<c:param name="command" value="LOAD_ALL_FOOD"></c:param>
		</c:url>
		<c:url var="linkBookTable" value="HomeController">
			<c:param name="command" value="LOAD_FOOD_TABLE"></c:param>
		</c:url>
		<a class="navbar-brand mx-auto" href="#">Easy<span> Food
				Order</span></a>
		<div class="collapse navbar-collapse" id="navbarCollapse1">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="${linkHome}">Home <span class="sr-only">(current)</span></a>
				</li>

				<li class="nav-item"><a class="nav-link" href="${linkAllFood}">View
						All Food</a></li>
				<li class="nav-item"><a class="nav-link" href="${linkBookTable}">Book Table</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="about.jsp">About</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="admin-login.jsp">Admin</a>
				</li>
			</ul>
		</div>
	</div>
</nav>
