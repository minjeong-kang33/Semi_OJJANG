<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.itwillbs.report.db.ReportDTO"%>
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
function fun3() {
	if(document.scfr.info.value=="") {
		alert("검색목록을 선택하세요")
		document.scfr.info.focus();
		return;
	}
	if(document.scfr.search.value==0) {
		alert("검색어를 입력하세요");
		document.scfr.search.focus();
		return;
		}
		document.scfr.submit();
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
    
	<!-- ***** 신고회원목록조회 ***** -->    
	<%
	request.setCharacterEncoding("utf-8");
	ReportDTO dto=new ReportDTO();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

	ArrayList<ReportDTO> adUserReportList=(ArrayList<ReportDTO>)request.getAttribute("adUserReportList");
	int currentPage=(Integer)request.getAttribute("currentPage");
	int startPage=(Integer)request.getAttribute("startPage");
	int pageBlock=(Integer)request.getAttribute("pageBlock");
	int endPage=(Integer)request.getAttribute("endPage");
	int pageCount=(Integer)request.getAttribute("pageCount");
	int adUserReportCount=(Integer)request.getAttribute("adUserReportCount");
	String info=(String)request.getAttribute("info");
	String infoD=(String)request.getAttribute("infoD");
	String search=(String)request.getAttribute("search");
	%>
	
<section class="section" id="products">

		<!-- 게시판 제목  -->
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-heading">
						<h3><b>신고회원 목록</b></h3>
						<span>reported user list</span>
					</div>
				</div>
			</div>
		</div>

	<div class="container">
		
	<div class="col-lg-12">
		<div class="ad-divsearch">
			<form action="AdUserReportList.ad" method="get" name="scfr">
				<ul><li>
					<div class="ad-search">
						<select class="select-search" name="info">
							<option value="">선택</option>
							<option value="R_id">피신고자ID</option>
							<option value="M_id">신고자ID</option>
						</select>
						<input class="input-search" type="text" name="search">
						<input class="button-search" type="button" value="검색" onclick="fun3()">
					</div>
				</li></ul>
			</form>
		</div>
	</div>
	
<form name="ckDelete" action="AdUserReportDelete.ad" method="post">

		<div class="ad-count">
			<%
			if(info==null&&search==null) {
				%>
				총 <b><%=adUserReportCount %></b>명
				<%
			}else {
				%>
				<%=infoD %> ▶ <b><%=search %></b><br>
				검색결과 : <b><%=adUserReportCount %></b>명
				<%
			}
			%>
		</div>
		
		<div class="container" style=" width:100%; padding: 0;">
			<div class="row">
				<div class="col-lg-4">
					<div class="item" style="padding:0;">

						<!-- board list area -->
						<div id="board-list" class="board-list">
							<table class="board-table" style="float: left; margin-bottom: 30px;">
								<thead>
									<tr>
										<th scope="col">번호</th>
										<th scope="col">피신고자ID</th>
										<th scope="col">신고사유</th>
										<th scope="col" class="th-title">기타사유</th>
										<th scope="col">카테고리</th>
										<th scope="col">내용</th>
										<th scope="col">신고날짜</th>
										<th scope="col">신고자ID</th>
										<th scope="col">강퇴</th>
									</tr>
								</thead>

								<tbody>
									<%
									for(int i=0;i<adUserReportList.size();i++){
										dto=adUserReportList.get(i);
										%>
									<tr>
										<td><%=i+1 %></td>
										<td><%=dto.getR_id() %></td>
										<td><%=dto.getR_type() %></td>
										<td><%=dto.getR_reason() %></td>
										<td><%=dto.getR_category() %></td>
										<td><%=dto.getR_title() %></td>
										<td><%=dateFormat.format(dto.getR_date()) %></td>
										<td><%=dto.getM_id() %></td>
									<%
									if("강퇴".equals(dto.getM_play())) {
									%>
										<td><span class="ad-out">강퇴완료</span></td>
									<%
									}else {
									%>
										<td><input class="ad-report" type="button" value="강퇴하기"
													onclick="location.href='AdUserReportDelete.ad?R_id=<%=dto.getR_id() %>&R_type=<%=dto.getR_type() %>'">
										</td>
									<%
									}
									}
									%>
									</tr>
								</tbody>
							</table>

	<!-- *** 페이징 *** -->
	<%
	if(info==null&&search==null) {
		if(startPage > pageBlock){
			%>
			<a href="AdUserReportList.ad?pageNum=<%=startPage-pageBlock%>">◁◁ </a>
			<%
			}
		if(currentPage>1) {
			%>
			<a href="AdUserReportList.ad?pageNum=<%=currentPage-1 %>">◀</a>
			<%
			}
		for(int i=startPage;i<=endPage;i++){
			%>
			<a href="AdUserReportList.ad?pageNum=<%=i %>"><%=i %></a>
			<%
			}
		if(currentPage<pageCount) {
			%>
			<a href="AdUserReportList.ad?pageNum=<%=currentPage+1 %>">▶</a>
			<%
			}
		if(endPage < pageCount){
			%>
			<a href="AdUserReportList.ad?pageNum=<%=startPage+pageBlock%>"> ▷▷</a>
			<%
		}
	}else {
		if(startPage > pageBlock){
			%>
			<a href="AdUserReportList.ad?pageNum=<%=startPage-pageBlock%>&info=<%=info %>&search=<%=search %>">◁◁ </a>
			<%
			}
		if(currentPage>1) {
			%>
			<a href="AdUserReportList.ad?pageNum=<%=currentPage-1 %>&info=<%=info %>&search=<%=search %>">◀</a>
			<%
			}
		for(int i=startPage;i<=endPage;i++){
			%>
			<a href="AdUserReportList.ad?pageNum=<%=i %>&info=<%=info %>&search=<%=search %>"><%=i %></a>
			<%
			}
		if(currentPage<pageCount) {
			%>
			<a href="AdUserReportList.ad?pageNum=<%=currentPage+1 %>&info=<%=info %>&search=<%=search %>">▶</a>
			<%
			}
		if(endPage < pageCount){
			%>
			<a href="AdUserReportList.ad?pageNum=<%=startPage+pageBlock%>&info=<%=info %>&search=<%=search %>"> ▷▷</a>
			<%
		}
	}
	%>
	<!-- *** 페이징 끝 *** -->
						</div>
					  </div>
					</div>
				</div>
			</div>
		</form>
	</div>
</section>
    <!-- ***** 신고회원목록조회 끝 ***** -->
    
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