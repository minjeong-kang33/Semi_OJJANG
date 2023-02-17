<%@page import="com.itwillbs.sell.db.SellDTO"%>
<%@page import="com.itwillbs.sell.db.SellDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>중고의류거래: 옺장</title>
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="assets/css/font-awesome.css">
<link rel="stylesheet" href="assets/css/templatemo-hexashop.css">
<link rel="stylesheet" href="assets/css/owl-carousel.css">
<link rel="stylesheet" href="assets/css/lightbox.css">
<link href="assets/css/buy.css" rel="stylesheet" type="text/css">
<link href="assets/css/sellDetails.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>중고 의류거래: 옺장</title>
<script type="text/javascript">
function fun1(M_id, S_num, R_category, S_title) {
	   
    window.open("ReportForm.rpt?R_id=" + M_id + "&R_writeNum="
          + S_num + "&R_category=" + R_category + "&R_title=" + S_title,
          "pop", "width=520,height=340");
 }
</script>
</head>
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
	<jsp:include page="../admin_top.jsp" />
	<!-- ***** 헤더 끝 ***** -->

	<%
	/* int S_num = Integer.parseInt(request.getParameter("S_num"));
	SellDAO dao = new SellDAO();
	SellDTO dto = dao.getSellBoard(S_num); */
	String M_id = (String) session.getAttribute("M_id");
	SellDTO dto = (SellDTO) request.getAttribute("dto");
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
	%>
	<section class="section" id="products">
		<!-- 게시판 제목  -->
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="aa"></div>
					<div class="section-heading">
						<h2 style="margin-top: 180px">팝니다</h2>
						<span>sell</span>
					</div>
				 <!--  폼 추가했어요!!~!~!~!~!~!~! 데이터 넘기기 편하시라고.... -->
					
					
					<div class="item-box1">
					
					<!-- 상품이미지 -->
					<div class="item-img"> 
						<img src="img/sell/<%=dto.getS_img()%>" class="goodsImg">
					</div>
					
					
					<!-- 상품정보 -->
					<div class="item-info"> 
						<span class="info-category"> <%=dto.getS_category()%> </span> <br> <!--  카테고리 -->
						<span> <%=dto.getS_title()%> </span> <br> <!-- 글제목 -->
						<span> <%=dto.getS_price()%>원 </span> <br> <!-- 가격 -->
						
						<span>  <!--  좋아요, 찜하기 -->
							<%
									if(M_id != null){
										//글쓴이에게는 찜하기 안보임
										if(!M_id.equals(dto.getM_id())){
									%>
							<button type="button" onclick="location.href='LikePro.like?S_num=<%=dto.getS_num() %>'" class="heartbtn"><img src="sell/heart.png" alt="찜하기" class="heart"></button>
								<%
										}
									}
								%>
						</span> <br>
						
						
						<span> <!-- 거래방식  -->
							<% if(dto.getS_send1()!=null&&dto.getS_send2()!=null){%> <%= "<b>택배거래</b>, <b>직거래</b>"%><%}
													 else if(dto.getS_send1()!=null){%> <%= "<b>택배거래</b>"%><%}
													 else if(dto.getS_send2()!=null){%> <%= "<b>직거래</b>"%><%}%>
						</span> <br>
						
						<span> <!-- 거래지역 -->
							<% if(dto.getS_send2()!=null){%> <img src="sell/location_icon.png" class="location"><%= dto.getS_sido1()%> <%= dto.getS_gugun1()%><%} else { %>　<%}%>
						</span> <br>
						
						<span><%=dto.getM_id()%></span> <br>
						<span><%=dateFormat.format(dto.getS_createdate())%></span> <br>
						<span><img src="assets/images/eye.png" class="eye"><%=dto.getS_view() %></span> <br>
						
					</div>
					
		
					
					<!-- 판매 상세글 -->
					<div class="item-detail">
						<hr> <!-- 가로줄 -->
						 <%=dto.getS_text()%> 
					</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<div class="btn-naran">

		<input type="button" class="btn btn-dark" value="글삭제"
			onclick="location.href='SellDelete.sell?S_num=<%=dto.getS_num()%>'">

		<button type="button" class="btn btn-dark" onclick="history.back()"
			style="float: right">글목록</button>


	</div>

	<!-- ***** 푸터 시작 ***** -->
	<jsp:include page="../admin_bottom.jsp" />
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
			$("p").click(function() {
				selectedClass = $(this).attr("data-rel");
				$("#portfolio").fadeTo(50, 0.1);
				$("#portfolio div").not("." + selectedClass).fadeOut();
				setTimeout(function() {
					$("." + selectedClass).fadeIn();
					$("#portfolio").fadeTo(50, 1);
				}, 500);
			});
		});
	</script>



</body>
</html>