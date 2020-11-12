
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Brnd-logo Website Template | Checkout :: w3layouts</title>
<link href="aa/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="aa/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="keywords"
	content="Bonfire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!--fonts-->
<link
	href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css'>
<!--//fonts-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!--slider-script-->
<script src="js/responsiveslides.min.js"></script>
<script>
	$(function() {
		$("#slider1").responsiveSlides({
			auto : true,
			speed : 500,
			namespace : "callbacks",
			pager : true,
		});
	});
</script>
<!--//slider-script-->
<script>
	$(document).ready(function(c) {
		$('.alert-close').on('click', function(c) {
			$('.message').fadeOut('slow', function(c) {
				$('.message').remove();
			});
		});
	});
</script>
<script>
	$(document).ready(function(c) {
		$('.alert-close1').on('click', function(c) {
			$('.message1').fadeOut('slow', function(c) {
				$('.message1').remove();
			});
		});
	});
</script>

<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!---- start-smoth-scrolling---->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!---- start-smoth-scrolling---->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
</script>
<!----webfonts--->
<link
	href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic'
	rel='stylesheet' type='text/css'>
<!---//webfonts--->
<!----start-top-nav-script---->
<script>
	$(function() {
		var pull = $('#pull');
		menu = $('nav ul');
		menuHeight = menu.height();
		$(pull).on('click', function(e) {
			e.preventDefault();
			menu.slideToggle();
		});
		$(window).resize(function() {
			var w = $(window).width();
			if (w > 320 && menu.is(':hidden')) {
				menu.removeAttr('style');
			}
		});
	});
</script>
<!----//End-top-nav-script---->
</head>
<body>
	<!----container---->
	<div class="container">
		<!----top-header---->
		<div class="top-header">
			<div class="logo">
				<a href="index.html"><img src="images/logo.png"
					title="barndlogo" /></a>
			</div>
			<div class="top-header-info">
				<div class="top-contact-info">
					<ul class="unstyled-list list-inline">
						<li><span class="phone"> </span>090 - 223 44 66</li>
						<li><span class="mail"> </span><a href="#">help@trendd.com</a></li>
						<div class="clearfix"></div>
					</ul>
				</div>
				<div class="cart-details">
					<div class="add-to-cart">
						<ul class="unstyled-list list-inline">
							<li><span class="cart"> <a href="#" class="cart-in">
								</a> <span>${listcart.size()}</span>
							</span>


								<ul class="sub-icon1 list">
									<h3>Recently added items</h3>
									<div class="shopping_cart">


										<c:forEach items="${listcart}" var="listcart">
											<div class="cart_box">
												<div class="message">
													<a
														href="Deletecartservlet?command=remove&idcart=${listcart.getIdcart()}">
														<div class="alert-close"></div>
														<div class="list_img">
															<img src="${listcart.getUrl()}" class="img-responsive"
																alt="">
														</div>
														<div class="list_desc">
															<h4>
																<a>${listcart.getName()}</a>
															</h4>${listcart.getQty()}
															x<span class="actual"> ${listcart.getPrice()} $</span>
															(Size: ${listcart.getSize()})
														</div>
														<div class="clearfix"></div>
												</div>
											</div>
										</c:forEach>


										<div class="total">
											<div class="total_left">CartSubtotal :</div>
											<div class="total_right">${Total}$</div>
											<div class="clearfix"></div>
										</div>
										<div class="login_buttons">
											<c:if test="${Total > 0}">
												<div class="check_button">
													<a href="CheckOutServlet">Check out</a>
												</div>
											</c:if>
											<div class="clearfix"></div>
										</div>
										<div class="clearfix"></div>
								</ul></li>
						</ul>
					</div>
					<div class="login-rigister">
						<ul class="unstyled-list list-inline">
							<c:if test="${checklogin}">
								<li><a class="login" href="sevletlogin">Login</a></span></span></li>
							</c:if>
							<li><a class="rigister" href="Registration.jsp">REGISTER
									<span> </span>
							</a></li>
							<li><a class="login" href="servletlogout"></span></span>Logout--${NameUser}</a></li>
							<div class="clearfix"></div>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
		<!----//top-header---->
		<!---top-header-nav---->
		<div class="top-header-nav">
			<!----start-top-nav---->
			<nav class="top-nav main-menu">
				<ul class="top-nav">

					<li><a href="sevletindex">HOME </a><span> </span></li>
					<c:if test="${check}">
						<li><a href="ManagerServletindex">MANAGER</a><span> </span></li>
					</c:if>
					<li><a href="servletproduct">Products</a><span> </span></li>
					<li><a href="products.html">BRANDS</a><span> </span></li>
					<li><a href="products.html">ABOUT US</a></li>
					<div class="clearfix"></div>

				</ul>
				<a href="#" id="pull"><img src="images/nav-icon.png"
					title="menu" /></a>
			</nav>
			<!----End-top-nav---->
			<!---top-header-search-box--->
			<div class="top-header-search-box">
				<form>
					<input type="text" placeholder="Search" required / maxlength="22">
					<input type="submit" value=" ">
				</form>
			</div>
			<!---top-header-search-box--->
			<div class="clearfix"></div>
		</div>
	</div>
	<!--//top-header-nav---->
	<!----contact---->
	<div class="contact-info">

		<div class="container">
			<div class="contact-grids">
				<div class="col_1_of_bottom span_1_of_first1">
					<h5>Address</h5>
					<ul class="list3">
						<li><img src="images/home.png" alt="">
							<div class="extra-wrap">
								<p>
									Lorem ipsum consectetu,<br>dolor sit amet,.
								</p>
							</div></li>
					</ul>
				</div>
				<div class="col_1_of_bottom span_1_of_first1">
					<h5>Phones</h5>
					<ul class="list3">
						<li><img src="images/phone.png" alt="">
							<div class="extra-wrap">
								<p>
									<span>Telephone:</span>+1 800 258 2598
								</p>
							</div> <img src="images/fax.png" alt="">
							<div class="extra-wrap">
								<p>
									<span>FAX:</span>+1 800 589 2587
								</p>
							</div></li>
					</ul>
				</div>
				<div class="col_1_of_bottom span_1_of_first1">
					<h5>Email</h5>
					<ul class="list3">
						<li><img src="images/email.png" alt="">
							<div class="extra-wrap">
								<p>
									<span class="mail"><a href="mailto:yoursite.com">info(at)brndlogo.com</a></span>
								</p>
							</div></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>

			<div class="account">
				<h2 class="account-in">CHECKOUT</h2>
				<form action="CheckOutServlet" method="POST">
					<div>
						<span>Address *</span> <input type="text" name="address">
					</div>
					<div>
						<span>Payment *</span> <select name="payment">
							<option value="Bank transfer">Bank transfer</option>
							<option value="Direct payment">Direct payment</option>
						</select>
					</div>
					<input type="hidden" name="total"
						value="<%=request.getParameter("total")%>"> <input
						type="submit" value="Checkout">
				</form>
			</div>
		</div>
</body>
</html>
