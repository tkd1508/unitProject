<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container panel panel-info">
		<h3 class="panel-heading">검색어</h3>
	<form action="${pageContext.request.contextPath}/para001" method="GET">
	<fieldset>
	<legend>search</legend>
	<label>search</label>
	<input type="text"	name="search"  class="form-control" 	id="search"   placeholder = "작성자를 적어주세요"/> 
	<input type="submit" value="입력"	 class="btn btn-block"  title="데이터삽입"  id="click1"/> <br>
		
	</fieldset>
	</form>
	</div>
</body>
</html>