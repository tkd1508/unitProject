<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/popol_header.jsp" %>

<!--  -->
 <script>
var result = "${result}";
console.log(result);
if(result == "success"){alert('판매자 등록하기 성공! 로그인을 다시 해주세요.!'); }
else if (result == "fail") {alert(result);}
</script>
<div class="container panel panel-info">
	<h3 class="panel-heading">FORM-LOGIN</h3>

	<div class="row">
	<div class="col-sm-6 r1">
	<p>
	판매를 하시려면 판매자 등록이 필요합니다.</p>
	
	<a href="${pageContext.request.contextPath}/join/salesjoin?param=${nicname}" class="btn btn-info form-controler"  title="">판매자 등록하러가기</a>
	<!-- jsp에서 던진거 받는 nicname -->
	
	</div>
	<div class="col-sm-6">
	<!-- 스프링에서 던지거 받는 nicname -->
	<%session.setAttribute("nicname", request.getParameter("param")); %>
	<p><%=session.getAttribute("nicname")%> 님 판매를 하시려면 판매자 등록후 다시 로그인 부탁드립니다.
	
	
	</p>
	<a href="${pageContext.request.contextPath}/join/saleslogin" class="btn btn-danger form-controler"  title="">판매자 로그인하러가기</a>
	</div>
	</div>

	</div>
<%@ include file="../inc/popol_footer.jsp" %>
