<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%-- layout.jsp에서 jstl import 하는 대상 jsp 이므로 html 선언부 등을 생략하고 자신의 컨텐트만 명시해야 한다  --%>
<table class="table table-bordered table-hover boardlist">
	<thead>
		<tr style="background-color: #d6f5d6">
			<th>번호</th><th class="title">제목</th><th>작성자</th><th>작성일</th><th>조회</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="pvo">
		<tr>
			<td>${pvo.no}</td><td>${pvo.title}</td><td>${pvo.memberVO.name}</td><td>${pvo.timePosted}</td><td>${pvo.hits}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>









