<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
</head>
<body>
	<div class="container">

		<h2>자유게시판</h2>
		<hr>
		<div>
			<table class="table text-center">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody id="boardTbody"></tbody>

			</table>
			<div>
				<form action="${root }/board/list">
					<select name="mode">
						<option value="1">제목
						<option value="2">내용
						<option value="3">제목+내용
					</select> <input type="text" name="keyword"> <input type="submit"
						value="검색">
				</form>
			</div>
			<div class="d-flex justify-content-end">
				<a class="btn btn-outline-danger" href="${root }/board/writeForm">등록</a>
			</div>
		</div>
	</div>

	<script>
		
		const xhr = new XMLHttpRequest();
		/* 비동기 방식, 다 되면 나한테 줘(함수) : 콜백함수의 개념 */
		/* 즉, 떡집에서 신호를 줬음 */
		xhr.onreadystatechange = function() {
			/* readystate라는 값이 change됐을 때 알려줘
			   근데 readyState는 0~4까지, 4 하면 끝이니 총 4번 호출 */
			if(xhr.readyState == 4){ // 서버에 요청한 데이터 처리 완료(에러, 정상)
				if(xhr.status == 200){ // restcontroller에서 http.ok 했으니
					// 정상적으로 처리됐으면 body 데이터에 온다 => xhr.response에
					//console.log(typeof xhr.response)
					const list = JSON.parse( xhr.response );
					let html = "";
					
					for( let board of list){
						console.log(board)
						html += `
							<tr>
								<td>\${board.id}</td>
								<td> <a href="${root}/board/detail?id=\${board.id}">\${board.title}</a></td>
								<td>\${board.writer}</td>
								<td>\${board.viewCnt}</td>
								<td>\${board.regDate}</td>
							</tr>
						`;
					}
					document.getElementById("boardTbody").innerHTML = html;
					
				} else{
					alert("에러 발생 : " + xhr.status)
				}
			}
		};
		/* 여기서 함수를 실행해야하나? board.id값을 path-variable로 주는 느낌? 
		   <a href = "${root}/board/detail?id=\${board.id}">\${board.title}<a> */
		// 어떤 페이지에 어떤 방식으로 처리를 할지 지정  http://localhost:8080/api/board
		xhr.open("GET", "/api/board/"); 
		xhr.send(); // 데이터 직접 요청
		
	</script>
</body>
</html>












