<%@page import="com.itwillbs.admin.db.MypageDAO"%>
<%@page import="com.itwillbs.buy.db.BuyDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
    
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>중고의류거래: 옺장</title>
   <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/font-awesome.css">
    <link rel="stylesheet" href="../assets/css/templatemo-hexashop.css">
    <link rel="stylesheet" href="../assets/css/owl-carousel.css">
    <link rel="stylesheet" href="../assets/css/lightbox.css"> 
<meta charset="UTF-8">
<title>중고 의류거래: 옺장</title>
</head>
<body>
    <body>
     <!-- ***** 헤더 ***** -->
  <jsp:include page="../top.jsp" />
    <!-- ***** 헤더 끝 ***** -->
    
    <div class="page-heading about-page-heading" id="top">
        <div class="container">
             <div class="inner-content2">
            
 <!-- ***** 작성글 조회(구매) 시작 ***** -->
    
    <h3>구매글 조회</h3>
<%
String M_id=(String)session.getAttribute("M_id");
SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");

int currentPage=(Integer)request.getAttribute("currentPage");
int startPage=(Integer)request.getAttribute("startPage");
int pageBlock=(Integer)request.getAttribute("pageBlock");
int endPage=(Integer)request.getAttribute("endPage");
int pageCount=(Integer)request.getAttribute("pageCount");

ArrayList<BuyDTO> buyList=(ArrayList<BuyDTO>)request.getAttribute("buyList");

%>	
<section>
<table border="1">
<tr><td>판매글제목</td><td>판매가격</td><td>내용</td><td>카테고리</td><td>좋아요 수</td><td>업로드 날짜</td></tr>
<%
for(int i=0;i<buyList.size();i++){
	BuyDTO dto=buyList.get(i);	
%>
	<tr>	
		<td><a href="BuyDetails.buy?B_num=<%=dto.getB_num() %>">
		<%=dto.getB_title() %></a></td>	
		<td><%=dto.getB_text() %></td>
		<td><%=dto.getB_category() %></td>
		<td><%=dto.getB_img() %>
		<td><%=dto.getB_view() %>	
		
	</tr>

<%
}
%>
	</table>
<%
if(currentPage > 1){
	%>
	<a href="WriteHistoryB.moi?pageNum=<%=currentPage-1%>">[1페이지 이전]</a>
	<%
}

for(int i=startPage;i<=endPage;i++){
	%>
	<a href="WriteHistoryB.moi?pageNum=<%=i%>"><%=i %></a> 
	<%
}
if(currentPage < pageCount){
	%>
	<a href="WriteHistoryB.moi?pageNum=<%=currentPage+1%>">[1페이지 다음]</a>
	<%
}

%>
</section>
	<!-- ***** 작성글 조회(구매) 끝 ***** -->
	       
             </div>
        </div>
    </div>     <!-- ***** 푸터 시작 ***** -->
   <jsp:include page="../bottom.jsp" />
    <!-- ***** 푸터 끝 ***** -->

 <!-- jQuery -->
    <script src="../assets/js/jquery-2.1.0.min.js"></script>

 <!--  Bootstrap -->
    <script src="../assets/js/popper.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>

 <!-- Plugins -->
    <script src="../assets/js/owl-carousel.js"></script>
    <script src="../assets/js/accordions.js"></script>
    <script src="../assets/js/datepicker.js"></script>
    <script src="../assets/js/scrollreveal.min.js"></script>
    <script src="../assets/js/waypoints.min.js"></script>
    <script src="../assets/js/jquery.counterup.min.js"></script>
    <script src="../assets/js/imgfix.min.js"></script> 
    <script src="../assets/js/slick.js"></script> 
    <script src="../assets/js/lightbox.js"></script> 
    <script src="../assets/js/isotope.js"></script> 
    
<!-- Global Init -->
    <script src="../assets/js/custom.js"></script>

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