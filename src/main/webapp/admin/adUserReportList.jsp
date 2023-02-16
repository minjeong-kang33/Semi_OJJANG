<%@page import="com.itwillbs.member.db.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta charset="UTF-8">
</head>
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
<body>
    <!-- ***** 헤더 ***** -->
  <jsp:include page="../admin_top.jsp" />
    <!-- ***** 헤더 끝 ***** -->
    
	<!-- ***** 신고회원목록조회 ***** -->
    <div class="page-heading about-page-heading" id="top">
        <div class="container">
             <div class="inner-content2">
             
<h3>신고회원목록조회</h3>
<%
request.setCharacterEncoding("utf-8");
MemberDTO dto=new MemberDTO();
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

ArrayList<MemberDTO> adUserReportList=(ArrayList<MemberDTO>)request.getAttribute("adUserReportList");

int currentPage=(Integer)request.getAttribute("currentPage");
int startPage=(Integer)request.getAttribute("startPage");
int pageBlock=(Integer)request.getAttribute("pageBlock");
int endPage=(Integer)request.getAttribute("endPage");
int pageCount=(Integer)request.getAttribute("pageCount");
int adUserReportCount=(Integer)request.getAttribute("adUserReportCount");
%>
<section>
<div class="container">
	<div>
	<form action="AdUserReportListPro.ad" method="post" name="scfr">
		<ul>
		<li>
		<select name="info">
		<option value="">선택</option>
		<option value="M_id">아이디</option>
		<option value="M_name">이름</option>
		<option value="M_nick">닉네임</option>
		</select>
		<input type="text" name="search"> <input type="button" value="검색" onclick="fun3()"></li>
		</ul><br>
	</form>
	</div>
		<div>
		총 멤버 <%=adUserReportCount %>명
		</div>
<form name="ckDelete" action="AdUserReportDelete.ad" method="post">
<table border="1">
<tr><td><input type="checkbox" id="ckAll" name="ckAll" onclick="fun2()"></td><td>번호</td><td>아이디</td><td>이름</td><td>닉네임</td><td>가입날짜</td><td>상태</td></tr>
<%
for(int i=0;i<adUserReportList.size();i++){
	dto=adUserReportList.get(i);
%>
	<tr><td><input type="checkbox" id="ck" name="ck" value="<%=dto.getM_id() %>"></td>
		<td><%=i+1 %></td>
		<td><%=dto.getM_id() %></td>
		<td><%=dto.getM_name() %></td>
		<td><%=dto.getM_nick() %></td>
		<td><%=dateFormat.format(dto.getM_createdate()) %></td>
		<td><%=dto.getM_play() %></td></tr>
<%
}
%>
</table>
<%
for(int i=startPage;i<=endPage;i++){
if(startPage > pageBlock){
%>
<a href="AdUserReportList.ad?pageNum=<%=startPage-pageBlock%>">[10페이지 이전]</a>
<%
}
%>
<a href="AdUserReportList.ad?pageNum=<%=i %>"><%=i %></a>
<%
}
if(endPage < pageCount){
%>
<a href="AdUserReportList.ad?pageNum=<%=startPage+pageBlock%>">[10페이지 다음]</a>
<%
}
%>
<div>
회원 처리 <input type="button" value="강퇴" onclick="fun1()">
</div>
</form>
</div>
</section>
             </div>
        </div>
    </div>
    <!-- ***** 신고회원목록조회 끝 ***** -->
    
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