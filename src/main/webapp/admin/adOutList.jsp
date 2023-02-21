<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.itwillbs.member.db.MemberDTO"%>
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
    <!-- ***** 헤더 ***** -->
  <jsp:include page="../top.jsp" />
    <!-- ***** 헤더 끝 ***** -->
    
	<!-- ***** 탈퇴회원목록조회 ***** -->
	<%
	MemberDTO dto=new MemberDTO();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

	ArrayList<MemberDTO> adOutList=(ArrayList<MemberDTO>)request.getAttribute("adOutList");
	int currentPage=(Integer)request.getAttribute("currentPage");
	int startPage=(Integer)request.getAttribute("startPage");
	int pageBlock=(Integer)request.getAttribute("pageBlock");
	int endPage=(Integer)request.getAttribute("endPage");
	int pageCount=(Integer)request.getAttribute("pageCount");
	int adOutCount=(Integer)request.getAttribute("adOutCount");
	String info=(String)request.getAttribute("info");
	String search=(String)request.getAttribute("search");
	%>
	
<section class="section" id="products">

		<!-- 게시판 제목  -->
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-heading">
						<h3><b>탈퇴회원목록조회</b></h3>
						<span>Withdrawal User List</span>
					</div>
				</div>
			</div>
		</div>

	<div class="container">
		
	<div class="col-lg-12">
		<div class="ad-divsearch">
			<form action="AdOutList.ad" method="post" name="scfr">
				<ul><li>
					<div class="ad-search">
						<select class="select-search" name="info">
							<option value="">선택</option>
							<option value="M_id">아이디</option>
							<option value="M_name">이름</option>
							<option value="M_nick">닉네임</option>
						</select>
						<input class="input-search" type="text" name="search">
						<input class="button-search" type="button" value="검색" onclick="fun3()">
					</div>
				</li></ul>
			</form>
		</div>
	</div>
	
	<div class="ad-count">
		<%
		if(info==null&&search==null) {
			%>
			총 <b><%=adOutCount %></b>명
			<%
		}else {
			%>
			<%=info %> ▶ <b><%=search %></b><br>
			검색결과 : <b><%=adOutList.size() %></b>명
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
									<th scope="col">아이디</th>
									<th scope="col">이름</th>
									<th scope="col">닉네임</th>
									<th scope="col">가입날짜</th>
									<th scope="col">상태</th>
								</tr>
							</thead>
	
							<tbody>
								<%
								for(int i=0;i<adOutList.size();i++){
									dto=adOutList.get(i);
								%>
							<tr>
								<td><%=i+1 %></td>
								<td><%=dto.getM_id() %></td>
								<td><%=dto.getM_name() %></td>
								<td><%=dto.getM_nick() %></td>
								<td><%=dateFormat.format(dto.getM_createdate()) %></td>
								<td><%=dto.getM_play() %></td>
							</tr>
							<%
							}
							%>
							</tbody>
						</table>

	<!-- *** 페이징 *** -->
	<%
	if(info==null&&search==null) {
		if(startPage > pageBlock){
			%>
			<a href="AdOutList.ad?pageNum=<%=startPage-pageBlock%>">◁◁ </a>
			<%
			}
		if(currentPage>1) {
			%>
			<a href="AdOutList.ad?pageNum=<%=currentPage-1 %>">◀</a>
			<%
			}
		for(int i=startPage;i<=endPage;i++){
			%>
			<a href="AdOutList.ad?pageNum=<%=i %>"><%=i %></a>
			<%
			}
		if(currentPage<pageCount) {
			%>
			<a href="AdOutList.ad?pageNum=<%=currentPage+1 %>">▶</a>
			<%
			}
		if(endPage < pageCount){
			%>
			<a href="AdOutList.ad?pageNum=<%=startPage+pageBlock%>"> ▷▷</a>
			<%
		}
	}else {
		if(startPage > pageBlock){
			%>
			<a href="AdOutList.ad?pageNum=<%=startPage-pageBlock%>&search=<%=search %>">◁◁ </a>
			<%
			}
		if(currentPage>1) {
			%>
			<a href="AdOutList.ad?pageNum=<%=currentPage-1 %>&search=<%=search %>">◀</a>
			<%
			}
		for(int i=startPage;i<=endPage;i++){
			%>
			<a href="AdOutList.ad?pageNum=<%=i %>&search=<%=search %>"><%=i %></a>
			<%
			}
		if(currentPage<pageCount) {
			%>
			<a href="AdOutList.ad?pageNum=<%=currentPage+1 %>&search=<%=search %>">▶</a>
			<%
			}
		if(endPage < pageCount){
			%>
			<a href="AdOutList.ad?pageNum=<%=startPage+pageBlock%>&search=<%=search %>"> ▷▷</a>
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
	</div>
</section>
    <!-- ***** 탈퇴회원목록조회 끝 ***** -->
    
    <!-- ***** 푸터 시작 ***** -->
   <jsp:include page="../bottom.jsp" />
    <!-- ***** 푸터 끝 ***** -->

 <!-- jQuery -->
    <script src="/assets/js/jquery-2.1.0.min.js"></script>

 <!--  Bootstrap -->
    <script src="/assets/js/popper.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>

 <!-- Plugins -->
    <script src="/assets/js/owl-carousel.js"></script>
    <script src="/assets/js/accordions.js"></script>
    <script src="/assets/js/datepicker.js"></script>
    <script src="/assets/js/scrollreveal.min.js"></script>
    <script src="/assets/js/waypoints.min.js"></script>
    <script src="/assets/js/jquery.counterup.min.js"></script>
    <script src="/assets/js/imgfix.min.js"></script> 
    <script src="/assets/js/slick.js"></script> 
    <script src="/assets/js/lightbox.js"></script> 
    <script src="/assets/js/isotope.js"></script> 
    
<!-- Global Init -->
    <script src="/assets/js/custom.js"></script>

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