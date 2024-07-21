<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container panel panel-warning">
	<h3 class="panel-heading">Login Form</h3>
	<pre>
	- 고정사항 - 
	1. action="/login"
	2. method="post"
	3. name="username" / name="password" / name="remember-me"
	4. 보안 csrf : input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"
	</pre>
	<form action="${pageContext.request.contextPath}/login" method="post">
	<fieldset>
	<legend>로그인 SECURITY</legend>
		<div class="form-group">
			<label for="username">USER-ID</label>
			<input type="text" id="username" name="username" class="form-control" placeholder="USER ID"/>
		</div>
		<div class="form-group">
			<label for="password">USER-PW</label>
			<input type="password" id="password" name="password" class="form-control" placeholder="USER PW"/>
		</div>
		<div class="form-group">
			<label for="remember-me">remember</label>
			<input type="checkbox" id="remember-me" name="remember-me"/>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-info" value="로그인" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</div>
	</fieldset>	
	</form>
</div>
<!--		  -->
<!--		  -->
<!--		  -->
</body>
</html>