<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
</head>
<body>
	<div class="container">
	<h2>자유게시판</h2>
	<form method="post" id = "createForm" enctype="multipart/form-data">
		<input type="hidden" value="write" />
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
		<!--  클릭하면 아래 스크립트 함수 실행,  -->
		<button type = "button"  class="btn btn-primary" onclick = "createForm()">등록</button>
	</form>
	</div>
	
	<script>
		function createForm(){
			let xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status == 201){
						alert("현재 상태" + xhr.responseText)
						location.href = '${root}/board/list';
					} else{
						alert("에러 발생 : " + xhr.status)
					}
				}
			}
			let form = document.querySelector('#createForm');
			let data = new FormData(form);
		
			xhr.open('POST', '${root}/api/board');
			xhr.send(data);
		}
	</script>
</body>
</html>