<%@page import="com.itwillbs.comment.db.CommentDTO"%>
<%@page import="com.itwillbs.comment.db.CommentDAO"%>
<%@page import="com.itwillbs.buy.db.BuyDTO"%>
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
   <link href="assets/css/buyDetails.css" rel="stylesheet" type="text/css">
    <link href="assets/css/buy.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>중고 의류거래: 옺장</title>
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
    
<%
int B_num = Integer.parseInt(request.getParameter("B_num"));
String M_id = (String)session.getAttribute("M_id");
BuyDTO dto = (BuyDTO)request.getAttribute("dto");
CommentDAO comment=new CommentDAO();
int pageNumber = (Integer)request.getAttribute("pageNumber");
ArrayList<CommentDTO>List=comment.getList(B_num, pageNumber);

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm");
%>
<div class="container2">
	<div class="row" style="text-align: center; ">
	<!-- 	본문 시작 -->
<table class = "table table-striped" style="margin-left:auto;margin-right:auto; undefined;table-layout: fixed; width: 1003px; text-align:center; border:1px solid #dddddd">
<colgroup>
<col style="width: 601px">
<col style="width: 101px">
<col style="width: 301px">
</colgroup>
<thead>
  <tr>
    <th colspan="3" style="background-color: #eeeeee; text-align:center">삽니다</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td rowspan="7">이미지자리</td>
    <td>글제목</td>
    <td><%= dto.getB_title()%></td>
  </tr>
  <tr>
    <td>작성자</td>
    <td><%= dto.getM_id() %></td>
  </tr>
  <tr>
    <td>카테고리</td>
    <td><%= dto.getB_category() %></td>
  </tr>
  <tr>
    <td>거래유형</td>
    <td><% if(dto.getB_send1()!=null){%> <%= "택배거래<br>"%><%}%>
					<% if(dto.getB_send2()!=null){%> <%= "("+dto.getB_sido1()+")<br>직거래"%><%}%></td>
  </tr>
  <tr>
    <td>조회수</td>
    <td> <%= dto.getB_view() %></td>
  </tr>
  <tr>
    <td>작성일자</td>
    <td><%= dateFormat.format(dto.getB_time())%></td>
  </tr>
  <tr>
    <td height="150">글내용</td>
    <td><%= dto.getB_text() %></td>
  </tr>
</tbody>
</table>

<!-- 본문 끝 -->
<!-- 댓글시작 -->
<div id="comment"  style="text-align: center;" >
<form method="post" action="CommentAction.buy?B_num=<%=B_num%>">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="3"
								style="background-color: #eeeeeee; text-align: center;">댓글</th>
						</tr>
					</thead>
					<tbody>
					
						<%
// 						int pageNumber=1;
// 						// pageNumber는 URL에서 가져온다.
// 						if(request.getParameter("pageNumber")!=null){
// 							pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
// 						}
// 							CommentDAO comment=new CommentDAO();
// ArrayList<CommentDTO> List=(ArrayList<CommentDTO>)request.getAttribute("List");
							
// 							int pageNumber = (Integer)request.getAttribute("pageNumber");
							for(int i=List.size()-1 ; i>=0 ; i--){
						%>

						<tr>
						<td width="10%" style="text-align: left;"><%=List.get(i).getM_id() %></td>
							<td width="200" style="text-align: left;"><%=List.get(i).getCo_text() %></td>
							
							<td width="10" ><a href=# onclick = "return coupdate();" class="btn">수정</a>
									<script text="text/javascript">
								
								function coupdate(Co_num){
									//	수정팝업창 크기 조절과 팝업 위치 조절
								    var _width = '600';
								    var _height = '300';
								    var _left = Math.ceil(( window.screen.width - _width )/2);
								    var _top = Math.ceil(( window.screen.height - _height )/2); 
									window.name ="buydetails";
									window.open("CommentUpdateForm.buy?Co_num="+<%=List.get(i).getCo_num()%>,
											"updateForm", 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top);
								}
									</script>
							</td>
							<td width="10">
							<a href="CommentDelete.buy?B_num=<%=B_num %>&Co_num=<%=List.get(i).getCo_num() %>"
								onclick="return delchk();" class="btn">삭제</a>
									<script type="text/javascript">
								function delchk(){return confirm("삭제하시겠습니까?");}
									</script>
							</td> 
						</tr>
		
						<%
								}
						%>
			<tr>
			<td colspan="3">
			<div class="btn-naran">
				<textarea type="text" class="form-control"
				placeholder="댓글을 입력하세요." name="Co_text" 
				maxlength="2048" style="width:800px;height:100px;font-size:15px;"></textarea>
				</td>
				<td>
				<input type="submit" class="btn btn-dark" value="댓글입력">
			</div>
			</td>

					
					</tbody>
				</table>
				
			</form>
			</div>
	</div>
<!-- 댓글끝 -->

			<div class="btn-naran">
<%
if(M_id != null){
	// 세션값=id와 글쓴이가 일치해야만 글수정, 글삭제 표시
	if(M_id.equals(dto.getM_id()) || M_id.equals("admin")){
		%>
<input type="button" class="btn btn-dark" value="글수정" onclick="location.href='buyEdit.jsp?B_num=<%=dto.getB_num() %>'">
<input type="button" class="btn btn-dark" value="글삭제" onclick="location.href='buyDelete.jsp?B_num=<%=dto.getB_num() %>'"> 
		<%		
	}
}
%>
	<button type="button" class="btn btn-dark" onclick="location.href='buyList.jsp'" >글목록</button>
</div>
</div>
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