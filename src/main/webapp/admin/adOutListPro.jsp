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
    
	<!-- ***** 탈퇴회원목록조회 ***** -->
	<%
	MemberDTO dto=new MemberDTO();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

	ArrayList<MemberDTO> adOutListPro=(ArrayList<MemberDTO>)request.getAttribute("adOutListPro");

	String info=(String)request.getAttribute("info");
	String search=(String)request.getAttribute("search");
	int adOutCount=(Integer)request.getAttribute("adOutCount");
	%>
	
<section class="section" id="products">

		<!-- 게시판 제목  -->
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-heading">
						<h3>탈퇴회원목록조회</h3>
						<span>User List</span>
					</div>
				</div>
			</div>
		</div>

	<div class="container">
		
	<div class="col-lg-12">
		<div class="ad-divsearch">
		<div class="ad-right">
			<form action="AdOutListPro.ad" method="post" name="scfr">
				<div class="ad-search">
					<ul class="select-list">
					<li>
						<select class="select-search" name="info">
							<option value="">선택</option>
							<option value="M_id">아이디</option>
							<option value="M_name">이름</option>
							<option value="M_nick">닉네임</option>
						</select>
						<input class="input-search" type="text" name="search">
						<input class="button-search" type="button" value="검색" onclick="fun3()">
					</li></ul><br>
				</div>
			</form>
		</div>
		</div>
	</div>

		<div class="ad-count">
			<%=info %>> <%=search %><br>
			검색결과 : <b><%=adOutListPro.size() %></b>명 / 총 <%=adOutCount %>명
		</div>
	
<table border="1">
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
		for(int i=0;i<adOutListPro.size();i++){
			dto=adOutListPro.get(i);
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
</div>
</section>
    <!-- ***** 탈퇴회원목록조회 끝 ***** -->
    
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