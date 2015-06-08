<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
								<h2>Extracted PDF</h2>
							</header>
							 
									<div class="row half">
											<div class="6u" style=" margin-left: 24%; font-size: 12px!important; margin-top: -20%!important; line-height: 1.5em;!important;text-align: justify;">
    											<iframe id="processor" src="/index.jsp" style="visibility:hidden"></iframe>
    												<div id="output" class="formy"></div>
  											</div>
  
  											<div class="6u" style=" margin-left: 24%;">
    											<iframe id="input" src="../example/2.pdf"></iframe> 
  											</div>
									</div>
						</div>
					</section>
						<section id="portfolio" class="two classtwo" >
							<div class="container">
									<header>
										<h2>Extract Keywords</h2>
									</header>
									<div class="row half">
										<div class="6u" style=" margin-left: 24%">
											<div class="6u" style=" margin-left: 24%;">
												<input type="text" class="inputclass" id="filenum" placeholder="File Number">
											</div>
												<footer>
													<a id="proceeding" class="button scrolly">Extract Keywords</a> 
												</footer>
												<footer>
													<a id="comparefiles" class="button scrolly">Compare Files</a> 
												</footer>
										</div>
											<h2 id="h2header" style="display:none">THE FILTERED EXTRACTED KEYWORD FROM PDF 2 : </h2>
										<div class="6u" id="store" style=" margin-left: 24%; font-size: 12px!important; line-height: 1.5em;!important;text-align: justify;">
										</div>
									</div>
							</div>
						</section>
<script>
  var input = document.getElementById("input");
  var processor = document.getElementById("processor");
  var output = document.getElementById("output");
  
  window.addEventListener("message", function(event){
    if (event.source != processor.contentWindow) return;
    
    switch (event.data){
      case "ready":
        var xhr = new XMLHttpRequest;
        xhr.open('GET', input.getAttribute("src"), true);
        xhr.responseType = "arraybuffer";

        xhr.onload = function(event) {
          processor.contentWindow.postMessage(this.response, "*");
        };
        xhr.send();
      break;
      
      default:
        output.textContent = event.data.replace(/\s+/g, " ");
      break;
    }
  }, true);
  </script>
  <script src="js/first-pdf.js"></script>
	</body>
</html>