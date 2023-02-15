<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
             	
    <!-- ***** 비밀번호 ***** -->


<h3>비밀번호수정</h3>
	



<%
String M_id=(String)session.getAttribute("M_id");


%>
<section>	
<form action="pwUpdatePro.jsp" method="post" name="fr">
아이디 : <input type="text" name="M_id" value="<%=M_id%>" readonly><br>
비밀번호 : <input type="password" name="M_pw"><br>
변경 비밀번호: <input type="password" name="M_pw2"><br>

<input type="button" value="회원정보수정" onclick="fun1()">
</form>

<a href="main.jsp">메인으로 이동</a>

</section>
               
	<!-- ***** 회원정보수정 끝 ***** -->        
            
             </div>
        </div>
    </div>
    
       <!-- ***** 푸터 시작 ***** -->
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
  <script>
  function fun1(){
		if(document.fr.M_pw2.value.length<8){
			alert("수정할 비밀번호를 8자 이상 입력하세요.")
			document.fr.M_pw2.focus();
			return;
		}
		document.fr.submit();
	}
  </script>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
</html>