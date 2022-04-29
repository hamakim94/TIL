<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>자유게시판</title>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
</head>
<body>
	<div class="container">
		<h2>자유게시판</h2>
		<hr />
		<div class="card" style="width: 30rem;">
			<div class="card-body">
				<h5 class="card-title">${board.title}<span class="badge bg-danger">${board.viewCnt}	</span></h5>
				<div class="d-flex justify-content-between">
					<div class="card-subtitle mb-2 text-muted">${board.writer}</div>
					<div class="card-subtitle mb-2 text-muted"> ${board.regDate}</div>
				</div>
				<hr>
				<p class="card-text">${board.content}</p>
				<hr>
				<!-- 지금 : /board/board/detail  -->
				<a href="download?id=${board.id }">${board.fileName }</a>
				<!-- 상대경로로 맨 마지막 지워지고, download로 가기 떄문에
				     /board/board/download로 가짐 -->
				<div>
					<a class= "btn btn-secondary"href='${root }/board/updateForm?id=${board.id}'>수정</a> 
					<button class= "btn btn-success" onclick = "doDelete(${board.id})">삭제</button>
					<a class="btn btn-info" href='${root }/board/list'>목록</a>
					<!-- href='${root }/board/delete?id=${board.id}'>삭제</a> -->
				</div>
			</div>
		</div>

	</div>
	<script>
		/* 삭제 버튼 구현 */
		function doDelete(id){
			let xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status = 204){
						alert(xhr.responseText);
						location.href = '${root}/board/list'
					} else{
						alert("에러 발생 : " + xhr.status);
					}
				}
			}
			xhr.open("DELETE", `${root}/api/board/\${id}`)
			xhr.send()
		}
		
	</script>
</body>
</html>