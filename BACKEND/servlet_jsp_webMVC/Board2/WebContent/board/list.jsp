<%@page import="com.hamakim94.board.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%
	// request로 넘어온 데이터를 꺼내보자 , 강제 형 변환 시키자!
	List<Board> list = (List<Board>) request.getAttribute("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글 목록 조회</h2>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>조회수</th>
				
			</tr>
			
		</thead>
		<tbody>
			<c:if test="${list.size() ge 2}" >
		<!-- 여기서 반복문 돌면서 꽂아넣을래 -->
			<c:forEach items="${list }" var= "item" >
				<tr>
					<td>${item.no }</td>
					<td>${item.title }</td>
					<td>${item.writer }</td>
					<td>${item.viewCnt }</td>
					
					
				</tr>
			</c:forEach>
			</c:if>
			
			<c:if test = "${empty list }">
				<c:out value="으하하하"/>
			</c:if>
		</tbody>
		
	</table>
</body>
</html>