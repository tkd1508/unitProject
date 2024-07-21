<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/popol_header.jsp" %>

<body>

<div class="container panel panel-info"><h3 class="panel-heading">회원가입</h3>
<form action="${pageContext.request.contextPath}/join/join_ok" method="post" id="join_form">
<fieldset>
<legend>회원가입</legend>

<div class="from-group">
<label for="salesId">판매자 전용 ID</label><%-- <%=session.getAttribute("jnicname") %> --%>
<input type="text" name="salesId" id="salesId" class="form-control" placeholder="판매자 ID를 입력해주세요"/>
<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
</div>

<div class="from-group">
<label for="salesPw">판매자 전용 비밀번호(숫자)*</label><%-- <%=session.getAttribute("param") %> --%>
<input type="password" name="salesPw" id="salesPw" class="form-control" placeholder="비밀번호를 입력해주세요"/>
<input type="password" name="salesPw_temp" id="salesPw_temp" class="form-control" placeholder="비밀번호를 한번 더 입력해주세요"/>
</div>

<div class="from-group">
<label for="jemail">이메일 주소</label>
<input type="email" name="jemail" id="jemail" class="form-control" value="${dto.jemail}" readonly/>
</div>

<div class="from-group">
<label for="jnicname">닉네임</label>
<input type="text" name="jnicname" id="jnicname" class="form-control" value="${dto.jnicname}" readonly/>
</div>

<div class="from-group">
<label for="jphone_num">휴대폰 번호</label>
<input type="number" name="jphone_num" id="jphone_num" class="form-control" value="${dto.jphone_num}" readonly/>
</div>

<div class="from-group">
<input type="hidden" name="jjob" id="jjob" class="form-control" value="${dto.jjob}" readonly/>
</div>

<div>
<pre>
 안내사항.
- 판매자 전용 회원가입의 경우, ID 또는 PW 찾기를 지원하고 있지 않습니다.
- 따라서 판매자 전용 ID/PW를 찾고자 하시는 분은 고객센터 문의를 부탁드리겠습니다.
</pre>
</div>


<div class="form-group">
<input type ="checkbox" name ="checkall" value="true" id ="checkall">
<label for="checkall">모두 동의</label>
<input type ="checkbox" name ="check_necessary" value="true" id ="jage_check">
<label for="jage_check">해당하는 정보를 모두 확인하였습니다.(필수)</label>
<input type ="checkbox" name ="check_necessary" value="true" id ="jlaw_check">
<label for="jlaw_check"><a href="#modal1" data-toggle="modal" id="jlaw">판매자 서비스 이용약관</a>에 동의합니다.(필수)</label>
<div class="modal fade" id="modal1" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">서비스 이용약관</h4>
					</div>
					<div class="modal-body">
						<div class="r4"></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
</div>

<div class="form-group">
<input type="submit" value="가입 완료!" class="btn btn-danger form-control">
</div>


</fieldset>
</form>

<script>

	$(function(){
		/*
		// 이메일 인증하기	
		$("#jemail_check").on("click",function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/Emailcheck", type:"post", dataType:"text", 
				data:{"jemail":$('#jemail').val()}
				,success:function(data){
					console.log(data);
					var result = "<span style='color:red'> 중복된 이메일이 존재합니다. </span>";
					if (data == 0){
					result=	"<span style='color:blue'> 해당 메일에서 인증하기 버튼을 눌러주세요. </span>";					
					}
					$(".r0").html(result);
				},
				error : function(xhr, textStatus, errorThrown) { $(".r0").html( textStatus + "(HTTP-" + xhr.status + "/" + errorThrown);  }
			}); // ajax
		});
			
		
		// 닉네임 중복확인
		$("#nic_check").on("click",function(){
			$("#finalcheck").val(-1);
			$.ajax({
				url:"${pageContext.request.contextPath}/IDcheck", type:"get", dataType:"text" , 
				data:{"jnicname":$('#jnicname').val()}
				,success:function(data){
				var result ="<span style='color:red'> 중복된 닉네임이 존재합니다. </span>";
				console.log(data);
				if (data == 0) {
					result="<span style='color:blue'> 사용가능 </span>";
					$("#finalcheck").val(1);
				} else if (data == 2) {
					result="<span style='color:red'> 닉네임을 입력해주세요. </span>";
				}
				
				$(".r1").html(result);
					/* if(data > 0) {$(".r1").html("<span style='color:red'> 중복된 닉네임이 존재합니다. </span>"); $("#finalcheck").val(1);}
					else {$(".r1").html("<span style='color:blue'> 사용가능 </span>");}
				}, //html : 리셋
				error : function(xhr, textStatus, errorThrown) { $(".r1").html( textStatus + "(HTTP-" + xhr.status + "/" + errorThrown);  }
				}); // ajax
			}); // #nic_check
		*/	
		
		// 서비스 이용약관 텍스트 파일 불러오기
		 $("#jlaw").on("click",function(){
				$.ajax({
					url:"${pageContext.request.contextPath}/jdata/text1.txt", type:"get", dataType:"text" , 
					success:function(data){$(".r4").html(data);}, //html : 리셋
					error:function(xhr, textStatus, errorThrown){
						$(".r4").html(textStatus + "(HTTP-"+xhr.status+"/"+errorThrown);
						
					}
				});
			});
		
			
		// 필수 모두 동의시키는 버튼
		$("#checkall").on("click",function(){
			console.log($(":checkbox[name='check_necessary']").prop("checked"));
			console.log($(":checkbox[name='check_necessary']:checked").length);
			if($(":checkbox[name='check_necessary']:checked").length != $(":checkbox[name='check_necessary']").length){
				$(":checkbox[name='check_necessary']").prop("checked",true);
				}else{
				$(":checkbox[name='check_necessary']").prop("checked",false);
				}
		});
			
		// 빈칸 검사 및 필수 체크 검사
		$("#join_form").on("submit", function() {
			if ($("#salesId").val() == "") { alert("아이디 입력해주세요."); $("#salesId").focus(); return false; }
			if ($("#salesPw").val() == "") { alert("비밀번호를 입력해주세요."); $("#salesPw").focus(); return false; }
			if ($("#salesPw_temp").val() == "") { alert("비밀번호 확인을 입력해주세요."); $("#salesPw_temp").focus(); return false; }
			if(($("#salesPw").val()) != ($("#salesPw_temp").val())) { alert("비밀번호가 일치하지 않습니다."); $("#salesPw").focus(); return false; }
			
			if (!$("input:checked[id='jage_check']").is(":checked")) { alert("정보 확인은 필수 입니다."); $("#jage_check").focus(); return false; } 
			if (!$("input:checked[id='jlaw_check']").is(":checked")) { alert("이용약관을 동의해주세요."); $("#jlaw_check").focus(); return false; }
			/*
			if ($("#finalcheck").val() == "-1" || i != $("#jnicname").val()) {
				alert("닉네임 중복확인버튼을 눌러주세요.");
				$("#jnicname").focus();*/
				return false;
			}
		});
		
		// 비밀번호 8자리 이상 숫자 대문자 특수분자 정규화 검사
		$("#jpassward_temp").on("click", function(){
			var reg = /^.*(?=^.{8,}$)(?=.*\d)(?=.*[A-Z])(?=.*[!@#$%^&+=]).*$/;
			if(false == reg.test($("#jpassward").val())){alert('비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.');}
			else{console.log("통과");}
			
		});
		
		
		
		
	}); // $(function(){
</script> 
</div>
</body>

<%@ include file="../inc/popol_footer.jsp" %>