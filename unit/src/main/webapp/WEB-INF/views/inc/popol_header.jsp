<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
  <title>열정적인 개발자 홍길동 회사가 원하는 인재상</title>
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/imgs/icon.png" type="image/x-icon">
  <link rel="icon"          href="${pageContext.request.contextPath}/imgs/icon.png" type="image/x-icon">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>

 .myhidden{  position:absolute;  left:-9999%;  width:1px; height:1px; overflow:hidden; font-size:0;  line-height:0; }
 .Logo img { width:130px; }
 .container {
    padding: 10px 15px;
    font-family: 'Noto Sans KR','NanumGothic', '나눔고딕','Nanum Gothic', '맑은 고딕', 'Malgun Gothic', Dotum;
    cursor: pointer;
}
.navbar-nav.lnb>li>a {
    padding: 17px 30px;
    font-size: 17px;
    color: #2e3248;
    font-weight: 600;
}
.navbar-nav.lnb2>li>a {
    padding-top: 20px;
    font-size: 15px;
    color: #6e6d7a;
}

.ksw_header{ box-shadow: 0 0 5px rgb(0 0 0 / 50%);    }

.ksw form input{ vertical-align: bottom; border:0 none; background-color: #f7f7f7;}

.ksw form fieldset{ background-color: #f7f7f7; padding: 6px; border-radius:30px;}

.ksw form input[type="search"]{ margin-left: 10px; float:left; }
.ksw form input[type="submit"]{ float:right; background:url(${pageContext.request.contextPath}/imgs/search.png) 0 0;  background-size: 20px;
    width: 20px;}

.ksw form.nav.navbar-nav.col-sm-3 {
    margin-top: 11px;
}

.ksw li.dropdown.nic {
    float: right;
}
form#logout {
    margin-left: 19px;
}
</style>


</head>
<body>




<div class="ksw_header">
  <div class="container ksw">
    <h1 class="Logo navbar-nav col-sm-2"> <a href="http://sanguk1508.cafe24.com/joinboard_popol/main.join"> <img alt="유닛로고" src="${pageContext.request.contextPath}/imgs/logo.png"> </a></h1>
    <ul class="nav navbar-nav lnb col-sm-5">
      <!-- <li><a href="#">재능의뢰</a></li> -->
      <li><a href="${pageContext.request.contextPath}/talentSales/main">재능판매</a></li>
      <li><a href="http://localhost:8080/joinboard_popol/list.do">고객센터</a></li>
    </ul>
    
    
    <!-- <form class="nav navbar-nav col-sm-3" action="#" method="get">
    <fieldset class=""><legend class="myhidden">search</legend>
    <input type="search" name="search" title="검색어를 입력해주세요." placeholder="검색어를 입력해주세요."/>
    <input type="submit" value="" title="검색어를 입력해주세요."/>
    </fieldset>
    </form> -->
    
    
    <ul class="nav navbar-nav navbar-right lnb2 col-sm-2">
    <%  if(session.getAttribute("salesid") == null){  %>
      <li><a href="http://sanguk1508.cafe24.com/joinboard_popol/login.join">로그인</a></li>
     
    <%  }else if(session.getAttribute("salesid") != null){  %> 
    
       <li class="dropdown nic"><a href="${pageContext.request.contextPath}/talentSales/readMyselect" class="dropdown-toggle" data-toggle="dropdown" ><%=session.getAttribute("nicname")%> 님 <span class="caret"></span></a>
       <ul class="dropdown-menu">
       <% if(!(session.getAttribute("nicname").equals("admin"))){ %>
          <li><a href="${pageContext.request.contextPath}/talentSales/readMyselect">마이페이지</a></li>
          <!-- <li><a href="#">프로필</a></li>
          <li><a href="#">메시지</a></li> -->
          <%}else if(session.getAttribute("nicname").equals("admin")){ %>
          <li><a href="http://sanguk1508.cafe24.com/joinboard_popol/login_cmd.join">회원관리</a></li>
          <%} %> 
          <li> 
		    <form id="logout" action="${pageContext.request.contextPath}/talentSales/logout" method="post">
		    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		    <a href="#" onclick="document.getElementById('logout').submit();">logout</a>
		    </form> 
      	  </li>
		  </ul>
		  </li>
    <% } %>
    </ul>
  </div>
</div>  
