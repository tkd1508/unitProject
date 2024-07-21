<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/popol_header.jsp" %>
<%@ page isELIgnored ="false" %>
<!--  -->
<%
String id = "";
String remember = "";
boolean ison = false;
String cookie = request.getHeader("Cookie"); // 쿠키 불러와
if (cookie != null) { // 쿠키가 있다면
	Cookie[] cookies = request.getCookies(); // 배열화하고
	for (int i = 0; i < cookies.length; i++) {
		if (cookies[i].getName().equals("id")) {
	id = cookies[i].getValue();
		}
		if (cookies[i].getName().equals("remember")) {
	remember = cookies[i].getValue();
	ison = true;
		}

	}
}
%>

<div class="container panel panel-info">
	<h3 class="panel-heading">FORM-LOGIN</h3>

	<p style="text-align: center">
		<!-- <p class="text-center"> -->
		<img src="${pageContext.request.contextPath}/resources/imgs/people.png"
			alt="사람 픽토그램">
	</p>

	<form action="${pageContext.request.contextPath}/login"
		method="post" id="from">
		<fieldset>
			<legend>판매자 전용 로그인</legend>
			<div class="form-group">
				<label for="username">닉네임</label> <input type="text"
					name="username" id="username" class="form-control"
					value = <%=session.getAttribute("nicname") %>  >
					 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
			</div>
			<div class="form-group">
				<label for="password">판매자 비밀번호</label> <input type="text"
					name="password" id="password" class="form-control"
					placeholder="비밀번호를 입력해주세요.">
			</div>

			<div class="from-group" style="text-align: center">
				<input type="submit" value="login" class="btn btn-info form-control"
					title="판매자 전용페이지로 이동합니다.">
			</div>

			<%-- <div class="form-group">
				<input type="checkbox" id="remember" name="remember" value="on"
					<%if (ison) {%> checked="<%=remember%>" <%}%>><label
					for="remember">아이디기억하기</label>
				<div style="text-align: right">
					<a href="search_login.jsp" title="" id="">아이디/비밀번호 찾기</a>
				</div>
			</div>

			<div class="from-group" style="text-align: center">
				<a href="${pageContext.request.contextPath}/join.join"
					class="btn btn-info" title="#">회원가입</a>
			</div> --%>
		</fieldset>
	</form>
	<script>
		$(function() {
			$("#from").on("submit", function() {
				if ($("#salesId").val() == "") {
					alert("아이디 입력해주세요.");
					$("#salesId").focus();
					return false
				}
				if ($("#salesPw").val() == "") {
					alert("비밀번호 입력해주세요.");
					$("#salesPw").focus();
					return false
				}
			});
			/* if ("${loginFailMsg}" != null) {
				alert(${loginFailMsg});
			} */
		});
	</script>
</div>
<!--  -->
<%@ include file="../inc/popol_footer.jsp" %>
