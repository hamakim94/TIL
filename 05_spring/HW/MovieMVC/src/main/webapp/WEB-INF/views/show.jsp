<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- <!DOCTYPE html> -->
<html>

<!-- CSS only -->
<head>
<title>Show</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>


<body>

	<div class="container text-center">
		<br>
		<h1>내가 등록한 영화 전달되니?</h1>
		<br>
		<hr>
		<br>
		<table class="table table-primary">
			<thead>
				<tr>
					<th scope="col">영화 제목</th>
					<th scope="col">감독</th>
					<th scope="col">쟁르</th>
					<th scope="col">상영 시간</th>
				</tr>
			</thead>
			<tbody>
				<tr class="table-secondary">
					<td>${movie.title }</td>
					<td>${movie.genre }</td>
					<td>${movie.director }</td>
					<td>${movie.runningTime }</td>
				</tr>

			</tbody>
		</table>

	</div>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>