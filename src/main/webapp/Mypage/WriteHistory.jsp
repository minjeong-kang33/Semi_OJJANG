<%@page import="com.itwillbs.sell.db.SellDTO"%>
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
            
 <!-- ***** 판매내역조회***** -->
    
    <h3>구매글내역조회</h3> <a href="WritehistoryB.moi">더보기</a>
<%
String M_id=(String)session.getAttribute("M_id");

BuyDTO dto=new BuyDTO();
MypageDAO dao=new MypageDAO();
SellDTO sdto=new SellDTO();

ArrayList<BuyDTO> WriteHistoryB2=dao.WriteHistoryB2(M_id);
// ArrayList<BuyDTO> WriteHistoryB2=(ArrayList<BuyDTO>)request.getAttribute("WriteHistoryB2");

SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");
%>	
<section>
<table border="1"> 
<tr><td>구매글제목</td><td>내용</td><td>카테고리</td><td>이미지</td><td>조회수</td></tr>

<%
// System.out.println(dealListS.size());
// System.out.println(dealListB.size());
for(int i=0;i<WriteHistoryB2.size();i++){
	dto=WriteHistoryB2.get(i);
	
%>

	<tr>	
		<td><a href="../buy/buyDetails.jsp?B_num=<%=dto.getB_num() %>">
		<%=dto.getB_title() %></a></td>	
		<td><%=dto.getB_text() %></td>
		<td><%=dto.getB_category() %></td>
		<td><%=dto.getB_img() %>
		<td><%=dto.getB_view() %>	
<%-- 		<td><%=dateFormat.format(dto.getB_time()) %></td> --%>
	</tr>

<%
}
%>
	</table>
	
</section>
	    <h3>판매글조회</h3> <a href="WriteHistoryS.moi">더보기</a>
<%

ArrayList<SellDTO> WriteHistoryS2=dao.WriteHistoryS2(M_id);
// ArrayList<SellDTO> WriteHistoryS2=(ArrayList<SellDTO>)request.getAttribute("WriteHistoryS2");

%>	
<section>
<table border="1">
<tr><td>판매글제목</td><td>판매가격</td><td>내용</td><td>카테고리</td><td>좋아요 수</td><td>업로드 날짜</td></tr>

<%
// System.out.println(dealListS.size());
// System.out.println(dealListB.size());
for(int i=0;i<WriteHistoryS2.size();i++){
	sdto=WriteHistoryS2.get(i);
	
%>
	<tr>		
		<td><a href="../sell/sellDetails.jsp?S_num=<%=sdto.getS_num() %>">
		<%=sdto.getS_title() %></a></td>
		<td><%=sdto.getS_price() %></td>
		<td><%=sdto.getS_text() %></td>		
		<td><%=sdto.getS_category() %></td>
		<td><%=sdto.getS_like() %></td>
		<td><%=dateFormat.format(sdto.getS_createdate()) %></td>
		
		
	</tr>

<%
}
%>
	</table>
</section>
	
	
	<!-- ***** 판매내역조회 끝 ***** -->
	       
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