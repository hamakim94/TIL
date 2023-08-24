<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ContextPath 자주 쓰니까. 여기에 다 선언해버리자  -->
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value = "${pageContext.request.contextPath }"></c:set> 

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
	
	<c:choose>
		<c:when test="${!empty username }">
			${username } 님 안녕하세요 <a href="${root }/user/logout">로그아웃</a>
		</c:when>
		
		<c:otherwise>
			<a href = "${root }/user/login">로그인</a>
			<a href = "${root }/user/join">회원 가입</a>
		</c:otherwise>
	</c:choose>