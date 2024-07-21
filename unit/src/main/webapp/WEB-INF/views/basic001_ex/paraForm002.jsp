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
		<h3 class="panel-heading">TEST001</h3>
	<form action="${pageContext.request.contextPath}/para002" method="POST">
	<fieldset>
	<legend>LOGIN</legend>
	<input type="text"	name="login_id"  class="form-control" 	id="login_id" /> 
	<input type="password"	name="login_pw"  class="form-control" 	id="login_pw" /> 
	<input type="submit" value="검색"	 class="btn btn-block"  title="검색"  id="click1"/> <br>
	</fieldset>
	</form>
	</div>
</body>
</html>