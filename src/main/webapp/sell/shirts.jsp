<%@page import="com.itwillbs.like.db.LikeDTO"%>
<%@page import="com.itwillbs.admin.db.MypageDAO"%>
<%@page import="com.itwillbs.sell.db.SellDTO"%>
<%@page import="com.itwillbs.sell.db.SellDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   <link href="assets/css/sell.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>중고 의류거래: 옺장</title>

   <script type="text/javascript">     
   	 <%-- 토글 --%>
    	var set_state = true;
    	var img_icon = new Array(); 
    	img_icon[0] = new Image(); 
    	img_icon[1] = new Image();
    	img_icon[0].src = "sell/heart.png"; 
    	img_icon[1].src = "sell/fullheart.png"; 
    	
    function hartToggle(){
    	document.all.icon_btn.src = (set_state ? img_icon[0].src : img_icon[1].src);
    	   if(set_state){ 
    		   set_state = false;
    	   } else {
    	       set_state = true;
    	   }
    }
    
    </script>
</head>

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

	<section class="section" id="products">


		<!-- 게시판 제목  -->
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-heading">
						<h2>상의</h2>
						<span>shirts</span>
					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<div class="item">
						<div class="down-content">
<!-- 게시판 내용 여기부터 넣으세요  -->
						
							<!-- 상품게시글 table  -->
	<%
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
	
	ArrayList<SellDTO> sellShirtsList = (ArrayList<SellDTO>)request.getAttribute("sellShirtsList");

	String M_id = (String)session.getAttribute("M_id");
	int currentPage = (Integer)request.getAttribute("currentPage");
	int startPage = (Integer)request.getAttribute("startPage");
	int pageBlock = (Integer)request.getAttribute("pageBlock");
	int endPage = (Integer)request.getAttribute("endPage");
	int pageCount = (Integer)request.getAttribute("pageCount");
	
	%>						
<table>
	<tr> <!--  테이블................1칸 -->
	<%
	for(int i=0; i<sellShirtsList.size();i++){
		SellDTO dto = sellShirtsList.get(i);
	
	%>
		<td>
			<table class="item-table">
				<tr>
					<td colspan="2" class="S_img"><a href="SellShirtsDetails.sell?S_num=<%=dto.getS_num()%>" >
					<img src="img/sell/<%=dto.getS_img() %>" width=300px height=300px class="goodsImg"></a></td>
				</tr>
				<tr>
					<td colspan="2" class="S_title" > <a href="SellShirtsDetails.sell?S_num=<%=dto.getS_num()%>" > <%=dto.getS_title()%></a></td> <!-- 제목 -->
				</tr>
				<tr>
									<tr>
					<td class="price"><%=dto.getS_price()%>원</td> 
					<td align="right" class="like_id">
							<% 
							if(M_id != null){
								//본인에게는 거래요청하기 안보임
								if(!M_id.equals(dto.getM_id())){
					
								   MypageDAO dao=new MypageDAO();
								   LikeDTO getLikeDto=dao.getLike(M_id, dto.getS_num());
								   if(getLikeDto==null){ %>
							<input type="image" name="button"  class="heart" src="sell/heart.png" onclick="location.href='LikePro.like?S_num=<%=dto.getS_num() %>'">
							<%
						   } else {
						   %>
						   <input type="image" name="button" class="heart" src="sell/fullheart.png" onclick="location.href='LikePro.like?S_num=<%=dto.getS_num() %>'">
									<%
									  		 }
										   }	
										}
										%>
				</tr>
				</tr>
				<%-- <tr>
					<td class="S_sido1"><%=dto.getS_sido1()%></td> <td class="S_gugun1"><%=dto.getS_gugun1()%></td> <!-- 구군 -->
				</tr> --%>
				<tr>
					<td colspan="2" class="S_createdate" ><%= dateFormat.format(dto.getS_createdate())%></td> <!-- 게시글 생성일자 -->
				</tr>
				<tr>
					<td colspan="2" class="S_send"> <% if(dto.getS_send1()!=null&&dto.getS_send2()!=null){%> <%= "<b>택배거래</b>, <b>직거래</b>"%><%}
						else if(dto.getS_send1()!=null){%> <%= "<b>택배거래</b>"%><%}
						else if(dto.getS_send2()!=null){%> <%= "<b>직거래</b>"%><%}%> </td> <!-- 선호거래유형 -->
				</tr>
				<tr>
					<td colspan="2"> <% if(dto.getS_send2()!=null){%> <img src="sell/location_icon.png" class="location"><%= dto.getS_sido1()%> <%= dto.getS_gugun1()%><%} else { %>　<%}%> </td>
					<!-- else에 안보이는 공백문자있어요 지우지마세요 지우면 정렬깨짐 -->
				</tr>
			</table>
		</td>		
			<%
			if((i+1) %3 ==0){
			%>
				</tr>
				<tr>
				
			<%
			 }
			%>
	<%
	 }
	%>	
	
</tr>
</table>
							
<!-- 게시판 내용 여기 넘어가면 안됨.  -->							
		</div>
					<div style="width: 1000px;">		
				<!--  페이지 번호  -->
				<%
				
				for(int i=startPage;i<=endPage;i++){
					%>
					<a href="Shirts.sell?pageNum=<%=i%>"><%=i%></a>
					<%
				}
				
				%>
				<!-- 	글 작성 버튼을 오른쪽 아래에 고정 -->
				<%
				if(M_id != null){
				%>
					<button type="button" class="btn btn-dark" onclick="location.href='SellInsertForm.sell'" style="float:right; margin-left: 500px;">글쓰기</button>
				<%
				}
				%>
					</div>
				</div>
			</div>
		</div>
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
    
<!-- JSP -->    

    
</body>
</html>