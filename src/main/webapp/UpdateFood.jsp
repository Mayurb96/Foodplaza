<%@page import="com.DaoImp.FoodDaoImp"%>
<%@page import="com.pojo.Food"%>
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

<% FoodDaoImp fd=new FoodDaoImp();
   int id=Integer.parseInt(request.getParameter("foodId"));
    Food f=fd.searchFoodById(id);%>
   
 <form action="food" method="post" onsubmit="UpdateFoodValidation()" class="main">
 <table border="2">
  <caption>Update Food</caption>
  
  <tr>
   <td>FoodID:</td>
   <td><input type="number" name="fid" id="fid" value="<%=f.getFoodId()%>"></td>
   <td><span id="fiderror" style="color: red"></span></td> 
   </tr>
    
  <tr>
   <td>FoodName:</td>
   <td><input type="text" name="fname" id="fname" value="<%=f.getfName()%>"></td>
   <td><span id="fnameerror" style="color: red"></span></td> 
   </tr>
    
    <tr>
   <td>FoodType:</td>
   <td><input type="text" name="ftype" id="ftype" value="<%=f.getfType()%>"></td>
   <td><span id="ftypeerror" style="color: red"></span></td> 
   </tr>
   
    <tr>
   <td>Quantity:</td>
   <td><input type="number" name="fquan" id="fquan" value="<%=f.getfQuantity()%>"></td>
   <td><span id="fquanerror" style="color: red"></span></td> 
   </tr>
   
   <tr>
   <td>Price:</td>
   <td><input type="number" name="fprice" id="fprice" value="<%=f.getPrice()%>"></td>
   <td><span id="fpriceerror" style="color: red"></span></td> 
   </tr>
   
</table>

<input type="submit" value="UpdateFood" name="action">
 <input type="reset" value="Clear">

</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>