<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
</head>
<body>
	<div class="container">
	<h2>자유게시판</h2>
	<form method="post" action="${root }/board/write" enctype="multipart/form-data">
		<input type="hidden" name="act" value="write" />
		<div class="mb-3">
			<label for="title" class="form-label">제목</label> <input type="text"
				class="form-control" id="title" placeholder="제목을 입력하세요."
				name="title">
		</div>
		<div class="mb-3">
			<label for="writer" class="form-label">글쓴이</label> <input
				type="text" class="form-control" id="writer" name="writer" value="${username }">
		</div>
		<div class="mb-3">
			<label for="content" class="form-label">내용</label>
			<textarea class="form-control" id="content" rows="7" name="content"></textarea>
		</div>
		<div class="mb-3">
			<input class="form-control" type="file" name="upload_file">		
		</div>
		<button class="btn btn-primary">등록</button>
	</form>
	</div>
</body>
</html>