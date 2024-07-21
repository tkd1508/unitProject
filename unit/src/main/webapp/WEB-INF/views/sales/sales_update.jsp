<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/popol_header.jsp" %>

<body>

	<div class="container panel panel-info">
		<h3 class="panel-heading">재능 판매 수정하기</h3>
		<form action="${pageContext.request.contextPath}/talentSales/update?${_csrf.parameterName}=${_csrf.token}" method="post" id="join_form" enctype="multipart/form-data">
			<fieldset>
				<legend>재능 판매 글 수정하기</legend>
				
				<div class="from-group">
				<input type="hidden"	name="pre_file"  class="form-control" 	value="${dto.getSalesImg()}"/>
				<label for="file">재능 판매 이미지</label> 
				<input type="file" name="file" id="file" class="form-control"/>
				<div><img  src="${pageContext.request.contextPath}/resources/upload/${dto.salesImg}" alt="판매글상세이미지"  /></div>
				</div>
				
				<div class="from-group">
					<label for="salesTitle">제목</label> 
					<input type="text" name="salesTitle" id="salesTitle" class="form-control" value = "${dto.getSalesTitle()}" />
				</div>
	
				<div class="form-group">
					<label for="salesMainCategory">카테고리</label> 
					<input id="salesMainCategory" name="salesMainCategory" class="form-control" value = "${dto.getSalesMainCategory()}" readonly >
					<input id="salesSubCategory" name="salesSubCategory" class="form-control" value = "${dto.getSalesSubCategory()}" readonly >
				</div>
				
				<div class="from-group">
					<label for="salesInfo">서비스 소개</label> 
					<textarea name="salesInfo" id="salesInfo" class="form-control" rows="10" >${dto.getSalesInfo()}</textarea>
				</div>
				
				<div class="from-group">
					<label for="salesCurriculum">서비스 절차</label> 
					<textarea name="salesCurriculum" id="salesCurriculum" class="form-control" rows="10" >${dto.getSalesCurriculum()}</textarea>
				</div>

				 
			
				
			
				<div class="from-group">
					<label for="salesPrice">가격</label> 
					<input type="number" name="salesPrice" id="salesPrice" class="form-control" placeholder="가격을 입력해주세요" value = "${dto.getSalesPrice()}" />
					
				</div>
				
				<!-- hidden -->
				<div class="from-group">
					<input type="hidden" name="userNum" id="userNum" value = "${dto.getUserNum()}" readonly/>
					<input type="hidden" name="salesNum" id="salesNum" value = "${dto.getSalesNum()}" readonly/>
				</div>
				
				<!-- button -->
				<div class="form-group">
					<input type="submit" value="수정하기" class="btn btn-danger form-control">
				</div>
				<div class="form-group">
					<input type="button" value="뒤로가기" class="btn btn-info form-control">
				</div>
			</fieldset>
		</form>
		<script>

	$(function(){
		// 토글 숨기기
		 $(".r2").hide();
		 $(".r3").hide();
		 // 닉네임 TIP 토글	
		 $("#salesPrice").on("click", function(){ $(".r2").toggle(400); });	
		 // 이메일 TIP 토글	
		 $("#salesTitle").on("click", function(){ $(".r3").toggle(400); });	
			
		  var sub = [["--선택--"],["로고","상세페이지","명함","웹"],["블로그","카페","SNS"]];
         $("#salesMainCategory").on("change", function(){
       	  $("#salesSubCategory").html('');
       	  var selectedIndex = $('#salesMainCategory option').index($('#salesMainCategory option:selected'));
			  console.log   (  sub[selectedIndex][0] );
			  console.log   (  sub[selectedIndex][1] );
       	  
       	  for(var index=0;   index< sub[selectedIndex].length ; index++ ){
				 var  option=  $("<option>").html(  sub[selectedIndex][index]  ).attr("value" , sub[selectedIndex][index] );
       	  	 $("#salesSubCategory").append(option);    
			  }
         });
		 
		$("#join_form").on("submit", function() {
			if ($("#salesTitle").val() == "") { alert("제목을 입력해주세요."); $("#salesTitle").focus(); return false; }
			if ($("#salesMainCategory").val() == "") { alert("카테고리를 입력해주세요."); $("#salesMainCategory").focus(); return false; }
			if ($("#salesSubCategory").val() == "") { alert("작업유형을 입력해주세요."); $("#salesSubCategory").focus(); return false; }
			if ($("#salesInfo").val() == "") { alert("서비스 소개란을 입력해주세요."); $("#salesInfo").focus(); return false; }
			// if ($("#jphone_num").val() == "") { alert("휴대폰 번호를 입력해주세요."); $("#jphone_num").focus(); return false; }
			// 휴대폰 번호 10자리 또는 11자리 정규화 검사 (휴대폰 번호 입력후 jjob 클릭시 테스트문구 발생)
			var reg = /^01([0|1|6|7|8|9])?([0-9]{3,4})?([0-9]{4})$/;
			// if(false == reg.test($("#jphone_num").val())){alert('휴대폰 번호 10자리 또는 11자리를 입력해주세요.'); return false;}
			// else{console.log("통과");}
			if ($("#salesCurriculum").val() == "") { alert("서비스 절차(커리큘럽)을 기입해주세요."); $("#salesCurriculum").focus(); return false; }
			if ($("#salesPrice").val() == "") { alert("가격을 입력해주세요!"); $("#salesPrice").focus(); return false; }
			
			console.log( "1 : " + $("#salesTitle").val());
			console.log( "2 : " + $("#salesMainCategory").val());
			console.log( "3 : " + $("#salesSubCategory").val());
			console.log( "4 : " + $("#salesInfo").val());
			console.log( "5 : " + $("#salesCurriculum").val());
			console.log( "6 : " + $("#salesPrice").val());
			
			
			
 			 /* dto.setUserNum(2); // 유저테이블 PK(로그인 닉네임)   ##
			 dto.setSalesNum(2); // 판매글테이블 PK - 유저테이블 FK(로그인 닉네임)   ##
			 dto.setSalesTitle("testTitle");   --1
			 dto.setSalesInfo("testInfo"); --4
			 dto.setSalesCurriculum("test"); --5
			 dto.setSalesPrice(1000);-- 6
			 dto.setSalesImg("k.jsp"); 
			 // dto.setSalesJoinIp("123.123");
			 dto.setSalesMainCategory("문서 작업");--2
			 dto.setSalesSubCategory("녹취록 작성");--3
			 log.info("........."+Mapper.insert(dto)); */
		}); 
		
		// 비밀번호 8자리 이상 숫자 대문자 특수분자 정규화 검사
		
		/* $("#jpassward_temp").on("click", function(){
			var reg = /^.*(?=^.{8,}$)(?=.*\d)(?=.*[A-Z])(?=.*[!@#$%^&+=]).*$/;
			if(false == reg.test($("#jpassward").val())){alert('비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.');}
			else{console.log("통과");} });*/
	}); // $(function(){
</script> 
	</div>
</body>

<%@ include file="../inc/popol_footer.jsp" %>