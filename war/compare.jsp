<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.*"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PDF CONVERSION</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.scrolly.min.js"></script>
		<script src="js/jquery.scrollzer.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<script src="js/actions.js"></script>
		<script src="js/cookie.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-wide.css" />
		</noscript>
		<%
		  if(session.getAttribute("pdf1")!=null)
		  {
			  String pdf1  = (String)session.getAttribute("pdf1");
			  System.out.println("pdf1 is this :: "+pdf1);
		  }
			String pdf1  = (String)session.getAttribute("pdf1");
			String pdf2  = (String)session.getAttribute("pdf2");
	 	 %> 
	 	 <script>
		  var toappend				=	'<%=pdf1%>';
		  var toappend2				=	'<%=pdf2%>';
	  </script>
	</head>
	<body>

			<div id="header" class="skel-layers-fixed">
				<div class="top">
						<div id="logo">
							<span class="image avatar48"><img src="images/avatar.jpg" alt="" /></span>
							<h1 id="title">PDF CONVERSION</h1>
						</div>
						<nav id="nav">
							<ul>
								<li><a href="/home.jsp" id="top-link" class="skel-layers-ignoreHref"><span class="icon fa-home">Upload File1</span></a></li>
								<li><a href="/home2.jsp" id="top-link" class="skel-layers-ignoreHref"><span class="icon fa-home">Upload File2</span></a></li>
								<li><a href="/compare.jsp" id="portfolio-link" class="skel-layers-ignoreHref"><span class="icon fa-th">Compare Files</span></a></li>
								<li><a href="/report.jsp" id="about-link" class="skel-layers-ignoreHref"><span class="icon fa-user">Generate Report</span></a></li>
							</ul>
						</nav>
						
				</div>
				
				<div class="bottom">

					<!-- Social Icons -->
						<ul class="icons">
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-github"><span class="label">Github</span></a></li>
							<li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
							<li><a href="#" class="icon fa-envelope"><span class="label">Email</span></a></li>
						</ul>
				</div>
			</div>
			<div id="main">
					<section id="top" class="one dark cover">
						<div class="container">

							<header>
								<h2 class="alt">Simillarity Extraction in PDF and  <strong>Keyword</strong> <a href="#">Matching</a><br />
							</header>
							
							<footer>
								<a href="#about" class="button scrolly">Upload File</a>
							</footer>

						</div>
					</section>
					
					<section id="portfolio" class="two">
						<div class="container">

							<header>
								<h2>Keyword Extracted from PDF1</h2>
							</header>

							<p id="mini"></p>


						</div>
					</section>
					<section id="portfolio" class="two">
						<div class="container">

							<header>
								<h2>Keyword Extracted from PDF2</h2>
							</header>

							<p id="mini2"></p>

						</div>
					</section>
					<script src="js/compare.js"></script>
	</body>
</html>