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
function fun1() {
	let check = false;
	with(document.ckDelete) {
		if(ck.length==undefined) {
			if(ck.checked) { check = true; }
		} else {
			for(let i=0;i<ck.length;i++) {
				if(ck[i].checked) { check = true; } }
		} if(!check) {
		alert("강퇴할 멤버를 선택하세요");
			return;
		} else {
			if(confirm("강퇴처리 하시겠습니까?")) { submit(); }
		} } }

function fun2() {
	if($("input:checked[id='ckAll']").prop("checked")) {
	 $("input[type=checkbox]").prop("checked", true); 
	}else {
	 $("input[type=checkbox]").prop("checked", false); 
	}
}

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
  <jsp:include page="../admin_top.jsp" />
    <!-- ***** 헤더 끝 ***** -->
    
	<!-- ***** 일반회원목록조회 ***** -->
	<%
	MemberDTO dto=new MemberDTO();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

	ArrayList<MemberDTO> adUserList=(ArrayList<MemberDTO>)request.getAttribute("adUserList");

	int currentPage=(Integer)request.getAttribute("currentPage");
	int startPage=(Integer)request.getAttribute("startPage");
	int pageBlock=(Integer)request.getAttribute("pageBlock");
	int endPage=(Integer)request.getAttribute("endPage");
	int pageCount=(Integer)request.getAttribute("pageCount");
	int adUserCount=(Integer)request.getAttribute("adUserCount");
	%>
	
<section class="section" id="products">

		<!-- 게시판 제목  -->
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-heading">
						<h3>일반회원목록조회</h3>
						<span>User List</span>
					</div>
				</div>
			</div>
		</div>

	<div class="container">
		
	<div class="col-lg-12">
		<div class="ad-divsearch">
		<div class="ad-right">
			<form action="AdUserListPro.ad" method="post" name="scfr">
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
	
<form name="ckDelete" action="AdUserDelete.ad" method="post">

	<div class="ad-count">
		총 멤버 <b><%=adUserCount %></b>명
	</div>

<table border="1">
	<thead>
		<tr>
			<th scope="col"><input type="checkbox" id="ckAll" name="ckAll" onclick="fun2()"></th>
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
		for(int i=0;i<adUserList.size();i++){
			dto=adUserList.get(i);
		%>
			<tr>
				<td><input type="checkbox" id="ck" name="ck" value="<%=dto.getM_id() %>"></td>
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
	if(startPage > pageBlock){
		%>
		<a href="AdUserList.ad?pageNum=<%=startPage-pageBlock%>">[10페이지 이전]</a>
		<%
		}
	if(currentPage>1) {
		%>
		<a href="AdUserList.ad?pageNum=<%=currentPage-1 %>">[1페이지 이전]</a>
		<%
		}
	for(int i=startPage;i<=endPage;i++){
		%>
		<a href="AdUserList.ad?pageNum=<%=i %>"><%=i %></a>
		<%
		}
	if(currentPage<pageCount) {
		%>
		<a href="AdUserList.ad?pageNum=<%=currentPage+1 %>">[1페이지 다음]</a>
		<%
		}
	if(endPage < pageCount){
		%>
		<a href="AdUserList.ad?pageNum=<%=startPage+pageBlock%>">[10페이지 다음]</a>
		<%
	}
	%>
	<!-- *** 페이징 끝 *** -->

	<div class="ad-right">
		회원 처리 <input type="button" value="강퇴" onclick="fun1()">
	</div>

		</form>
	</div>
</section>
	<!-- ***** 일반회원목록조회 끝 ***** -->
    
    	<!-- 게시판 내용 여기 넘어가면 안됨.  -->

    
    
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