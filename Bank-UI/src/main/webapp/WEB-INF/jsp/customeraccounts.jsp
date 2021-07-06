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
        <h1 class="text-light"><a href="/show-customerdashboard">${ customer.username }</a></h1>
        
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
      <button type="button" class="mobile-nav-toggle d-xl-none"><i class="icofont-navigation-menu"></i></button>

    </div>
  </header><!-- End Header -->

  <main id="main">

    <!-- ======= transactiondetails Section ======= -->
    <section id="transactiondetails" class="transactiondetails">
      <div class="container">

        <div class="section-title">
          <h2>Account Details</h2>
        </div>

		<div>
		<h3>${message}</h3>
		</div>

        
      
      <div>
          <table border="2" cellpadding="5" class="center" style="width: 900;">
						<tr >
							<th>ACCOUNT ID</th>
							<th>CUSTOMER ID</th>
							<th>OWNER NAME</th>
							<th>BALANCE</th>
							<th>ACCOUNT TYPE</th>
						</tr>
						<c:forEach items="${accList}" var="acc" >
						
						<tr>
							<td><c:out value="${acc.accountId}" /></td>
							<td><c:out value="${acc.customerId}" /></td>
							<td><c:out value="${acc.ownerName}" /></td>
							<td><c:out value="${acc.balance}" /></td>
							<td><c:out value="${acc.accountType}" /></td>
						</tr>
						
						</c:forEach>
					</table>
      </div>
      </div>
      
    </section><!-- End transaction details Section -->



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