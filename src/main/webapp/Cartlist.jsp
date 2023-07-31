<%@page import="java.util.Iterator"%>
<%@ page import="java.util.List" %>
<%@ page import="com.pojo.Cart" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cartlist</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<%List<Cart>l=(List)session.getAttribute("clist"); %>
<form  action="placeorder" method="post" class="main">
<table border="2">
  <caption><h1>Cartlist</h1></caption>
  
  <tr>
   <th>CartId</th>
   <th>FoodId</th>
   <th>EmailId</th>
   <th>FooName</th>
   <th>Quantity</th>
   <th>Price</th>
   <th>TotalPrice</th>
   <th colspan="2">Action</th>
   </tr>
   
   <%Iterator<Cart>itr=l.iterator();
       while(itr.hasNext()){
       Cart c=itr.next(); %>
   
       <tr>
        <td><%=c.getCartId()%></td>
        <td><%=c.getFoodId()%></td>
        <td><%=c.getEmailId()%></td>
        <td><%=c.getfName()%></td>
        <td><%=c.getFquantity()%></td>
        <td><%=c.getPrice()%></td>
        <td><%=c.getTotalprice()%></td>
        <td><a href="cart?action=delete&cartId=<%=c.getCartId() %>">Delete</a></td>
        </tr>
        <%} %>
    
</table>
  <input type="submit" value="placeOrder">
  </form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>