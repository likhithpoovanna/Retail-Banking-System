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

  <title>ADFC Bank Portal.</title>tle>
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
      <button accesskey="s" type="button" class="mobile-nav-toggle d-xl-none"><i class="icofont-navigation-menu"></i></button>

    </div>
  </header><!-- End Header -->

 

  <main id="main">

   
   

    <!-- ======= View The Customer Section ======= -->
    <section id="viewthecustomer" class="viewthecustomer">
      <div class="container">

        <div class="section-title">
          <h2>View The Customer Details</h2>
          <div>
		<h3>${message}</h3>
		</div>
          <form action="/viewthecustomer" method="GET" >
            <label>customerId</label>
            <input type="text" name="customerId" id="customerId" class="form-control" />
                  <br>
                  <button accesskey="v" type="submit"><u>V</u>iew</button>
           </form>
           <c:choose>
           <c:when test="${show}">
          <table border="2" cellpadding="5" class="center" style="width: 900;">
						<tr >
							<th>CUSTOMER ID</th>
							<th>CUSTOMER NAME</th>
							<th>DOB</th>
							<th>PAN</th>
							<th>ADDRESS</th>
						</tr>
						<tr>
							<td><c:out value="${customer.userid}" /></td>
							<td><c:out value="${customer.username}" /></td>
							<td><c:out value="${customer.dateOfBirth}" /></td>
							<td><c:out value="${customer.pan_no}" /></td>
							<td><c:out value="${customer.address}" /></td>
						</tr>
					</table>
					</c:when>
					
           </c:choose>
        </div>



        

      </div>
    </section><!-- End View The Customer Section -->

    
   
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