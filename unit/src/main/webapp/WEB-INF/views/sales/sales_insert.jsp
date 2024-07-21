<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/popol_header.jsp" %>
<style>
.ksw_salseinsert input {
    padding: 20px;
    margin-bottom: 10px;
}
.ksw_salseinsert {
    width: 734px;
}
</style>
<body>
<body>
	<div class="container panel panel-info ksw_salseinsert">
		<h3 class="panel-heading">재능 판매 글 등록</h3>
		<form action="${pageContext.request.contextPath}/talentSales/insert?${_csrf.parameterName}=${_csrf.token}" method="post" id="join_form" enctype="multipart/form-data">
			<fieldset>
				<legend>재능 판매 글 등록</legend>
				<div class="from-group">
				<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
					<label for="salesTitle">제목</label> 
					<input type="text" name="salesTitle" id="salesTitle" class="form-control" />
					<div class="r3 well">
						<p>TIP*</p>
						<p>[ , ] , &lt; . &gt; / 와 같은 특수 문자와 가격 정보는 제목으로 사용하실 수 없습니다.</p>
						<p>최초, 유일, 무한, 1위, 수익 금액 등은 인증 자료를 제출 후에만 사용할 수 있습니다.</p>
					</div>
					  
				</div>

				<div class="form-group a">
					<label for="salesMainCategory">카테고리</label> 
					<select id="salesMainCategory" name="salesMainCategory" class="form-control ">
						<option value="---선택---">---선택---</option>
						<option value="디자인">디자인</option>
						<option value="통역,변역">통역,변역</option>
						<option value="마케팅">마케팅</option>
						<option value="영상 제작 및 편집">영상 제작 및 편집</option>
						<option value="레슨">레슨</option>
						<option value="문서작업">문서작업</option>
						<option value="스포츠">스포츠</option>
					</select>
					
					<select id="salesSubCategory" name="salesSubCategory" class="form-control">
						<option value="---선택---">---선택---</option>
 					</select>
				</div>
				
				<div class="from-group">
					<label for="salesInfo">서비스 소개</label> 
					<textarea name="salesInfo" id="salesInfo" class="form-control" rows="10" ></textarea>
				</div>
				
				<div class="from-group">
					<label for="salesCurriculum">서비스 절차</label> 
					<textarea name="salesCurriculum" id="salesCurriculum" class="form-control" rows="10" ></textarea>
				</div>

				<div class="from-group">
				<label for="file">이미지 파일업로드</label> <input type="file" name="file"
					id="file" class="form-control" />
				</div> 
			
				<div class="from-group">
					<label for="salesPrice">가격</label> 
					<input type="number" name="salesPrice" id="salesPrice" class="form-control" placeholder="가격을 입력해주세요" />
					<div class="r2 well">
						<p>TIP</p>
						<p>기본 금액을 입력해주세요.</p>
						<p>부가세(VAT)포함 : 일반과세자/법인사업자 전문가의 서비스(*면세/간이사업자, 개인 프리랜서의 판매 서비스는 해당 없음)</p>
						<p>추가 금액은 서비스 소개 및 의뢰인과 협의 부탁드립니다.</p>
					</div>
				</div>
				<div class="form-group">
					<input type="submit" value="제출하기" class="btn btn-danger form-control">
				</div>
				<div class="form-group">
					<input type="button" value="뒤로가기" class="btn btn-danger form-control">
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