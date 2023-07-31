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
<form action="food" method="post" onsubmit="AddFoodValidation()"  class="main">

<table border="2">
 <caption>Add Food</caption>

   <tr>
   <td>FoodName:</td>
   <td><input type="text" name="fname" id="fname"></td>
   <td><span id="fnameerror" style="color: red"></span></td> 
   </tr>
    
    <tr>
   <td>FoodType:</td>
   <td><input type="text" name="ftype" id="ftype"></td>
   <td><span id="ftypeerror" style="color: red"></span></td> 
   </tr>
   
    <tr>
   <td>Quantity:</td>
   <td><input type="number" name="fquan" id="fquan"></td>
   <td><span id="fquanerror" style="color: red"></span></td> 
   </tr>
   
   <tr>
   <td>Price:</td>
   <td><input type="number" name="fprice" id="fprice"></td>
   <td><span id="fpriceerror" style="color: red"></span></td> 
   </tr>
   
</table>

<input type="submit" value="AddFood" name="action">
 <input type="reset" value="Clear">

</form>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>