<%@page import="java.util.Iterator"%>
<%@ page import="java.util.List" %>
<%@ page import="com.pojo.Food" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Foodlist</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<%String uEmail=(String)session.getAttribute("uEmail");
  String aEmail=(String)session.getAttribute("aEmail");

List<Food>l=(List)session.getAttribute("flist"); %>
<form class="main">
<table border="2">
   <caption><h1>FoodList</h1></caption>
   
   <tr>
   <th>FoodId</th>
   <th>FoodName</th>
   <th>FoodType</th>
   <th>Quantity</th>
   <th>Price</th>
   <%if(uEmail==null && aEmail!=null){ %>
   <th colspan="2">Action</th>
   <%} %>
    <%if(uEmail!=null && aEmail==null){ %>
   <th colspan="1">Action</th>
   <%} %>
   </tr>
   
   <%Iterator<Food>itr=l.iterator();
       while(itr.hasNext()){
       Food f=itr.next();%>
       
       <tr>
       <td><%= f.getFoodId()%></td>
        <td><%=f.getfName() %></td>
         <td><%=f.getfType() %></td>
          <td><%=f.getfQuantity() %></td>
           <td><%=f.getPrice() %></td>
           <%if(uEmail==null && aEmail!=null){ %>
         <td><a href="UpdateFood.jsp?foodId=<%=f.getFoodId() %>">Edit</a></td>
         <td><a href="food?action=delete&foodId=<%=f.getFoodId() %>">Delete</a></td>
          <%} %>
           <%if(uEmail!=null && aEmail==null){ %>
            <td><a href="AddToCart.jsp?foodId=<%=f.getFoodId() %>">Add</a></td>
          <%} %>
          </tr>
          <%} %> 
</table>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>