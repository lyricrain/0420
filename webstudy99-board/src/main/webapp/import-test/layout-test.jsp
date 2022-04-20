<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>nav bar</title>
</head>
<body>
<%-- 
		Controller에서 request 영역에 url 을 할당한다고 가정 
 --%>
 <%
 		request.setAttribute("url", "c.jsp");
 %>
<div class="container-fluid pt-3">
<c:import url="header.jsp"></c:import>
<div class="row pt-3">
<div class="col-sm-6 offset-sm-3">
<c:import url="${requestScope.url}"></c:import>
  </div><%-- col div --%>
  </div><%-- row div --%>
</div><%-- container div --%>
</body>
</html>










