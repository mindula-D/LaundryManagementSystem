<!DOCTYPE html>

<html>
<head>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<meta charset="ISO-8859-1">

<link href="CSS/payment/css/main.css" rel="stylesheet" type="text/css">
<link href="CSS/payment/css/util.css" rel="stylesheet" type="text/css">
<link href="CSS/payment/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="CSS/payment/fonts/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="CSS/payment/vendor/animate/animate.css" rel="stylesheet" type="text/css">
<link href="CSS/payment/vendor/select2/select2.min.css" rel="stylesheet" type="text/css">
<link href="CSS/payment/vendor/perfect-scrollbar/perfect-scrollbar.css" type="text/css">

<title>Machines Management</title>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.lms.model.Machines,com.lms.service.*,com.lms.util.*,java.util.*" %>
	
	

	
<div class="limiter">
<div class="container-table100">
<div class="wrap-table100">
<div class="table100">
<h1>Machines List</h1>
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
  							
  		<a href="AddMachine.jsp" style="border-radius: 5px;  
  							padding: 5px 10px; 
  							font-size: 22px;  
  							text-decoration: none;  
  							margin: 20px;  
  							color: #fff;  
  							position: relative;  
  							display: inline-block;
  							background-color: #9b59b6;
  							box-shadow: 0px 5px 0px 0px #82409D;" >ADD NEW Machine</a>
</div>
	<table>
		<thead>
			<tr class="table100-head">
				<th>Machine ID</th>
				<th>Machine Brand</th>
				<th>Condition</th>
				<th>Slot Number</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
			<tbody>
			
				<%
					IMachineService imachine = new MachineServiceImpl();
					ArrayList<Machines> listMachines = imachine.listallMachines();
					
					for(Machines machine : listMachines) {
					
				%>
			
				
				<tr>
					<td><c:out value="<%=machine.getMachineID() %>" /></td>
					<td><c:out value="<%=machine.getMachineBrand() %>" /></td>
					<td><c:out value="<%=machine.getCondition() %>" /></td>
					<td><c:out value="<%=machine.getSlotNo() %>" /></td>
					<td><a href= "ViewMachines?MachineID=<%=machine.getMachineID() %>" >View</a></td>
					<td><a href= "EditMachine?MachineID=<%=machine.getMachineID() %>" >Edit</a></td>
					<td><a href= "DeleteMachine?MachineID=<%=machine.getMachineID() %>" >Delete</a></td>
				</tr>
			</tbody>
								
				<%
					}
				%>
		
	</table>
	</div>
</div>
</div>
</div>
</body>
</html>