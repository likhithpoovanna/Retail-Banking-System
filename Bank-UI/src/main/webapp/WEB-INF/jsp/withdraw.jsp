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
  

</head>

<body>

  <!-- ======= Mobile nav toggle button ======= -->
  <button type="button" class="mobile-nav-toggle d-xl-none"><i class="icofont-navigation-menu"></i></button>

  <!-- ======= Header ======= -->
  <header id="header">
    <div class="d-flex flex-column">

      <div class="profile">
        <img src="/img/dummy.jpg" alt="" class="img-fluid rounded-circle">
        <h1 class="text-light"><a href="show-customerdashboard">${ customer.username }</a></h1>
        
      </div>

      <nav class="nav-menu">
        <ul>
          <li class="active"><a href="/show-customerdashboard"> <span>Home</span></a></li>
          <li><a href="/show-accounts"> <span>My Accounts</span></a></li>
          <li><a href="/show-deposit"> <span>Deposit</span></a></li>
          <li><a href="/show-withdraw"> <span>Withdrawal</span></a></li>
          <li><a href="/show-transfer"><span>Transfer</span></a></li>
          <li><a href="/show-transactionaldetails"><span>Transactional Details</span></a></li>
          <li><a href="/" class="btn-success"> Logout</a></li>
        </ul>
      </nav><!-- .nav-menu -->
      <button accesskey="s" type="button" class="mobile-nav-toggle d-xl-none"><i class="icofont-navigation-menu"></i></button>

    </div>
  </header><!-- End Header -->

 

  <main id="main">

    
    <!-- ======= withdraw Section ======= -->
    <section id="withdraw" class="withdraw">
      <div class="container">

        <div class="section-title">
          <h2>Withdrawal</h2>
        </div>
        
        <div>
		<h3>${message}</h3>
		</div>

        <div class="row">
          <div class="col-lg-6" data-aos="fade-up">
            <form:form action="/withdraw" method="POST" modelAttribute="accountInfo" >
                 <label>Enter Customer Account Id:</label>
                  <form:input path="accountId" type="text" name="accountId" class="form-control" id="accountId" />
                  <form:errors path="accountId" class="text-danger"/>
            <br>
                <label for="name">Enter Amount:</label>
                  <form:input path="balance" type="text" name="balance" class="form-control" id="balance" />
                  <form:errors path="balance" class="text-danger"/>
            <br>
                  <br>
                
                  <button accesskey="w" type="submit"><u>W</u>ithdraw</button>
        		</form:form>
          </div>
        </div>

      </div>
    </section><!-- End withdraw Section -->


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