

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
        <h1 class="text-light"><a href="index.html">${ customer.username }</a></h1>
        
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

    <!-- ======= createcustomer Section ======= -->
    <section id="createcustomer" class="createcustomer">
      <div class="container">

        <div class="section-title">
          <h2>Create Customer</h2>
        </div>

		<div>
		<h3>${message}</h3>
		</div>


        <div class="row">
         
          <div class="col-lg-12 content" data-aos="fade-left">
            <h3>Enter the following Customer Details</h3>
           
            <div class="row">
               <form:form action="/createCustomer" modelAttribute="customer">
          	
          	<div class="col-lg-6" data-aos="fade-up">
          	
            <label>Enter the userid:</label>
                   <form:input path="userid" class="form-control" type="text"/>
                   <form:errors path="userid" class="text-danger"/>
                   <br>
                <label>Enter the username:</label>
                  <form:input path="username" class="form-control" type="text"/>
                  <form:errors path="username" class="text-danger"/>
                  <br>
                <label>Enter the password:</label>
                  <form:input path="password" class="form-control" type="text"/>
                  <form:errors path="password" class="text-danger"/>
                  <br>
                  
                 
          </div>
          <div class="col-lg-6" data-aos="fade-up" >
            <label>Enter the Date Of Birth:</label>
			<%-- <fmt:formatDate value="${customer.dateOfBirth}" var="dateString" /> 
			<fmt:formatDate value="${parsedDate}" var="dateString" /> 
						<form:input path="dateOfBirth" value="${dateString}" /><br /> --%>
            <form:input  id="dateOfBirth" path="dateOfBirth" placeholder="dd/MM/yyyy" />
            <br>
            
            <%-- <fmt:parseDate value="${customer.dateOfBirth}" pattern="dd-MM-yyyy" var="parsedDate" type="date" />
            <form:input path="dateOfBirth" value="${parsedDate}" /><br /> --%>
            
            <form:errors path="dateOfBirth" class="text-danger"/>
            <br>
      

 						
            <label>Enter the PanCard Number:</label>
              <form:input path="pan_no" class="form-control" type="text"/>
              <form:errors path="pan_no" class="text-danger"/>
            <br>
            <label>Enter the address:</label>
              <form:input path="address" class="form-control" type="text"/>
              <form:errors path="address" class="text-danger"/>
            <br>
              <br>
              
               <button accesskey="s" type="submit"><u>S</u>ubmit</button>
               
          </div>
          
          </form:form>
          
            </div>
            
          </div>
        </div>

      </div>
    </section><!-- End Create Customer Section -->

    
   

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