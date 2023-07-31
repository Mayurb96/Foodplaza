<%@page import="java.util.Iterator"%>
<%@ page import="java.util.List" %>
<%@ page import="com.pojo.FeedBack" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<%List<FeedBack>l=(List)session.getAttribute("fdlist"); %>
<form class="main">
<table border="2">
  <caption><h1>Feedbacklist</h1></caption>
  
  <tr>
   <th>Name</th>
   <th>EmailId</th>
   <th>Review</th>
   <th>Rank</th>
   <th>Suggestion</th>
   </tr>
   
   <%Iterator<FeedBack>itr=l.iterator();
       while(itr.hasNext()){
       FeedBack fd=itr.next(); %>
   
       <tr>
        <td><%=fd.getName() %></td>
        <td><%=fd.getEmailId() %></td>
        <td><%=fd.getReview() %></td>
        <td><%=fd.getRank() %></td>
        <td><%=fd.getSuggestion() %></td>
        </tr>
        <%} %>
    
</table>
 </form> 
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>