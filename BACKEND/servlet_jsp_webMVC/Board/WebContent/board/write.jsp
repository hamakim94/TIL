<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글 작성</h2>
	
	${board.title }
	<!-- action을 안 쓰면 내 페이지에 요청 그대로 보냄. -->
	<form action ="/Board/board/write" method = "POST">
		<div>
			<label>제목</label>
			<input type = "text" name = "title">
		</div>
		
		<div>
			<label>글쓴이</label>
			<input type = "text" name = "writer">
		</div>	
		
		<div>
			<label>내용</label>
			<textarea name = "content" rows = "10" cols = "100"></textarea>
		</div>	
		
		<div>
			<button>전송</button>
		</div>				
	</form>
	
</body>
</html>