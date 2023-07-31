<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
<script type="text/javascript" src="Validation.js"></script>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
  <form action="login" method="post"  onsubmit="ChangePassValidation()" class="main">
 <table border="2">
   <caption>Change Password</caption>
   
   <tr>
   <td>Select</td>
   <td><select name="type" id="type">
       <option>select</option>
       <option value="admin">Admin</option>
       <option value="user">User</option>
       </select> </td>
    <td><span id="selecterror" style="color: red"></span></td> 
   </tr>  
   
   <tr>
   <td>EmailId:</td>
   <td><input type="email" name="email" id="email"></td>
   <td><span id="emailerror" style="color: red"></span></td> 
   </tr>
    
    <tr>
   <td>Old Password:</td>
   <td><input type="password" name="pass" id="pass"></td>
   <td><span id="passerror" style="color: red"></span></td> 
   </tr>
   
   <tr>
   <td>New Password:</td>
   <td><input type="password" name="npass" id="npass"></td>
   <td><span id="npasserror" style="color: red"></span></td> 
   </tr>
   
   <tr>
   <td>Confirm Password:</td>
   <td><input type="password" name="cpass" id="cpass"></td>
   <td><span id="cpasserror" style="color: red"></span></td> 
   </tr>
 
 </table>
 
  <input type="submit" value="Changepass" name="action">
  <input type="reset" value="Clear">
  
 </form>
 <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>