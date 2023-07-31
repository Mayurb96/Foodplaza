<%@page import="com.pojo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bill</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form class="main">
<%Order od=(Order)request.getAttribute("order"); %>
OrderId:<%=od.getOrderId() %><br>
EmailId:<%=od.getEmailId() %><br>
TotalPrice:<%=od.getTotalprice() %><br>
Date:<%=od.getOdate() %>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>