<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Web Advertising</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<script src="js/jquery.min.js"></script>
		<script src="js/init.js"></script>
			<link href="css/default.min.css" rel="stylesheet">
			<link href="css/dataTable.css" rel="stylesheet">
			<link href="css/dataTables_jui.css" rel="stylesheet">
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
	<center>
 			<img src="images/load.gif" id="loading" alt=" " style="display: block;height: 50%;width: 5%;"></center>
			<div id="main" style="display:none;">

		<section id="top" class="one dark cover">
			<div class="container">
				<h3>Report Generation</h3>
					<table id="initial" class="table display" cellspacing="0" width="100%" style="width: 100% !important;">
	                    <thead>
	                        <tr id="transcripts_list_header" >
	                            <th>MatchedData</th>
	                        </tr>
	                    </thead>
	                	<tbody id="dataIns">  </tbody>		
					</table><br><br>
					<table id="datastables" class="table display" cellspacing="0" width="100%" style="width: 100% !important;">
	                    <thead>
	                        <tr id="transcripts_list_header" >
	                              <th>UnMatchedData</th>
	                        </tr>
	                    </thead>
	                	<tbody id="dataIns">  </tbody>		
					</table>
					
			</div>
		</section>
			</div>

 <script src="js/scripts.min.js"></script>
    <script type="text/javascript" src="js/jquery.dataTables.min.js" ></script>
    <script src="js/reports.js"></script>
	</body>
</html>