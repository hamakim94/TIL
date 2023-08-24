<%@page import="com.hamakim94.board.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
		<% 
			for(Board b : list) {
		%>
			<tr>
				  <td><%= b.getNo() %></td>
				<td><%= b.getTitle() %></td>
				<td><%= b.getWriter() %></td>
				<td><%= b.getViewCnt() %></td>
				<td><%= b.getNo() %></td> 
				<!--<td>${b.no}</td>
				<td>${b.title}</td>
				<td>${b.writer}</td>
				<td>${b.viewCnt}</td>-->
			</tr>
		<% } %>
		</tbody>
		
	</table>
</body>
</html>