<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.itwillbs.sell.db.SellDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>중고의류거래: 옺장</title>
   <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-hexashop.css">
    <link rel="stylesheet" href="assets/css/owl-carousel.css">
    <link rel="stylesheet" href="assets/css/lightbox.css">
    <link href="assets/css/admin.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
</head>

    <!-- ***** 스크립트 ***** -->
<script>
function fun1() {
	let check = false;
	with(document.ckDelete) {
		if(ck.length==undefined) {
			if(ck.checked) { check = true; }
		} else {
			for(let i=0;i<ck.length;i++) {
				if(ck[i].checked) { check = true; } }
		} if(!check) {
		alert("삭제할 게시글을 선택하세요");
			return;
		} else {
			if(confirm("삭제처리 하시겠습니까?")) { submit(); }
		} } }

function fun2() {
	if($("input:checked[id='ckAll']").prop("checked")) {
	 $("input[type=checkbox]").prop("checked", true); 
	}else {
	 $("input[type=checkbox]").prop("checked", false); 
	}
}
</script>
    <!-- ***** 스크립트 끝 ***** -->
    
<body>
	<!-- ***** 로딩 일단 지금은 비어있음***** -->
	<div id="preloader">
		<div class="jumper">
			<div></div>
			<div></div>
			<div></div>
		</div>
	</div>
	
    <!-- ***** 헤더 ***** -->
  <jsp:include page="../top.jsp" />
    <!-- ***** 헤더 끝 ***** -->
    
	<!-- ***** 판매글목록조회 ***** -->
	<%
	SellDTO dto=new SellDTO();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

	ArrayList<SellDTO> adSellList=(ArrayList<SellDTO>)request.getAttribute("adSellList");

	int currentPage=(Integer)request.getAttribute("currentPage");
	int startPage=(Integer)request.getAttribute("startPage");
	int pageBlock=(Integer)request.getAttribute("pageBlock");
	int endPage=(Integer)request.getAttribute("endPage");
	int pageCount=(Integer)request.getAttribute("pageCount");
	int adSellCount=(Integer)request.getAttribute("adSellCount");
	%>
	
<section class="section" id="products">

		<!-- 게시판 제목  -->
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-heading">
						<h3>판매글 목록 조회</h3>
						<span></span>
					</div>
				</div>
			</div>
		</div>

	<div class="container">
	
	<div class="ad-count">
		총 게시글 <b><%=adSellCount %></b>개
	</div>
		
		<form name="ckDelete" action="AdSellDelete.ad" method="post">
		<table border="1">
			<thead>
				<tr>
					<th scope="col"><input type="checkbox" id="ckAll" name="ckAll" onclick="fun2()"></th>
					<th scope="col">판매번호</th>
					<th scope="col">카테고리</th>
					<th scope="col">아이디</th>
					<th scope="col">제목</th>
					<th scope="col">가격</th>
					<th scope="col">날짜</th>
				</tr>
			</thead>
	
			<tbody>
				<%
				for(int i=0;i<adSellList.size();i++){
					dto=adSellList.get(i);
				%>
				<tr>
					<td><input type="checkbox" id="ck" name="ck" value="<%=dto.getS_num() %>"></td>
					<td><%=dto.getS_num() %></td>
					<td><%=dto.getS_category() %></td>
					<td><%=dto.getM_id() %></td>
					<td><a href="SellDetails.sell?S_num=<%=dto.getS_num() %>"><%=dto.getS_title() %></a></td>
					<td><%=dto.getS_price() %></td>
					<td><%=dateFormat.format(dto.getS_createdate()) %></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

	<!-- *** 페이징 *** -->
	<%
	if(startPage > pageBlock){
		%>
		<a href="AdSellList.ad?pageNum=<%=startPage-pageBlock%>">[10페이지 이전]</a>
		<%
		}
	if(currentPage>1) {
		%>
		<a href="AdSellList.ad?pageNum=<%=currentPage-1 %>">[1페이지 이전]</a>
		<%
		}
	for(int i=startPage;i<=endPage;i++){
		%>
		<a href="AdSellList.ad?pageNum=<%=i %>"><%=i %></a>
		<%
		}
	if(currentPage<pageCount) {
		%>
		<a href="AdSellList.ad?pageNum=<%=currentPage+1 %>">[1페이지 다음]</a>
		<%
		}
	if(endPage < pageCount){
		%>
		<a href="AdSellList.ad?pageNum=<%=startPage+pageBlock%>">[10페이지 다음]</a>
		<%
		}
	%>
	<!-- *** 페이징 끝 *** -->

	<div class="ad-right">
		게시글 처리 <input type="button" value="삭제" onclick="fun1()">
	</div>

		</form>
	</div>
</section>
    <!-- ***** 판매글목록조회 끝 ***** -->
    
    <!-- ***** 푸터 시작 ***** -->
   <jsp:include page="../bottom.jsp" />
    <!-- ***** 푸터 끝 ***** -->

 <!-- jQuery -->
    <script src="assets/js/jquery-2.1.0.min.js"></script>

 <!--  Bootstrap -->
    <script src="assets/js/popper.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

 <!-- Plugins -->
    <script src="assets/js/owl-carousel.js"></script>
    <script src="assets/js/accordions.js"></script>
    <script src="assets/js/datepicker.js"></script>
    <script src="assets/js/scrollreveal.min.js"></script>
    <script src="assets/js/waypoints.min.js"></script>
    <script src="assets/js/jquery.counterup.min.js"></script>
    <script src="assets/js/imgfix.min.js"></script> 
    <script src="assets/js/slick.js"></script> 
    <script src="assets/js/lightbox.js"></script> 
    <script src="assets/js/isotope.js"></script> 
    
<!-- Global Init -->
    <script src="assets/js/custom.js"></script>

    <script>

        $(function() {
            var selectedClass = "";
            $("p").click(function(){
            selectedClass = $(this).attr("data-rel");
            $("#portfolio").fadeTo(50, 0.1);
                $("#portfolio div").not("."+selectedClass).fadeOut();
            setTimeout(function() {
              $("."+selectedClass).fadeIn();
              $("#portfolio").fadeTo(50, 1);
            }, 500);
                
            });
        });

    </script>
</body>
</html>