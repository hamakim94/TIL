<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- JavaScript Bundle with Popper -->

<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
<html>
<head>
<title>Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<div class="container text-center">
		<h2>영화 정보 입력!!</h2>
		<form action="movie" method="post">
			영화이름 : <input type="text" name="title"> <br>
			<!-- setTitle 에서 set빼고 T를 소문자로 해준거 알아서 매칭 -->
			영화장르 : <input type="text" name="genre"> <br> 
			감독입력 : <input type="text" name="director"> <br> 
			상영시간입력 : <input type="number" name="runningTime"> <br>
			<button>입력ㅋ</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
