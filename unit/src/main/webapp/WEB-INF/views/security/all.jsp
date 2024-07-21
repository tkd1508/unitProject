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
<div class="container panel panel-success">
	<h3 class="panel-heading">ALL</h3>
	<pre>
	ㅁ 표현식을 이용하는 동적화면구성
		hasRole()		해당권한이 있으면 true
		hasAnyRole()	여러 권한들중 하나라도 해당이 되면 true
		principal()		현재 사용자 접오
		permitAll()		모든사용자에게 허용
		denyAll()		모든사용자에게 거부
		isAnoymous()	익명의 사용자
		isAuthenticated()	인증된 사용자	
	</pre>
	<sec:authorize access="isAnonymous() ">	
		<a href="${pageContext.request.contextPath}/security/mylogin" class="btn btn-danger">LOGIN</a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated() ">	
		ALL - 인증이 되었습니다
	</sec:authorize>
</div>
<script>
var result = "${result}";
if(result == "실패"){ alert(result); }
else{ alert(result); }
</script>

<!--		  -->
<!--		  -->
<!--		  -->
</body>
</html>