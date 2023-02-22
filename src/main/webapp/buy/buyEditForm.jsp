<%@page import="com.itwillbs.buy.db.BuyDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- 왜..  112행 int B_num = Integer.parseInt(request.getParameter("B_num"));에서
	java.lang.NumberFormatException: null이 나올까... -->

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>중고의류거래: 옺장</title>
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-hexashop.css">
    <link rel="stylesheet" href="assets/css/owl-carousel.css">
    <link rel="stylesheet" href="assets/css/lightbox.css">
    <link rel="stylesheet" href="assets/css/buyInsertForm.css">
    <script type="text/javascript" src="assets/smarteditor2/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
<meta charset="UTF-8">

<script type="text/javascript">
var oEditors = [];
$(function(){
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          elPlaceHolder: "B_text", 
          sSkinURI: "assets/smarteditor2/SmartEditor2Skin.html",  
          htParams : {
              bUseToolbar : true,             
              bUseVerticalResizer : false,     
              bUseModeChanger : false,         
              fOnBeforeUnload : function(){
              }
          }, 
          fOnAppLoad : function(){
              oEditors.getById["B_text"].exec("PASTE_HTML", [""]);
          },
          fCreator: "createSEditor2"
      });
      
   $("#save").click(function(){
      oEditors.getById["B_text"].exec("UPDATE_CONTENTS_FIELD", []);
      $("#frm").submit();
   });    
      
});

<%-- function pasteHTML(filepath){
     var sHTML = '<img src="<%=request.getContextPath()%>/uploadFolder/'+filepath+'">';
     oEditors.getById["content"].exec("PASTE_HTML", [sHTML]);
} --%>
     
$('document').ready(function() {
    var area0 = ["시/도 선택","서울특별시","인천광역시","대전광역시","광주광역시","대구광역시","울산광역시","부산광역시","경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주도"];
     var area1 = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
      var area2 = ["계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
      var area3 = ["대덕구","동구","서구","유성구","중구"];
      var area4 = ["광산구","남구","동구","북구","서구"];
      var area5 = ["남구","달서구","동구","북구","서구","수성구","중구","달성군"];
      var area6 = ["남구","동구","북구","중구","울주군"];
      var area7 = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
      var area8 = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
      var area9 = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
      var area10 = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
      var area11 = ["계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
      var area12 = ["군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
      var area13 = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
      var area14 = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
      var area15 = ["거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
      var area16 = ["서귀포시","제주시","남제주군","북제주군"];

    

    // 시/도 선택 박스 초기화
    $("select[name^=B_sido1]").each(function() {
        $selB_sido1 = $(this);
        $.each(eval(area0), function() {
         $selB_sido1.append("<option value='"+this+"'>"+this+"</option>");
        });
        $selB_sido1.next().append("<option value=''>구/군 선택</option>"); 
       });

    // 시/도 선택시 구/군 설정
    $("select[name^=B_sido1]").change(function() {
     var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의 구군 Array
     var $B_gugun1 = $(this).next(); // 선택영역 군구 객체
     $("option",$B_gugun1).remove(); // 구군 초기화 
     if(area == "area0")
      $B_gugun1.append("<option value=''>구/군 선택</option>");
     else {
      $.each(eval(area), function() {
       $B_gugun1.append("<option value='"+this+"'>"+this+"</option>");
      });
     }
    });
   });
   
function fun1() {
	// 필수조건 - 입력 안 된 경우, 선택 안 된 경우 => 입력하세요 제어=> 전송
	if(document.frm.B_title.value==""){
		alert("제목을 입력하세요");
		document.frm.B_title.focus();
		return false;
	}
	
	if(document.frm.B_category[0].checked==false && document.frm.B_category[1].checked==false
			&& document.frm.B_category[2].checked==false&& document.frm.B_category[3].checked==false){
		alert("카테고리를 선택하세요");
		return false;
	}
	
	if(document.frm.B_send1.checked==false && document.frm.B_send2.checked==false){
		alert("선호하는 거래형태를 선택하세요");
		return false;
	}
}
</script>
</head>
<body>

    <!-- ***** 헤더 ***** -->
  <jsp:include page="../top.jsp" />
    <!-- ***** 헤더 끝 ***** -->
 <%
 BuyDTO dto = (BuyDTO)request.getAttribute("dto");
 int B_num = Integer.parseInt(request.getParameter("B_num"));
 String M_id = (String)session.getAttribute("M_id");

%>   

 <section class="section" id="products">
      <!-- 게시판 제목  -->
      <div class="container">
         <div class="row">
            <div class="col-lg-12">
               <div class="section-heading">
                  <h2>게시판 글 수정</h2>
                  <span>edit my post</span>
               </div>
            </div>
         </div>
      </div>

	  <div class="container">
         <div class="row">
            <div class="col-lg-4">
               <div class="item">
                  <div class="down-content" style="width: 800px; margin-left: 200px">
                  
	<!-- ** 옷 카테고리 선택 시작 -->
<form id="frm" name="frm" action="BuyEditPro.buy?B_num=<%=B_num %>"  method="post" enctype="multipart/form-data" onsubmit="return fun1()">	
	<div class="radio1">
		<b>카테고리</b>
		 <input type="radio" id="radio-btn-1" name="B_category" value="outer" <%if(dto.getB_category().equals("outer")){%>checked <%}%>>
			<label for="radio-btn-1" class="btn" >아우터</label>
		<input type="radio" id="radio-btn-2" name="B_category" value="shirts" <%if(dto.getB_category().equals("shirts")){%>checked <%}%>>
			<label for="radio-btn-2" class="btn">상의</label>
		<input type="radio" id="radio-btn-3" name="B_category" value="pants" <%if(dto.getB_category().equals("pants")){%>checked <%}%>>
			<label for="radio-btn-3" class="btn">하의</label>
		<input type="radio" id="radio-btn-4" name="B_category" value="dress" <%if(dto.getB_category().equals("dress")){%>checked <%}%>>
			<label for="radio-btn-4" class="btn">원피스</label> 
	</div>
	<!-- ** 옷 카테고리 선택 끝 -->
	
	<!-- ** 선호거래 체크박스 시작 **-->
	<div class="check1">
		<b>선호하는 거래형태</b>
		<input type="checkbox" id="checkbox-btn-1" name="B_send1"  value="delivery" <%if(dto.getB_send1()!=null){%>checked <%}%>>
			<label for="checkbox-btn-1" class="btn">택배거래</label>
		<input type="checkbox" id="checkbox-btn-2" name="B_send2" value="direct" <%if(dto.getB_send2()!=null){%>checked <%}%>>
			<label for="checkbox-btn-2" class="btn" >직거래</label>
		
		<select name="S_sido1" id="S_sido1"><option><%=dto.getB_sido1() %></option></select>
		<select name="S_gugun1" id="S_gugun1"><option><%=dto.getB_gugun1() %></option></select>
			<input type="hidden" name="oldB_sido1" value="<%=dto.getB_sido1() %>">
			<input type="hidden" name="oldB_gugun1" value="<%=dto.getB_gugun1() %>">
   </div>
   
<!-- ** 선호거래 체크박스 끝 **-->
	
<!-- 입력상자 시작  -->    

<table>
<input type="hidden" name="M_id" value="<%=M_id %>"/>
	<tr>
		<th>제목</th>
    	<td><input type="text" id="B_title" name="B_title" value="<%=dto.getB_title() %>" style="width:650px" placeholder="제목을 입력하세요"/></td>
    </tr>
    <tr>
        <th>내용</th>
        <td>
        <textarea rows="10" cols="30" id="B_text" name="B_text" style="width:650px; height:350px;"><%=dto.getB_text() %></textarea>
        </td>
     </tr>
 </table>   
<table>
     <tr>
     	<td colspan="2">
     		<div class="button1">
     			<input type="file" name="B_img"><%=dto.getB_img() %>
     			<input type="hidden" name="oldfile" value="<%=dto.getB_img()%>">
			</div>
              <div class="button2" style="margin-left: 600px;">
                <input type="submit" id="save" class="btn btn-dark" style="margin-right: 10px;"value="글수정"/>
              </div>
         </td>
     </tr>
</table>
</form>
          </div>
               </div>
            </div>
         </div>
      </div>
   </section>
<!-- 텍스트박스 입력상자 끝  -->  

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