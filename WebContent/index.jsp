<%@page import="javax.swing.plaf.basic.BasicListUI.ListDataHandler"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Product"%>
<%@ page import="Dao.web.com.ContactDao"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title>Brnd-logo Website Template | Home :: w3layouts</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="aa/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="aa/style.css" rel='stylesheet' type='text/css' />
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
				<a href="sevletindex"><img src="images/logo.png"
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
														href="Deletecartindex?command=remove&idcart=${listcart.getIdcart()}">
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
							<li><a class="rigister" href="servletregistration">REGISTER
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
	<!----start-slider-script---->
	<script src="js/responsiveslides.min.js"></script>
	<script>
		// You can also use "$(window).load(function() {"
		$(function() {
			// Slideshow 4
			$("#slider4").responsiveSlides({
				auto : true,
				pager : true,
				nav : true,
				speed : 500,
				namespace : "callbacks",
				before : function() {
					$('.events').append("<li>before event fired.</li>");
				},
				after : function() {
					$('.events').append("<li>after event fired.</li>");
				}
			});

		});
	</script>
	<!----//End-slider-script---->
	<!-- Slideshow 4 -->
	<div id="top" class="callbacks_container">
		<ul class="rslides" id="slider4">
			<li><img src="images/slide1.png" alt="">
				<div class="caption">
					<div class="slide-text-info">
						<h1>WILL HELM</h1>
						<label>WINTER</label>

					</div>
				</div></li>
			<li><img src="images/slide1.jpg" alt="">
				<div class="caption">
					<div class="slide-text-info">
						<h1>FAST NER2</h1>
						<label>Dress Shoe</label>

					</div>
				</div></li>
			<li><img src="images/slide2.png" alt="">
				<div class="caption">
					<div class="slide-text-info">
						<h1>WILL HELM</h1>
						<label>WINTER</label>

					</div>
				</div></li>
		</ul>
	</div>
	<div class="clearfix"></div>
	<!----- //End-slider---->
	<!----content---->
	<div class="content">
		<div class="container">
			<!---top-row--->
			<div class="top-row">


				<vdi class="clearfix">
			</div>
		</div>
		<!---top-row--->
		<div class="container">
			<!----speical-products---->
			<div class="special-products">
				<div class="s-products-head">
					<div class="s-products-head-left">
						<h3>
							<span>PRODUCTS</span>
						</h3>
					</div>
					<div class="s-products-head-right"></div>
					<div class="clearfix"></div>
				</div>
				<!----special-products-grids---->
				<div class="special-products-grids">
					<c:forEach items="${listpage}" var="listpage">
						<div class="col-md-3 special-products-grid text-center">
							<a class="brand-name"
								href="servletsinglepage?productid=${listpage.getShoesid()}&category=${listpage.getCategory()}"><img
								src="${listpage.getUrllogo()} " title="name"
								style="width: 80px; height: 40px" /></a> <a class="product-here"
								href="servletsinglepage?productid=${listpage.getShoesid()}&category=${listpage.getCategory()}"><img
								src="${listpage.getUrl()} " title="product-name" /></a>
							<h4>
								<a
									href="servletsinglepage?productid=${listpage.getShoesid()}&category=${listpage.getCategory()}">${listpage.getName()}</a>
							</h4>
							<a class="product-btn"
								href="servletsinglepage?productid=${listpage.getShoesid()}&category=${listpage.getCategory()}"><span>${listpage.getPrice()}
									$</span><small>GET NOW</small><label> </label></a>
						</div>

					</c:forEach>

					<div class="clearfix"></div>
				</div>

				<ul class="start">
					<li><a href="#"><i></i></a></li>
					<%
						int a, b;
						HttpSession sess = request.getSession();
						List<Product> arr = ContactDao.getList();
						int limit = arr.size() / 4;
						if (limit * 4 < arr.size()) {
							limit += 1;
						}
						for (int i = 1; i <= limit; i++) {
							a = (i - 1) * 4;
							b = i * 4;
							if (b > arr.size()) {
								b = arr.size();
							}

							sess.setAttribute("a", a);
							sess.setAttribute("b", b);
					%>
					<li class="arrow"><a
						href="sevletindex?start=<%=a%>&end=<%=b%>"><%=i%></a></li>
					<%
						}
					%>

					<li><a
						href="sevletindex?start=<%=(Integer) sess.getAttribute("a")%>&end=<%=(Integer) sess.getAttribute("b")%>"><i
							class="next"> </i></a></li>
				</ul>
				<!---//special-products-grids---->
			</div>
			<!---//speical-products---->
		</div>
		<!----content---->
		<!----footer--->
		<div class="footer">
			<div class="container">
				<div class="col-md-3 footer-logo">
					<a href="index.html"><img src="images/flogo.png"
						title="brand-logo" /></a>
				</div>
				<div class="col-md-7 footer-links">
					<ul class="unstyled-list list-inline">
						<li><a href="#"> Faq</a> <span> </span></li>
						<li><a href="#"> Terms and Conditions</a> <span> </span></li>
						<li><a href="#"> Secure Payments</a> <span> </span></li>
						<li><a href="#"> Shipping</a> <span> </span></li>
						<li><a href="contact.html"> Contact</a></li>
						<div class="clearfix"></div>
					</ul>
				</div>
				<div class="col-md-2 footer-social">
					<ul class="unstyled-list list-inline">
						<li><a class="pin" href="#"><span> </span></a></li>
						<li><a class="twitter" href="#"><span> </span></a></li>
						<li><a class="facebook" href="#"><span> </span></a></li>
						<div class="clearfix"></div>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="clearfix"></div>
		<!---//footer--->
		<!---copy-right--->
		<div class="copy-right">
			<div class="container">
				<p>
					Template by <a href="http://w3layouts.com/">W3layouts</a>
				</p>
				<script type="text/javascript">
					$(document).ready(function() {
						/*
						var defaults = {
							containerID: 'toTop', // fading element id
							containerHoverID: 'toTopHover', // fading element hover id
							scrollSpeed: 1200,
							easingType: 'linear' 
						};
						 */

						$().UItoTop({
							easingType : 'easeOutQuart'
						});

					});
				</script>
				<a href="#" id="toTop" style="display: block;"> <span
					id="toTopHover" style="opacity: 1;"> </span></a>
			</div>
		</div>
		<!--//copy-right--->
	</div>
	<!----container---->
</body>
</html>

