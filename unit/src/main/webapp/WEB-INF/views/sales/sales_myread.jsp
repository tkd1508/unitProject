<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/popol_header.jsp" %>
<%@ taglib  uri="http://www.springframework.org/security/tags"  prefix="sec" %>
<style>
.salseimg img {width:100%; height:180px;}
/*
.mysalsebox {  box-sizing: border-box; word-break: break-all; }
.salsehistorybox1 {background: #fff; border: 1px solid #e6e6e6; margin-top: 15px;}
.salsetitle {    flex-basis: calc(100% - 115px); padding-left: 61px; }
*/

.salsestate.col-sm-2 {
    line-height: 50%; 
    font-weight: bold;
    font-size: 16px;
}

.ksw_info.ksw_title {
    margin-top: 14px;
}
.ksw_info {
    text-align: right;
}

.ksw_info.ksw_title a {
    text-align: left;
    color: #333;
    font-weight: bold;
    font-size: 20px;
}

.ksw_info.salseprice.col-sm-2 {
    text-align: center;
    color: #333;
    font-weight: bold;
    font-size: 16px;
    margin-top: 50px;

</style>
<body>
<% %>

<div class="container panel panel-info">
<div class="col-sm-3">
<div><h3>마이페이지</h3></div>
<div><a href="http://sanguk1508.cafe24.com/unit/talentSales/intro?param=<%=session.getAttribute("nicname")%>">판매 관리 (판매자 전용)<img></a></div>
<%-- <div><a href="${PageContext.request.contextPath}/">구매 관리 (구매자 전용)<img></a></div> --%>
<div><a href="http://sanguk1508.cafe24.com/joinboard_popol/join_detail.join">계정 설정           <img></a></div>
<div><a href="http://sanguk1508.cafe24.com/joinboard_popol/join_delete.join">회원 탈퇴           <img></a></div>

</div>

<div class="col-sm-9">
	<sec:authorize access ="hasRole('ROLE_UNIVERSITY')">
	<div><a href="${pageContext.request.contextPath}/talentSales/insert" class="col-sm-12 btn btn-danger">글 등록하기</a></div>
    </sec:authorize>
    <sec:authorize access ="hasRole('ROLE_NOMAL')">
	<div style="display:none"><a href="${pageContext.request.contextPath}/talentSales/insert" class="col-sm-12 btn btn-danger">글 등록하기</a></div>
    <div><p>일반회원은 게시물을 등록하실 수 없습니다.</p></div>
    </sec:authorize> 
    <div class="col-sm-3" style="padding-bottom: 20px; padding-top: 20px; text-align: center;" ><span>판매이미지</span></div>
    <div class="col-sm-5" style="padding-bottom: 20px; padding-top: 20px; text-align: center;"><span>판매글 제목</span></div>
    <div class="col-sm-2" style="padding-bottom: 20px; padding-top: 20px; text-align: center;"><span>판매 가격</span></div>
    <div class="col-sm-2" style="padding-bottom: 20px; padding-top: 20px; text-align: center;"><span>심사 상태</span></div>

<c:forEach var="dto" items="${dto}" varStatus="status"> 
	<c:choose>
		<c:when test="${dto.salesNum != null}">
			<div class="row" style="padding-bottom: 30px;">
			    <div class="salseimg col-sm-3" ><a href="${pageContext.request.contextPath}/talentSales/readOne?salesNum=${dto.salesNum}&userNum=${dto.userNum}" title="상세페이지로 이동"><img  src="${pageContext.request.contextPath}/resources/upload/${dto.salesImg}" alt=""/></a></div>
			    <div class="salsetitle col-sm-5" >
			    <div class="ksw_info">
			    <a href ="${pageContext.request.contextPath}/talentSales/update?salesNum=${dto.salesNum}&userNum=${dto.userNum}"" title="" class="btn btn-danger form-controler">수정하기</a>
			    <input type="button" class="btn btn-danger form-controler detail_cancel" data-a="${dto.salesNum}" value="삭제하기"></div>
			     <div class="ksw_info ksw_title"><a href="${pageContext.request.contextPath}/talentSales/readOne?salesNum=${dto.salesNum}&userNum=${dto.userNum}" title="상세페이지로 이동">${dto.salesTitle}</a></div>
			    </div>
			    <div class="ksw_info salseprice col-sm-2">${dto.salesPrice}</div>
			    <div class="salsestate col-sm-2" style="padding-top: 50px; padding-left: 30px;"><span class="btn btn-default">${dto.salesRegistState}</span></div>
		    </div>
	    </c:when>
	    
    </c:choose>
</c:forEach>
<c:set var="dto" value="${dto}"></c:set>
<c:if test="${dto == null}">
	    <div class="row" style="padding-bottom: 30px;">
			    <div class="salsetitle col-sm-12">재능 판매 게시물이 비어있습니다.</div>
			    </div>
	    </c:if>



</div>		

<script>
$(function(){
	$(".detail_cancel").on("click", function() {
		console.log("클릭 연결");
		if (confirm("정말 삭제 하시겠습니까?")) {
			// console.log("${pageContext.request.contextPath}/talentSales/delete?salesNum="+$(this).attr("data-a"));
			location.href = "${pageContext.request.contextPath}/talentSales/delete?salesNum="+$(this).attr("data-a");
		} 
	});
});
</script>
</div>
<%-- 
<div class="col-sm-9"><h4 class="panel-heading">계정설정</h4>
<form action="${pageContext.request.contextPath}/edit_ok.join?jno=${dto.jno}" method="post" id="join_form">
<fieldset>
<legend></legend>

<div class="from-group">
<label for="jemail">email(아이디)</label>
<input type="email" name="jemail" id="jemail" class="form-control" value="${readnic.jemail}" style="background-color: #d3d3d3" readonly="readonly" />
</div>

<div class="from-group">
<label for="jnicname">닉네임</label>
<input type="text" name="jnicname" id="jnicname" class="form-control" value="${readnic.jnicname}" style="background-color: #d3d3d3" readonly="readonly"/>
</div>

<div class="from-group">
<label for="jphone_num">휴대폰</label>
<div style="text-align:right"><input type="button"   id="phone_edit"  value="수정"></div>
<input type="number" name="jphone_num" id="jphone_num" class="form-control" value="${readnic.jphone_num}" />
</div>

<div class="from-group">
<label for="jjob">직업</label>
<div style="text-align:right"><input type="button"   id="test"  value="수정"></div>

<input type="text" name="jjob" id="jjob" class="form-control r1" value="${readnic.jjob}" style="background-color: #d3d3d3" readonly="readonly"/>

<select id ="jjob_select" name="jjob_select" class="form-control">
<option value="---선택---">---선택---</option>
<option value="대학생">대학생</option>
<option value="일반회원">일반회원</option>
</select>
</div>

<div class="form-group">
<input type ="checkbox" name ="jevent_ad_check" value="true" id ="jevent_ad_check" <c:if test="${readnic.jevent_ad_check}">checked="checked"</c:if> >
<label for="jevent_ad_check">이벤트 할인 혜택 알림 수신에 동의합니다.</label>
</div>

<div class="form-group">
<input type="submit" value="완료!" class="btn btn-danger form-control">
</div>


</fieldset>
</form>

<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
<script>
	
	$(function(){
		$("#jphone_num").prop("readonly",true);
		
		$("select").hide();
		$("#test").on("click", function(){
			$("select").show();
			$("#jjob").hide()
		});
		
		$("#phone_edit").on("click",function(){
				$("#jphone_num").prop("readonly",false);
		});
		
		
		
		
		
		}); // $(function(){
</script>

</div> --%>


</body>

<%@ include file="../inc/popol_footer.jsp" %>