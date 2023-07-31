<%@page import="java.util.Iterator"%>
<%@ page import="java.util.List" %>
<%@ page import="com.pojo.Customer" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customerlist</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<%List<Customer>l=(List)session.getAttribute("cslist"); %>
<form calss="main">
<table border="2">
  <caption><h1>Customerlist</h1></caption>
  
  <tr>
   <th>Name</th>
   <th>EmailId</th>
   <th>Password</th>
   <th>Address</th>
   <th>ContactNo</th>
   <th colspan="2">Action</th>
   </tr>
   
   <%Iterator<Customer>itr=l.iterator();
       while(itr.hasNext()){
       Customer cs=itr.next(); %>
   
       <tr>
        <td><%=cs.getcName() %></td>
        <td><%=cs.getcEmailId() %></td>
        <td><%=cs.getcPassword() %></td>
        <td><%=cs.getcAddress() %></td>
        <td><%=cs.getcContactNo() %></td>
        <td><a href="UpdateCustomer.jsp?emailId=<%=cs.getcEmailId() %>">Edit</a></td>
        <td><a href="customer?action=delete&emailId=<%=cs.getcEmailId() %>">Delete</a></td>
        </tr>
        <%} %>
    
</table>
 </form> 
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>