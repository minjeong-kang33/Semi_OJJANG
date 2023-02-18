

<%@page import="com.itwillbs.deal.db.DealDAO"%>
<%@page import="com.itwillbs.deal.db.DealDTO"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
    
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
            
<!--  ***** 구매 요청자 조회 시작***** -->
    
    <h3>거래 희망자</h3>
<%
int S_num=Integer.parseInt(request.getParameter("S_num"));
String M_id=request.getParameter("M_id");
// MemberDTO dto=new MemberDTO();

DealDTO dto=new DealDTO();
DealDAO dao=new DealDAO();

ArrayList<DealDTO> DealWantList=dao.DealWantList(S_num);

// ArrayList<DealDTO> DealWantList=(ArrayList<DealDTO>)request.getAttribute("DealWantList");


%>	
<form>
<section>
<table border="1">
<tr><td>구매희망자</td><td>거래완료</td></tr>

<%

for(int i=0;i<DealWantList.size();i++){
	dto=DealWantList.get(i);	
%>

	<tr>
		<td><%=dto.getD_buy() %></td>
		<td><button type="button" onclick="location.href='EndDealPro.deal?S_num=<%=dto.getS_num()%>&D_buy=<%=dto.getD_buy()%>'">거래완료</button>
		</td>
		
	</tr>

<%
}
%>
	</table>

</section>
</form>
<!--  ***** 구매 요청자 조회 끝***** -->
	       
             </div>
        </div>
    </div>     <!-- ***** 푸터 시작 ***** -->
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
    <script src=".assets/js/datepicker.js"></script>
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