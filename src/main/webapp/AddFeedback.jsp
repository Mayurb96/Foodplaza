<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Feedback</title>
<script type="text/javascript" src="Validation.js"></script>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form action="feedback" method="post" onsubmit="AddFeedValidation()" class="main">
 <table border="2">
   <caption><h1>Add FeedBack</h1></caption>
 
   <tr>
   <td>Name:</td>
   <td><input type="text" name="cname" id="cname"></td>
   <td><span id="cnameerror" style="color: red"></span></td> 
   </tr>
   
   <tr>
   <td>EmailId:</td>
   <td><input type="email" name="email" id="email"></td>
   <td><span id="emailerror" style="color: red"></span></td> 
   </tr>
    
   <tr>
   <td>Review:</td>
   <td><input type="text" name="review" id="review"></td>
   <td><span id="reviewerror" style="color: red"></span></td> 
   </tr>
   
   <tr>
   <td>Ranking:</td>
   <td><input type="number" name="rank" id="rank"></td>
   <td><span id="rankerror" style="color: red"></span></td> 
   </tr>
   
   <tr>
   <td>Suggestion:</td>
   <td><input type="text" name="sug" id="sug"></td>
   <td><span id="sugerror" style="color: red"></span></td> 
   </tr>  
 
 </table>
 <input type="submit" name="action" value="AddFeedBack">
 <input type="reset" value="Clear">
 </form>
 <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>