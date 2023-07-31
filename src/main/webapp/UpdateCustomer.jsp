<%@page import="com.pojo.Customer"%>
<%@page import="com.DaoImp.CustomerDaoImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="Validation.js"></script>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<% CustomerDaoImp cd=new CustomerDaoImp();
   String emailId=request.getParameter("emailId");
   Customer c=cd.searchCustomerById(emailId);%>

<form action="customer" method="post" onsubmit="UpdateCustValidation()" class="main">

<table border="2">
  <caption>Update Customer</caption>
  
   <tr>
   <td>Name:</td>
   <td><input type="text" name="cname" id="cname" value="<%=c.getcName()%>"></td>
   <td><span id="cnameerror" style="color: red"></span></td> 
   </tr>
   
   <tr>
   <td>EmailId:</td>
   <td><input type="email" name="email" id="email" value="<%=c.getcEmailId()%>"></td>
   <td><span id="emailerror" style="color: red"></span></td> 
   </tr>
    
    <tr>
   <td>Password:</td>
   <td><input type="password" name="pass" id="pass" value="<%=c.getcPassword()%>"></td>
   <td><span id="passerror" style="color: red"></span></td> 
   </tr>
   
   <tr>
   <td>Address:</td>
   <td><input type="text" name="adr" id="adr" value="<%=c.getcAddress()%>"></td>
   <td><span id="adrerror" style="color: red"></span></td> 
   </tr>
   
   <tr>
   <td>ContactNo:</td>
   <td><input type="number" name="cNo" id="cNo" value="<%=c.getcContactNo()%>"></td>
   <td><span id="cNoerror" style="color: red"></span></td> 
   </tr>
   
 </table>

<input type="submit" value="UpdateCustomer" name="action">
 <input type="reset" value="Clear">

</form>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>