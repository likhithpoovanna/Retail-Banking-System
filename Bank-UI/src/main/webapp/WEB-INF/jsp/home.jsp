

<%@page import="java.net.http.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>ADFC Home Page</title>
<style>
* {
	font-family: "Roboto", Arial, Helvetica, sans-serif;
}

/* nav start */
.nav_head {
	background-image: linear-gradient(to bottom left, rgb(207, 248, 207),
		#ffefcd, #fff1f9, rgb(206, 233, 252));
}

.fa-seedling {
	color: rgb(122, 238, 5);
}

.nav_head a, li, span {
	color: darkgreen;
}

.navbar-toggler.custom_toggler {
	border-color: rgb(103, 221, 67);
}

.custom_toggler .navbar-toggler-icon {
	background-image:
		url("data:image/svg+xml,<svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 30 30'><path stroke='rgba(0, 128, 0, 0.8)' stroke-linecap='round' stroke-miterlimit='10' stroke-width='2' d='M4 7h22M4 15h22M4 23h22'/></svg>");
}

/* nav end */

/* carousel */
.carousel-inner img {
	height: 700px;
}

.carousel-inner p {
	font-size: 15px;
}

.carousel-inner i {
	padding-right: 10px;
}

.mail-para, .mail-para>a {
	font-size: 12px;
	margin: 3px auto;
	text-decoration: none;
}

@media ( max-width : 768px) {
	.carousel-item>img {
		height: 300px;
		width: 100%;
	}
}

/* carousel end */

/* mid section */
.col_con1>img {
	float: left;
	width: 500px;
	height: 250px;
	margin-right: 20px;
}

.col_con2>img {
	float: right;
	width: 500px;
	height: 250px;
	margin-left: 20px;
}

.row_card2 {
	justify-content: end;
}

.col_con3>img {
	float: left;
	width: 500px;
	height: 250px;
	margin-right: 20px;
}

.col_con1, .col_con2, .col_con3 {
	margin: 10px auto 30px;
	padding: 10px;
	color: #5f6368;
	background-color: #f8f9fa;
}

h5 a {
	text-decoration: none;
	color: rgb(33, 37, 41);
}

.btn_gear {
	transition: .1s ease-in-out;
}

.btn_learn_more {
	transition: .1s ease-in-out;
}

.btn_signup {
	transition: .1s ease-in-out;
}

.btn_gear:hover {
	transform: scale(1.1);
}

.btn_learn_more:hover {
	transform: scale(1.1);
}

.btn_signup:hover {
	transform: scale(1.1);
}

@media ( max-width : 768px) {
	.col_con_body1 {
		clear: both;
		text-align: justify;
	}
	.col_con1 img {
		clear: both;
		margin-bottom: 10px;
	}
}

@media ( max-width : 768px) {
	.col_con_body2 {
		clear: both;
		text-align: justify;
	}
	.col_con2 img {
		clear: both;
		margin: auto auto 10px;
	}
	.row_card2 {
		justify-content: left;
	}
}

@media ( max-width : 768px) {
	.col_con_body3 {
		clear: both;
		text-align: justify;
	}
	.col_con3 img {
		clear: both;
		margin-bottom: 10px;
	}
}

/* end mid section */
.mail_col a:hover {
	color: darkgreen;
}

.span_sub {
	cursor: pointer;
}

.span_sub:hover {
	color: rgb(86, 142, 247);
}

.footer_row {
	background-color: #444;
	color: #fff;
}

.social_col {
	text-align: right;
}

.social_col i {
	padding-right: 10px;
}

.footer_col p {
	font-size: 12px;
}

.btn_learn_more, .btn_gear, .btn_signup {
	border: 1px solid #0d6efd;
}

.btn_learn_more:hover, .btn_gear:hover, .btn_signup:hover {
	color: #0d6efd;
}

.fa-twitter:hover, .fa-facebook-square:hover {
	color: #1DA1F2;
	transform: scale(1.1);
	transition: all 1 .1s ease-in-out;
}

.fa-instagram:hover, .fa-youtube:hover {
	color: #FF0000;
	transform: scale(1.1);
	transition: all 1 .1s ease-in-out;
}

.fa-envelope:hover {
	color: rgb(255, 120, 9);
	transform: scale(1.1);
	transition: all 1 .1s ease-in-out;
}
</style>


<!-- bootstarp -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">

<script src="https://kit.fontawesome.com/d5b1e1074d.js"
	crossorigin="anonymous"></script>

<!-- css style -->
<link rel="stylesheet" href="./style.css">





</head>

<body>

	<!-- navbar start -->
	<section id="header">

		<nav class="nav_head navbar navbar-expand-lg">
			<div class="container-fluid nav_con">
				<a class="navbar-brand" href="#"><i class="fas fa-seedling"></i>
					ADFC Bank </a>
				<button class="navbar-toggler custom_toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarContent"
					aria-controls="navbarContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarContent">
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
						<!-- <li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Home</a></li> -->
						
						
						<!-- <li class="nav-item"><a class="nav-link" href="#">About us</a></li> -->
						<li class="nav-item"><a class="nav-link"
							href="/customerlogin">Customer Login</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/employeelogin">Employee Login</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</section>
	<!-- navbar end -->




	<!-- carousel -->
	<div class="carousel slide" id="carouselpic" data-bs-ride="carousel"
		data-bs-interval="4000" data-bs-hover="play">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselpic"
				data-bs-slide-to="0" class="active"></button>
			<button type="button" data-bs-target="#carouselpic"
				data-bs-slide-to="1"></button>
			<button type="button" data-bs-target="#carouselpic"
				data-bs-slide-to="2"></button>
			<button type="button" data-bs-target="#carouselpic"
				data-bs-slide-to="3"></button>
		</div>

		<div class="carousel-inner" id="car_inner">
			<div class="carousel-item active">
				<img
					src="https://images.unsplash.com/photo-1496449903678-68ddcb189a24?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"
					alt="landscape" class="d-block w-100 img-fluid">
				<div class="carousel-caption d-none d-md-block">

					<h4>
						<i class="fas fa-mountain"></i>Be the Beginning
					</h4>
					<p>Explore Landscapes with us</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="https://images.unsplash.com/photo-1616514197671-15d99ce7a6f8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=753&q=80" alt="Bird"
					class="d-block w-100 img-fluid">
				<div class="carousel-caption d-none d-md-block">

					<h4>
						<i class="fas fa-dove"></i> Do a safe Banking with us 
					</h4>
					<p>Wear mask and be safe</p>
				</div>
			</div>
			<div class="carousel-item">
				<img
					src="https://images.unsplash.com/photo-1616803140344-6682afb13cda?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"
					alt="macro" class="d-block w-100 img-fluid">
				<div class="carousel-caption d-none d-md-block">

					<h4>
						<i class="fas fa-tint"></i>A Secure way for transaction
					</h4>
					<p>We Respect your privacy</p>
				</div>
			</div>
			<div class="carousel-item">
				<img
					src="https://images.unsplash.com/photo-1601597111158-2fceff292cdc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"
					alt="portraits" class="d-block w-100">
				<div class="carousel-caption d-none d-md-block">

					<h4>
						<i class="fas fa-portrait"></i>24x7 Atm Service
					</h4>
					<p>Any Time Money</p>
				</div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselpic" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselpic" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
		</button>
	</div>

	<!-- section mid -->

	<div class="container-fluid mid_con">



		<div class="row row_card1">
			<div class="col-sm-12 col-md-12 col-lg-8 col_con2">
				<img class="img-fluid"
					src="https://images.unsplash.com/photo-1553729459-efe14ef6055d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"
					alt="workshop">
				<div class="col_con_body2">
					<h5>
						<a href="#">Saving Account</a>
					</h5>
					<P>A savings account is a bank account at a retail bank. Common features include a limited number of withdrawals, a lack of cheque and linked debit card facilities, limited transfer options, and the inability to be overdrawn.</P>
					
				</div>
			</div>
		</div>



		<div class="row row_card2">
			<div class="col-sm-12 col-md-12 col-lg-8 col_con3">
				<img
					src="https://images.unsplash.com/photo-1607863680198-23d4b2565df0?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"
					alt="Photobook">
				<div class="col_con_body3">
					<h5>
						<a href="#">Current Account</a>
					</h5>
					<p>A Current Account is a bank deposit that can be withdrawn by the depositor at any time. The depositor is at liberty to operate this account any number of times in a day unlike Savings Accounts where only limited transactions are allowed.</p>
					
				</div>
			</div>
		</div>



		
	</div>
	<!-- end section -->

	<!-- footer -->
	<div class="container-fluid mt-5">
		<div class="row p-3 footer_row">
			<div class="col-6 footer_col">
				<p>Banking Application Develop by POD 4</p>
				
			</div>

			<div class="col-6 social_col">
				<i class="fas fa-lg fa-envelope"></i> <i
					class="fab fa-lg fa-youtube"></i> <i class="fab fa-lg fa-instagram"></i>
				<i class="fab fa-lg fa-twitter"></i> <i
					class="fab fa-lg fa-facebook-square"></i>
			</div>
		</div>
	</div>


	<!-- Footer end -->





</body>
</html>