<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<%@page import="com.google.appengine.api.blobstore.BlobstoreService"%>
<%@page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PDF Conversion</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="js/jquery.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<script src="js/cookie.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-wide.css" />
		</noscript>
	</head>
	<body>

			<div id="main">

					<section id="portfolio" class="two" style="margin-left: -26%;">
						<div class="container">
					
							<header>
								<h2>User Authentication</h2>
							</header>
							 
									<div class="row half" style="margin-left: 19%; width: 127%;">
										<div id="signup" class="6u" style="display:none">
											<div class="6u" style=" margin-left: 24%;">
												<input type="text" class="inputclass" id="firstname" placeholder="Name">
											</div>
											<div class="6u" style=" margin-left: 24%;">
												<input type="text" class="inputclass" id="email" placeholder="email / userid">
											</div>
											<div class="6u" style=" margin-left: 24%;">
												<input type="text" class="inputclass" id="password" placeholder="password">
											</div>
											<div class="6u" style=" margin-left: 24%;">
												<input type="text" class="inputclass" id="phone" placeholder="phone">
											</div>
										</div>
										<div id="login" class="6u" style="display:block">
											<div class="6u" style=" margin-left: 24%;">
												<input type="text" class="inputclass"  id="userid" placeholder="User ID">
											</div>
											<div class="6u" style=" margin-left: 24%;">
												<input type="password" class="inputclass"  id="passwords" placeholder="Password">
											</div>
										</div>
									</div><br><br>
									<center><input type="button" id="logmein" class="button scrolly" value="Login" style="display:block"></center><br>
									<center><input type="button" id="statuss" class="button scrolly"  value="Not an Existing user ? Click Here" style="display:block"></center><br>
									<center><input type="button" id="signupup" class="button scrolly" value="Signup" style="margin-top: -9%; display:none"></center>
									<center><input type="button" id="already" class="button scrolly" value="Already an user? Click Here" style="display:none"></center>
									
						<br/>
						
			
			</div>
<script src="js/actions.js"></script>
	</body>
</html>