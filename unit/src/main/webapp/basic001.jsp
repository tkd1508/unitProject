<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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


</head>
<body>
<!-- 
<div class = "container panel panel-info"><h3 class="panel-heading">ex2</h3>
<p class="panel-body"><a href="${pageContext.request.contextPath}/basic001_ex/test001" class="btn btn-info">start</a></p>

<p class="panel-body"><a href="${pageContext.request.contextPath}/basic001_ex/test002" class="btn btn-info">start-requestmappaing</a></p>

<p class="panel-body"><a href="${pageContext.request.contextPath}/basic001_ex/test003" class="btn btn-info">start-getmappaing</a></p>




</div>
 -->

<div class="container panel panel-info">
		<h3 class="panel-heading">MVC3 PARAMETER</h3>
		<pre>
				http://localhost:8080/프로젝트명/basic001_ex/prarForm001
				Get
				검색가능한 폼 화면
		</pre>
		<pre>
				http://localhost:8080/프로젝트명/basic001_ex/para001
				Get
				
				공지사항.
				이 포트폴리오는 상업적 목적이 아닌 개인 포트폴리오 용도로 제작되었으며,
				홈페이지의 일부내용과 기타 이미지 등은 그 출처가 다로 있음을 밝힙니다.
				
				
				
		</pre>
		
		
		<p class="panel-body">
			<a href="${pageContext.request.contextPath }/basic001_ex/paraForm001"
				class="btn btn-info">paraForm001</a>
		</p>
		
		<p class="panel-body">
			<a href="${pageContext.request.contextPath }/basic001_ex/paraForm002"
				class="btn btn-info">paraForm002</a>
		</p>
		
		<p class="panel-body">
			<a href="${pageContext.request.contextPath }/talentSales/insert"
				class="btn btn-info">join</a>
		</p>
		
		<p class="panel-body">
			<a href="${pageContext.request.contextPath }/talentSales/main"
				class="btn btn-info">join2</a>
		</p>
		
		<p class="panel-body">
			<a href="${pageContext.request.contextPath }/talentSales/salselogin"
				class="btn btn-info">판매자전용 로그인</a>
		</p>
		
		<p class="panel-body">
			<a href="${pageContext.request.contextPath }/talentSales/intro"
				class="btn btn-info">인트로</a>
		</p>
		
	</div>
</body>
</html>