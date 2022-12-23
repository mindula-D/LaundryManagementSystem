<%@ page language="java" 
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%@ page import="com.lms.model.Machines,
com.lms.service.*,
com.lms.util.*,
java.util.*" %>

<link href="CSS/payment/css/main.css" rel="stylesheet" type="text/css">
<link href="CSS/payment/css/util.css" rel="stylesheet" type="text/css">
<link href="CSS/payment/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="CSS/payment/fonts/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="CSS/payment/vendor/animate/animate.css" rel="stylesheet" type="text/css">
<link href="CSS/payment/vendor/select2/select2.min.css" rel="stylesheet" type="text/css">
<link href="CSS/payment/vendor/perfect-scrollbar/perfect-scrollbar.css" type="text/css">

<title>Machine Details</title>
</head>
<body>

<div class="limiter">
<div class="container-table100">
<div class="wrap-table100">
<div class="table100">
<h1 align="center">Machine Details</h1>
<div id="buttons">
  		<a href="admindashboard.jsp" style="border-radius: 5px;  
  							padding: 5px 10px; 
  							font-size: 22px;  
  							text-decoration: none;  
  							margin: 20px;  
  							color: #fff;  
  							position: relative;  
  							display: inline-block;
  							background-color: #9b59b6;
  							box-shadow: 0px 5px 0px 0px #82409D;" >DASHBOARD</a>
  							
  		<a href="MachinesList.jsp" style="border-radius: 5px;  
  							padding: 5px 10px; 
  							font-size: 22px;  
  							text-decoration: none;  
  							margin: 20px;  
  							color: #fff;  
  							position: relative;  
  							display: inline-block;
  							background-color: #9b59b6;
  							box-shadow: 0px 5px 0px 0px #82409D;" >MACHINE LIST</a>
</div>

<%
	Machines machine = (Machines) request.getAttribute("machine");
%>

	<table border="5" align="center">
	<thead>
	</thead>
	<tbody>
		<tr>
		<td>Machine ID</td>
		<td><%=machine.getMachineID() %></td>
		</tr>
		<tr>
		<td>Machine Brand</td>
		<td><%=machine.getMachineBrand() %></td>
		</tr>
		<tr>
		<td>Condition</td>
		<td><%=machine.getCondition() %></td>
		</tr>
		<tr>
		<td>Slot Number</td>
		<td><%=machine.getSlotNo() %></td>
		</tr>
	</tbody>	
	</table>
</div>
</div>
</div>
</div>
</body>
</html>