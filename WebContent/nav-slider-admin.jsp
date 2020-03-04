<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav
	class="navbar navbar-expand-lg mb-4 top-bar navbar-static-top sps sps--abv">
	<div class="container">
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarCollapse1"
			aria-controls="navbarCollapse" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand mx-auto" href="#">Easy<span> Food
				Order</span></a>
		<div class="collapse navbar-collapse" id="navbarCollapse1">
			<c:url var="viewFoodLink" value="AdminController">
				<c:param name="command" value="VIEW_FOOD" />
			</c:url>
			<c:url var="addFoodLink" value="AdminController">
				<c:param name="command" value="ADD_FOOD" />
			</c:url>
			<c:url var="linkEmployee" value="AdminController">
				<c:param name="command" value="VIEW_EMPLOYEE"></c:param>
			</c:url>
			<c:url var="linkAllFood" value="AdminController">
				<c:param name="command" value="LOAD_ALL_FOOD"></c:param>
			</c:url>
			<c:url var="linkAllOrders" value="AdminController">
				<c:param name="command" value="LOAD_ALL_ORDERS"></c:param>
			</c:url>
			<c:url var="linkLogout" value="AdminController">
				<c:param name="command" value="LOGOUT"></c:param>
			</c:url>

			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="${viewFoodLink}">View
						Foods</a></li>
				<li class="nav-item"><a class="nav-link" href="${linkAllFood}">View
						All Food</a></li>
				<li class="nav-item"><a class="nav-link" href="${addFoodLink}">Add
						Food</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${linkAllOrders }">View Customer Orders</a></li>
				<li class="nav-item"><a class="nav-link" href="${linkEmployee}">View
						Employee</a></li>
				<li class="nav-item"><a class="nav-link" href="${linkLogout}">Logout</a>
				</li>
			</ul>

		</div>
	</div>
</nav>

<!-- <!-- Swiper Silder -->
<!--     ================================================== -->
<!-- <!-- Slider main container -->
<!-- <div class="swiper-container main-slider" id="myCarousel"> -->
<!-- 	<div class="swiper-wrapper"> -->
<!-- 		<div class="swiper-slide slider-bg-position" -->
<!-- 			style="background: url('https://urbanmatter.com/chicago/wp-content/uploads/2015/04/Top-10-Restaurants.jpg')" -->
<!-- 			data-hash="slide1"> -->
<!-- 		</div> -->
<!-- 		<div align="center" class="swiper-slide slider-bg-position" -->
<!-- 			style="background: url('https://www.stanleyhotel.com/uploads/9/8/6/9/98696462/editor/20111115-cascades001v2_3.jpeg?1492712982')" -->
<!-- 			data-hash="slide2"> -->
<!-- 		</div> -->
<!-- 		<div align="center" class="swiper-slide slider-bg-position" -->
<!-- 			style="background: url('https://s3.amazonaws.com/tinycards/image/6e4a08bc38c012e84524f067d8b4378a')" -->
<!-- 			data-hash="slide2"> -->
<!-- 		</div> -->
<!-- 		<div align="center" class="swiper-slide slider-bg-position" -->
<!-- 			style="background: url('https://cdn0.tnwcdn.com/wp-content/blogs.dir/1/files/2012/10/Food.jpg')" -->
<!-- 			data-hash="slide2"> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	<!-- Add Pagination -->
<!-- 	<div class="swiper-pagination"></div> -->
<!-- 	<!-- Add Navigation -->
<!-- 	<div class="swiper-button-prev"> -->
<!-- 		<i class="fa fa-chevron-left"></i> -->
<!-- 	</div> -->
<!-- 	<div class="swiper-button-next"> -->
<!-- 		<i class="fa fa-chevron-right"></i> -->
<!-- 	</div> -->
<!-- </div> -->