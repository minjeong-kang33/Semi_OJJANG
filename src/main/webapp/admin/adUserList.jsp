<%@page import="com.itwillbs.member.db.MemberDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %>
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
<title>중고 의류거래: 옺장</title>
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
  <jsp:include page="../top.jsp" />
    <!-- ***** 헤더 끝 ***** -->

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
						<h3><b>일반회원 목록</b></h3>
						<span>general user list</span>
					</div>
				</div>
			</div>
		</div>

	<div class="container">
		
	<div class="col-lg-12">
		<div class="ad-divsearch">
			<form action="AdUserList.ad" method="get" name="scfr">
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
	
<form name="ckDelete" action="AdUserDelete.ad" method="post">

	<div class="ad-count">
		<%
		if(info==null&&search==null) {
			%>
			총 <b><%=adUserCount %></b>명
			<%
		}else {
			%>
			<%=infoD %> ▶ <b><%=search %></b><br>
			검색결과 : <b><%=adUserCount %></b>명
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
										<th scope="col" class="th-num"><input type="checkbox" id="ckAll" name="ckAll" onclick="fun2()"></th>
										<th scope="col" class="th-num">번호</th>
										<th scope="col" class="th-writer">아이디</th>
										<th scope="col" class="th-writer">이름</th>
										<th scope="col" class="th-writer">닉네임</th>
										<th scope="col" class="th-date">가입날짜</th>
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
										</tr>
									<%
									}
									%>
								</tbody>
							</table>
						
	<!-- *** 페이징 *** -->
	<div>
	<div class="ad-page">
	<%
	if(info==null&&search==null) {
		if(startPage > pageBlock){
			%>
			<a href="AdUserList.ad?pageNum=<%=startPage-pageBlock%>" >◁◁ </a>
			<%
			}
		if(currentPage>1) {
			%>
			<a href="AdUserList.ad?pageNum=<%=currentPage-1 %>">◀</a>
			<%
			}
		for(int i=startPage;i<=endPage;i++){
			%>
			<a href="AdUserList.ad?pageNum=<%=i %>"><%=i %></a>
			<%
			}
		if(currentPage<pageCount) {
			%>
			<a href="AdUserList.ad?pageNum=<%=currentPage+1 %>">▶</a>
			<%
			}
		if(endPage < pageCount){
			%>
			<a href="AdUserList.ad?pageNum=<%=startPage+pageBlock%>"> ▷▷</a>
			<%
		}
	}else {
		if(startPage > pageBlock){
			%>
			<a href="AdUserList.ad?pageNum=<%=startPage-pageBlock%>&info=<%=info %>&search=<%=search %>">◁◁ </a>
			<%
			}
		if(currentPage>1) {
			%>
			<a href="AdUserList.ad?pageNum=<%=currentPage-1 %>&info=<%=info %>&search=<%=search %>">◀</a>
			<%
			}
		for(int i=startPage;i<=endPage;i++){
			%>
			<a href="AdUserList.ad?pageNum=<%=i %>&info=<%=info %>&search=<%=search %>"><%=i %></a>
			<%
			}
		if(currentPage<pageCount) {
			%>
			<a href="AdUserList.ad?pageNum=<%=currentPage+1 %>&info=<%=info %>&search=<%=search %>">▶</a>
			<%
			}
		if(endPage < pageCount){
			%>
			<a href="AdUserList.ad?pageNum=<%=startPage+pageBlock%>&info=<%=info %>&search=<%=search %>"> ▷▷</a>
			<%
		}
	}
	%>
	</div>
	<!-- *** 페이징 끝 *** -->
	
							<!-- 	글 작성 버튼을 오른쪽 아래에 고정 -->
						<div>
							<input type="button" class="ad-btn" value="강퇴" onclick="fun1()">
						</div>
					 </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
	</div>
	</section>



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