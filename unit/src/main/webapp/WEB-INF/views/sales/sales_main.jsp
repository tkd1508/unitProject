<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/popol_header.jsp" %>
<style>
.ksw_main {
    margin-top: -28px;
}

.salseimg img {width:100%; height: 170px;}

  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
    width: 100%;
    height: 400px;
    /* margin: auto; */
  }
.ksw_main   .col-sm-3 {  height: 190px; margin-top: 66px; }
.ksw_main   .salsetitle a {
    color: #333;
    font-weight: bold;
    font-size: 20px;
    margin-left: 18px;
}
.salsetitle {
    margin-top: 10px;
}
.ksw_main   .salseprice {
    text-align: right;
    font-weight: bold;
    font-size: 16px;
    margin-right: 18px;
}
.pagination {
    display: inline-block;
    padding-left: 0;
    margin: 78px 0px 20px 0;
    border-radius: 4px;
}
  </style>
<body>

<div class="container panel panel-info">

<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src="${pageContext.request.contextPath}/imgs/main001.png" alt="이미지1" width="460" height="345">
        <div class="carousel-caption">
        </div>
      </div>

      <div class="item">
        <img src="${pageContext.request.contextPath}/imgs/main003.png" alt="이미지2" width="460" height="345">
        <div class="carousel-caption">
        </div>
      </div>
    
      <div class="item">
        <img src="${pageContext.request.contextPath}/imgs/main002.png" alt="이미지3" width="460" height="345">
        <div class="carousel-caption">
        </div>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<!-- 메인 -->


<div class = "ksw_main">
<c:forEach var="dto" items="${main}" varStatus="status"> 
    <div class = "col-sm-3">
    <div class="salseimg "><a href="${pageContext.request.contextPath}/talentSales/selectOne?salesNum=${dto.salesNum}" title="상세페이지로 이동"><img src="${pageContext.request.contextPath}/resources/upload/${dto.salesImg}" alt=""/></a></div>
    <div class="salsetitle"><a href="${pageContext.request.contextPath}/talentSales/selectOne?salesNum=${dto.salesNum}" title="상세페이지로 이동">${dto.salesTitle}</a></div>
    <div class="salseprice ">${dto.salesPrice} 원</div>
	</div>	
</c:forEach>
</div>
	<div colspan="5" style="text-align: center;">

		<ul class="pagination">
			
			<c:if test="${paging.startBtn >= paging.bottomlist }">
			<li><a href="${pageContext.request.contextPath}/talentSales/main?pstartno=${(paging.startBtn-2)*paging.onepageLimit }">이전</a></li>
			</c:if>

			<c:forEach var="i" begin="${paging.startBtn}" end="${paging.endBtn}">
			<li <c:if test="${i==paging.currentBtn}">class="active"</c:if> > 
			<a href="${pageContext.request.contextPath}/talentSales/main?pstartno=${(i-1)*paging.onepageLimit}">${i}</a></li>
			</c:forEach>
			
			
			
			<c:if test="${paging.pageAll > paging.endBtn }">
			<li><a href="${pageContext.request.contextPath}/talentSales/main?pstartno=${paging.endBtn*paging.onepageLimit}">다음</a></li>
			</c:if>
		</ul>
	</div>



</div> <!-- 맨 처음 DB -->

</body>

<%@ include file="../inc/popol_footer.jsp" %>