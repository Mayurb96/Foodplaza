<%@page import="com.DaoImp.FoodDaoImp"%>
<%@page import="com.pojo.Food"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddToCart</title>
<script type="text/javascript" src="Validation.js"></script>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function total(){
	quan=document.getElementById('quan').value;
	price=document.getElementById('price').value;
	total=price*quan;
	document.getElementById('tprice').value=total;
}

</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<% FoodDaoImp fd=new FoodDaoImp();
  int foodId=Integer.parseInt(request.getParameter("foodId"));
  Food f=fd.searchFoodById(foodId);
  String emailId=(String)session.getAttribute("uEmail");%>
  
<form action="cart" method="post" onsubmit="AddCartValidation()" class="main">

<table border="2">
 <caption>AddToCart</caption>

    <tr>
   <td>Existing FoodId:</td>
   <td><input type="number" name="fid" id="fid" value="<%=f.getFoodId() %>"></td>
   <td><span id="fiderror" style="color: red"></span></td> 
   </tr>
   
   <tr>
   <td>EmailId:</td>
   <td><input type="email" name="email" id="email" value="<%=emailId %>"></td>
   <td><span id="emailerror" style="color: red"></span></td> 
   </tr>
    
    
   <tr>
   <td>FoodName:</td>
   <td><input type="text" name="fname" id="fname" value="<%=f.getfName() %>"></td>
   <td><span id="fnameerror" style="color: red"></span></td> 
   </tr>
    
    <tr>
   <td>Quantity:</td>
   <td><input type="number" name="quan" id="quan"></td>
   <td><span id="quanerror" style="color: red"></span></td> 
   </tr>
   
   <tr>
   <td>Price:</td>
   <td><input type="number" name="price" id="price" value="<%=f.getPrice() %>"></td>
   <td><span id="priceerror" style="color: red"></span></td> 
   </tr>
   
   <tr>
   <td>TotalPrice:</td>
   <td><input type="number" name="tprice" id="tprice" onclick="total()"></td>
   <td><span id="tpriceerror" style="color: red"></span></td> 
   </tr>
   
</table>

<input type="submit" value="AddToCart" name="action">
 <input type="reset" value="Clear">

</form>
<jsp:include page="Footer.jsp"></jsp:include>


</body>
</html>