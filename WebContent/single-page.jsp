<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Size"%>
<%@ page import="Model.Cart"%>
<%@ page import="java.util.List"%>
<%@ page import="Model.Qty"%>
<%@ page import="Dao.web.com.CartDao"%>
<%@ page import="Model.Product"%>
<%@ page import="Dao.web.com.ContactDao"%>
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
<title>Brnd-logo Website Template | Details :: w3layouts</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="aa/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="aa/style.css" rel='stylesheet' type='text/css' />
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
				<a href="servletsinglepage"><img src="images/logo.png"
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
	<!----content---->
	<div class="content">
		<div class="container">
			<!--- products ---->
			<div class="products">
				<div class="product-filter">

					<div class="product-filter-grids">
						<div class="col-md-3 product-filter-grid1-brands">

							<div class="clearfix"></div>
						</div>
						<!---->
						<div class="col-md-6 product-filter-grid1-brands-col2"></div>
						<!---->
						<div class="product-filter-grid1-brands-col3"></div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
		</div>
		<!----details-product-slider--->
		<!-- Include the Etalage files -->
		<link rel="stylesheet" href="css/etalage.css">
		<script src="js/jquery.etalage.min.js"></script>
		<!-- Include the Etalage files -->
		<script>
			jQuery(document)
					.ready(
							function($) {

								$('#etalage')
										.etalage(
												{
													thumb_image_width : 300,
													thumb_image_height : 400,
													source_image_width : 900,
													source_image_height : 1000,
													show_hint : true,
													click_callback : function(
															image_anchor,
															instance_id) {
														alert('Callback example:\nYou clicked on an image with the anchor: "'
																+ image_anchor
																+ '"\n(in Etalage instance: "'
																+ instance_id
																+ '")');
													}
												});
								// This is for the dropdown list example:
								$('.dropdownlist').change(
										function() {
											etalage_show($(this).find(
													'option:selected').attr(
													'class'));
										});

							});
		</script>
		<!----//details-product-slider--->
		<div class="clearfix"></div>
		<!-- //products ---->
		<!----product-details--->
		<div class="product-details">
			<div class="container">
				<div class="product-details-row1-head">
					<c:forEach items="${listcate}" var="listcate">
						<h2>${listcate.getNamecategory()}</h2>
				</div>
				</c:forEach>
				<c:forEach items="${listsingle}" var="listsingle">
					<div class="product-details-row1">
						<div class="product-details-row1-head">
							<p>${listsingle.getName()}</p>
						</div>
						<div class="col-md-4 product-details-row1-col1">
							<div class="details-left">
								<div class="details-left-slider">
									<ul id="etalage">
										<li><img class="etalage_thumb_image"
											src="${listsingle.getUrl()}" /> <img
											class="etalage_source_image" src="${listsingle.getUrl()}" />
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-md-8 product-details-row1-col2">
							<div class="product-price">
								<div class="product-price-left text-right">
									<span>${listsingle.getUnitprice()}$</span>
									<h5>${listsingle.getPrice()}$</h5>
								</div>


								<div class="clearfix"></div>
							</div>
							<div class="product-price-details">

								<a class="shipping" href="#"><span> </span>Free shipping</a>
								<div class="clearfix"></div>
								<div class="product-size-qty">
									<form action="Cartservlet" method="post">
										<%
											List<Size> listsize = CartDao.getSize();
										%>
										<div class="pro-size">
											<span>Size:</span> <select name="Size">
												<%
													for (Size size : listsize) {
												%>
												<option value="<%=size.getSize()%>"><%=size.getSize()%></option>

												<%
													}
												%>
											</select>
										</div>

										<div class="pro-qty">

											<%
												List<Qty> listqty = CartDao.getQty();
											%>
											<span>Qty:</span> <select name="Qty">
												<%
													for (Qty qty : listqty) {
												%>
												<option value="<%=qty.getQty()%>"><%=qty.getQty()%></option>

												<%
													}
												%>

											</select>

										</div>

										<div class="clearfix"></div>
								</div>
								<div class="clearfix"></div>
								<div class="product-cart-share">

									<div id="add-cart-btn">

										<input type="hidden" name="product_id"
											value="<%=request.getParameter("productid")%>"> <input
											style="background: url(images/cart-icon.png) no-repeat 136px 13.5px #EF3326; border: 1px solid #B64E30; border-top: 2px solid #B64E30; color: #FFF; font-size: 1.2em; outline: none; padding: 0.42em 3em 0.5em 2em; border-radius: 0.3em; cursor: pointer; outline: none; transition: 0.5s all; -webkit-transition: 0.5s all; -moz-transition: 0.5s all; -o-transition: 0.5s all; -ms-transition: 0.5s all;"
											type="submit" value="Add to cart">
									</div>
									</form>
				</c:forEach>
				<ul class="product-share text-right">
					<h3>Share This:</h3>
					<ul>
						<li><a class="share-face" href="#"><span> </span> </a></li>
						<li><a class="share-twitter" href="#"><span> </span> </a></li>
						<li><a class="share-google" href="#"><span> </span> </a></li>
						<li><a class="share-rss" href="#"><span> </span> </a></li>
						<div class="clear"></div>
					</ul>
				</ul>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	<!--//product-details--->
	</div>
	<!---- product-details ---->
	<div class="product-tabs">
		<!--Horizontal Tab-->
		<div id="horizontalTab">
			<ul>
				<li><a href="#tab-1">Product overwiev</a></li>
				<li><a href="#tab-2">Features</a></li>
				<li><a href="#tab-3">Customer reviews</a></li>
			</ul>
			<div id="tab-1" class="product-complete-info">
				<h3>DESCRIPTION:</h3>
				<p>With its beautiful premium leather, lace-up oxford styling,
					recycled rubber outsoles and 9-inch height, this Earthkeepers City
					Premium style is an undeniably handsome boot. To complement its
					rustic, commanding outer appearance, we've paid attention to the
					inside as well - by adding SmartWoolÂ® faux shearling to the
					linings and crafting the footbed using our exclusive anti-fatigue
					comfort foam technology to absorb shock. Imported.</p>
				<span>DETAILS:</span>
				<div class="product-fea">
					<p>Premium burnished full-grain leather and suede upper</p>
					<p>Leather is from a tannery rated Silver for its water, energy
						and waste-management practices</p>
					<p>Leather lining and footbed for a premium feel and optimal
						comfort</p>
					<p>SmartWoolÂ® faux shearling lining is made with 60% merino
						wool and 40% PET</p>
					<p>Reflective insole board for additional warmth under foot</p>
					<p>100% organic cotton laces</p>
					<p>SmartWoolÂ® fabric-lined anti-fatigue footbed provides
						superior, all-day comfort and climate control</p>
					<p>TimberlandÂ® exclusive Gripstickâ„¢ and Green Rubberâ„¢
						outsole is made with 42% recycled rubber</p>
				</div>
			</div>
			<div id="tab-2" class="product-complete-info">
				<h3>DESCRIPTION:</h3>
				<p>With its beautiful premium leather, lace-up oxford styling,
					recycled rubber outsoles and 9-inch height, this Earthkeepers City
					Premium style is an undeniably handsome boot. To complement its
					rustic, commanding outer appearance, we've paid attention to the
					inside as well - by adding SmartWoolÂ® faux shearling to the
					linings and crafting the footbed using our exclusive anti-fatigue
					comfort foam technology to absorb shock. Imported.</p>
				<p>lace-up oxford styling, recycled rubber outsoles and 9-inch
					height, this Earthkeepers City Premium style is an undeniably
					handsome boot. To complement its rustic, commanding outer
					appearance,</p>
				<span>DETAILS:</span>
				<div class="product-fea">
					<p>Premium burnished full-grain leather and suede upper</p>
					<p>Leather is from a tannery rated Silver for its water, energy
						and waste-management practices</p>
					<p>Leather lining and footbed for a premium feel and optimal
						comfort</p>
					<p>SmartWoolÂ® faux shearling lining is made with 60% merino
						wool and 40% PET</p>
					<p>Reflective insole board for additional warmth under foot</p>
				</div>
			</div>
			<div id="tab-3" class="product-complete-info">
				<h3>DESCRIPTION:</h3>
				<p>With its beautiful premium leather, lace-up oxford styling,
					recycled rubber outsoles and 9-inch height, this Earthkeepers City
					Premium style is an undeniably handsome boot. To complement its
					rustic, commanding outer appearance, we've paid attention to the
					inside as well - by adding SmartWoolÂ® faux shearling to the
					linings and crafting the footbed using our exclusive anti-fatigue
					comfort foam technology to absorb shock. Imported.</p>
				<span>DETAILS:</span>
				<div class="product-fea">
					<p>100% organic cotton laces</p>
					<p>SmartWoolÂ® fabric-lined anti-fatigue footbed provides
						superior, all-day comfort and climate control</p>
					<p>TimberlandÂ® exclusive Gripstickâ„¢ and Green Rubberâ„¢
						outsole is made with 42% recycled rubber</p>
					<p>Premium burnished full-grain leather and suede upper</p>
					<p>Leather is from a tannery rated Silver for its water, energy
						and waste-management practices</p>
					<p>Leather lining and footbed for a premium feel and optimal
						comfort</p>
					<p>SmartWoolÂ® faux shearling lining is made with 60% merino
						wool and 40% PET</p>
					<p>Reflective insole board for additional warmth under foot</p>
					<p>100% organic cotton laces</p>
					<p>SmartWoolÂ® fabric-lined anti-fatigue footbed provides
						superior, all-day comfort and climate control</p>
					<p>TimberlandÂ® exclusive Gripstickâ„¢ and Green Rubberâ„¢
						outsole is made with 42% recycled rubber</p>
				</div>
			</div>
		</div>
		<!-- Responsive Tabs JS -->
		<script src="js/jquery.responsiveTabs.js" type="text/javascript"></script>

		<script type="text/javascript">
			$(document)
					.ready(
							function() {
								$('#horizontalTab')
										.responsiveTabs(
												{
													rotate : false,
													startCollapsed : 'accordion',
													collapsible : 'accordion',
													setHash : true,
													disabled : [ 3, 4 ],
													activate : function(e, tab) {
														$('.info')
																.html(
																		'Tab <strong>'
																				+ tab.id
																				+ '</strong> activated!');
													}
												});

								$('#start-rotation').on(
										'click',
										function() {
											$('#horizontalTab').responsiveTabs(
													'active');
										});
								$('#stop-rotation').on(
										'click',
										function() {
											$('#horizontalTab').responsiveTabs(
													'stopRotation');
										});
								$('#start-rotation').on(
										'click',
										function() {
											$('#horizontalTab').responsiveTabs(
													'active');
										});
								$('.select-tab').on(
										'click',
										function() {
											$('#horizontalTab').responsiveTabs(
													'activate', $(this).val());
										});

							});
		</script>
	</div>
	<!-- //product-details ---->
	</div>
	</div>
	<!----content---->
	<div class="clearfix"></div>
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

