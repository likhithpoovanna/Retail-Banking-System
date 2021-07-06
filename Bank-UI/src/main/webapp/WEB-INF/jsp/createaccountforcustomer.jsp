

<%@page import="java.net.http.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
      <link rel="stylesheet" href="/css/style.css">
  

  <title>ADFC Bank Portal.</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">



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

 

  <main id="main">

    

    
    <!-- ======= Create Account for Customer Section ======= -->
    <section id="createaccountforcustomer" class="createaccountforcustomer">
      <div class="container">

        <div class="section-title">
          <h2>Create Account For Customer</h2>
        </div>
        
        <div>
		<h3>${message}</h3>
		</div>

        <div class="row">
        <form:form action="/createAccount" modelAttribute="account">
          	
          	<div class="col-lg-6" data-aos="fade-up">
          
            <label>Enter the Customer Id:</label>
                   <form:input path="customerId" class="form-control" type="text"/>
                   <form:errors path="customerId" class="text-danger"/>
            <br>
                <label>Enter the Owner Name:</label>
                  <form:input path="ownerName" class="form-control" type="text"/>
                  <form:errors path="ownerName" class="text-danger"/>
            <br>
                  
                  
                 
          </div>
          <div class="col-lg-6" data-aos="fade-up" data-aos-delay="100">
 						
            <label>Select the Account Type</label>
              <form:select path="accountType" >
							<form:option value="Savings">Savings</form:option>
							<form:option value="Current">Current</form:option>
							<form:errors path="accountType" class="text-danger"/>
               </form:select>
			  <br>
			  
            <label>Enter the Balance:</label>
              <form:input path="balance" class="form-control" type="text"/>
              <form:errors path="balance" class="text-danger"/>
            <br>
           
               <button accesskey="s" type="submit"><u>S</u>ubmit</button>
               
          </div>
          
          </form:form>
          
        </div>

      </div>
    </section><!-- End Create Account For Customer Section -->

   
  </main><!-- End #main -->

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