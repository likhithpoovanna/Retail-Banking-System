<%@page import="java.net.http.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <link rel="stylesheet" href="/css/style.css">
  

  <title>ADFC Bank Portal.</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

   <!-- Template Main CSS File -
	
	

</head>

<body>

  <!-- ======= Mobile nav toggle button ======= -->
  <button type="button" class="mobile-nav-toggle d-xl-none"><i class="icofont-navigation-menu"></i></button>

  <!-- ======= Header ======= -->
  <header id="header">
    <div class="d-flex flex-column">

      <div class="profile">
        <img src="/img/dummy.jpg" alt="" class="img-fluid rounded-circle">
        <h1 class="text-light"><a href="/show-employeedashboard">${ customer.username }</a></h1>
        
      </div>

      <nav class="nav-menu">
        <ul>
          <li class="active"><a href="/show-employeedashboard"> <span>Home</span></a></li>
          <li><a href="/show-createcustomer"><span>Create Customer</span></a></li>
          <li><a href="/show-createaccountforcustomer"> <span>Create Account for Customer</span></a></li>
          <li><a href="/show-deletecustomer"> Delete Customer</a></li>
          <li><a href="/show-viewthecustomer"> View the Customer</a></li>
          <li><a href="/show-servicechargededuction"> Service Charge Deduction</a></li>
          <li><a href="/" class="btn-success"> Logout</a></li>
        </ul>
      </nav><!-- .nav-menu -->
      <button type="button" class="mobile-nav-toggle d-xl-none"><i class="icofont-navigation-menu"></i></button>

    </div>
  </header><!-- End Header -->
  
  <!-- ======= Hero Section ======= -->
  <section id="hero" class="d-flex flex-column justify-content-center align-items-center">
    <div class="hero-container" data-aos="fade-in">
      <h1 style="color:blue;">Hi, ${ customer.username }.</h1>
    </div>
  </section><!-- End Hero -->


  <!-- ======= Footer ======= -->
  <footer id="footer">
    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong><span>ADFC Bank Portal</span></strong>
      </div>
      <div class="credits">
       
        Designed by <a href="https://bootstrapmade.com/">POD-4</a>
      </div>
    </div>
  </footer><!-- End  Footer -->

  <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>


</body>

</html>