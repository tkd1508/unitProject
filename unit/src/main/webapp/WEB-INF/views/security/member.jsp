<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
<div class="container panel panel-info">
	<h3 class="panel-heading">MEMBER</h3>
	<pre>
	ㅁ 표현식을 이용하는 동적화면구성
		hasRole()		해당권한이 있으면 true
		hasAnyRole()	여러 권한들중 하나라도 해당이 되면 true
		principal()		현재 사용자 접오
		permitAll()		모든사용자에게 허용
		denyAll()		모든사용자에게 거부
		isAnoymous()	익명의 사용자
		isAuthenticated	인증된 사용자	
	</pre>
	<table class="table table-striped">
	<caption>사용자 정보</caption>
		<tbody>
		<tr> <th scope="row">PRICIPAL</th> <td><sec:authentication property="principal"/></td> </tr>
		<tr> <th scope="row">MemberVO</th> <td><sec:authentication property="principal.member"/></td> </tr>
		<tr> <th scope="row">ID</th> <td><sec:authentication property="principal.member.userid"/></td> </tr>
		<tr> <th scope="row">PASS</th> <td><sec:authentication property="principal.member.userpw"/></td> </tr>
		<tr> <th scope="row">사용자 권한</th> <td><sec:authentication property="principal.member.authList"/></td> </tr>
		</tbody>
	</table>
</div>
<!--		  -->
<!--		  -->
<!--		  -->
</body>
</html>