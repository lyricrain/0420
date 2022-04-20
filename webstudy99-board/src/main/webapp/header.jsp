<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%--   
		layout.jsp에서 import 하는 상단부 영역 
		비로그인시에는 로그인 폼을 제공하고 
		로그인시에는 홈 , 글쓰기 , 누구님 , 로그아웃 을 제공 
 --%>
 <c:choose>
 	<c:when test="${sessionScope.mvo==null}">
 	 <form method="post" action="LoginController.do">
 	<input type="text" name="id" placeholder="아이디" size="12">
 	<input type="password" name="password" placeholder="비밀번호" size="12">
 	<button type="submit">로그인</button>
    </form>
 	</c:when>
 	<c:otherwise>
 	<a href="ListController.do">홈</a>&nbsp;&nbsp; 	
 	<a href="WritePostFormController.do">글쓰기</a>&nbsp;&nbsp;
 	${sessionScope.mvo.name}님&nbsp;&nbsp;
 	<script>
 		function logout(){
 			let result=confirm("로그아웃하시겠습니까?");
 			if(result){
 			document.getElementById("logoutForm").submit();
 			}
 		}
 	</script> 	
 	<a href="javascript:logout()">로그아웃</a>&nbsp;&nbsp;
 	<form action="LogoutController.do" method="post" id="logoutForm"></form>
 	</c:otherwise>
 </c:choose>

 
 
 
 
 
 
 
 
 
 
 
 
 
 