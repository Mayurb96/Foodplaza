<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
   <div id="templatemo_container">
		<div id="templatemo_header">
			<div id="site_title"></div>
		</div>
		<!-- end of header -->
<%String uEmail=(String)session.getAttribute("uEmail"); 
  String aEmail=(String)session.getAttribute("aEmail");%>		

		<div id="templatemo_menu">
			<ul>
			  <%if(uEmail==null && aEmail==null){ %>
				<li class="current"></li>
				<li><a href="index.jsp"><b>Home</b></a></li>
				<li><a href="food"><b>FoodList</b></a></li>
				<li><a href="Login.jsp"><b>Login</b></a></li>
				<li><a href="AddCustomer.jsp"><b>Register Customer</b></a></li>
				<li><a href="ContactUs.jsp"><b>ContactUs</b></a></li>
				<%} %>
				
				<%if(uEmail==null && aEmail!=null){ %>
				<li><a href="AddFood.jsp"><b>Add Food</b></a></li>
				<li><a href="food"><b>FoodList</b></a></li>
				<li><a href="customer"><b>CustomerList</b></a></li>
				<li><a href="feedback"><b>FeedbackList</b></a></li>
				<li><a href="ChangePassword.jsp"><b>Change Password</b></a></li>
				<li><a href="login"><b>Logout</b></a></li>
				<%} %>
				
				<%if(uEmail!=null && aEmail==null){ %>
				<li><a href="food"><b>FoodList</b></a></li>
				<li><a href="cart"><b>CartList</b></a></li>
				<li><a href="AddFeedback.jsp"><b>Add Feedback</b></a></li>
				<li><a href="ChangePassword.jsp"><b>Change Password</b></a></li>
				<li><a href="UpdateCustomer.jsp?emailId=<%=uEmail%>"><b>Edit Profile</b></a></li>
				<li><a href="login"><b>Logout</b></a></li>
				<%} %>
			</ul>
		</div>
</body>
</html>