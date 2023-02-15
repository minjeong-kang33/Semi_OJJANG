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
            
 <!-- ***** 찜목록 조회 ***** -->
    
    <h3>찜목록 조회</h3>
<%
String M_id=(String)session.getAttribute("M_id");
// LikeDTO dto=new LikeDTO();
SellDTO dto=new SellDTO();
MypageDAO dao=new MypageDAO();

ArrayList<SellDTO> likeHistory=dao.likeHistory(M_id);
// SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");
%>	
<section>
<table border="1">
<tr><td>판매자</td><td>카테고리</td><td>글제목</td><td>내용</td><td>가격</td></tr>

<%
// System.out.println(dealList.size());
// System.out.println(dealListB.size());
for(int i=0;i<likeHistory.size();i++){
 	dto=likeHistory.get(i);
%>
	<tr>
		<td><%=dto.getM_id() %></td>
		<td><%=dto.getS_category() %></td>
		<td><a href="../sell/sellDetails.jsp?S_num=<%=dto.getS_num() %>">
		<%=dto.getS_title() %></a></td>
		<td><%=dto.getS_text() %></td>
		<td><%=dto.getS_price() %></td>
	</tr>
	
<%
}
%>
</table>
</section>
	<!-- ***** 찜목록조회 끝 ***** -->
	       
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