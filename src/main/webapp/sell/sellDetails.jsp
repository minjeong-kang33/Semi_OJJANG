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
<link href="assets/css/sellDetails.css" rel="stylesheet" type="text/css">
<link href="assets/css/buy.css" rel="stylesheet" type="text/css">
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
	<jsp:include page="../top.jsp" />
	<!-- ***** 헤더 끝 ***** -->

	<%
	/* int S_num = Integer.parseInt(request.getParameter("S_num"));
	SellDAO dao = new SellDAO();
	SellDTO dto = dao.getSellBoard(S_num); */
	String M_id = (String) session.getAttribute("M_id");
	SellDTO dto = (SellDTO) request.getAttribute("dto");
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm");
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
					
					<table style="text-align: center; border: 1px solid black;">
					<tr><td rowspan="10"><img src="img/sell/<%=dto.getS_img() %>" width=300px class="goodsImg" ></td></tr>
					<tr><td colspan="2"><%=dto.getS_category()%></td>
					<!-- 하트 일단 대충 첨부해둠.. S_like랑 안연결됨 -->
						<td align="right" class="like_id"><input type="image" name="button"  class="heart" src="sell/heart.png" onclick="hartToggle()"></td></tr>
					<tr><td colspan="2" style="border-bottom: 1px;"><%=dto.getS_title()%></td></tr>
					<tr><td>작성자</td><td><%=dto.getM_id()%></td></tr>
					<tr><td>판매가</td><td><%=dto.getS_price()%></td></tr>
					<!-- 솔직히 rowspan, colspan 대충 함. 알아서 맞춰 -->
					<!-- 조회수, 거래방법, (주소), 작성일도 어딘가에 넣어야함 -->
					<tr><td>test</td></tr>
					<tr><td>test</td></tr>
					<tr><td>test</td></tr>
					<tr><td>글내용</td></tr>
					<tr><td colspan="2"><%=dto.getS_text()%></td></tr>
					
					</table>
					<!--보내지는 내용 숨겨지도록(post) 작성한 글을 writeAction으로 보냄 -->
<!-- 					<table class="table table-stripe"
						style="text-align: center;" > -->
<!-- 						<colgroup>
							<col style="width: 601px">
							<col style="width: 101px">
							<col style="width: 301px">
						</colgroup> -->
<%-- 							<tr>
								<td rowspan="7"
									style="text-align: center"><%=dto.getS_title()%></td>
							</tr>
							<tr>
								<td rowspan="7"><img src="img/sell/<%=dto.getS_img() %>" width=300px height=300px class="goodsImg"></td>
							</tr>
							<tr>
								<td>작성자</td>
								<td><%=dto.getM_id()%></td>
							</tr>
							<tr>
								<td>카테고리</td>
								<td><%=dto.getS_category()%></td>
							</tr>
							<tr>
								<td>거래유형</td>
								<td>
									<%
									if (dto.getS_send1() != null) {
									%> <%="택배거래<br>"%> <%
 }
 %> <%
 if (dto.getS_send2() != null) {
 %> <%="(" + dto.getS_sido1() + ")<br>직거래"%> <%
 }
 %>
								</td>
							</tr>
							<tr>
								<td>조회수</td>
								<td><%=dto.getS_view()%></td>
							</tr>
							<tr>
								<td>작성일자</td>
								<td><%=dateFormat.format(dto.getS_createdate())%></td>
							</tr>
							<tr>
								<td height="150">글내용</td>
								<td><%=dto.getS_text()%></td>
							</tr>
					</table> --%>
				</div>
			</div>
		</div>
	</section>
	<div class="btn-naran">
		<%
		if (M_id != null) {
			// 세션값=id와 글쓴이가 일치해야만 글수정, 글삭제 표시
			if (M_id.equals(dto.getM_id())) {
		%>
		<input type="button" class="btn btn-dark" value="글수정"
			onclick="location.href='SellEditForm.sell?S_num=<%=dto.getS_num()%>'">
		<input type="button" class="btn btn-dark" value="글삭제"
			onclick="location.href='SellDelete.sell?S_num=<%=dto.getS_num()%>'">
		<%
		}
		}
		%>
		<%
		if (M_id != null) {
			// 세션값=id와 글쓴이가 일치해야만 글수정, 글삭제 표시
			if (M_id.equals("admin")) {
		%>
		<input type="button" class="btn btn-dark" value="글삭제"
			onclick="location.href='SellDelete.sell?S_num=<%=dto.getS_num()%>'">
		<%
		}
		}
		%>
		<button type="button" class="btn btn-dark"
			onclick="fun1('<%=dto.getM_id()%>','<%=dto.getS_num()%>','sell','<%=dto.getS_title()%>')"
			style="float: right">신고하기</button>
		<button type="button" class="btn btn-dark" onclick="history.back()"
			style="float: right">글목록</button>
		<button type="button" class="btn btn-dark" onclick="location.href='LikePro.like?S_num=<%=dto.getS_num() %>'">찜하기</button>


	</div>

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