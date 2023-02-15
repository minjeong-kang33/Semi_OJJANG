<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<footer class="footer-sticky">
   <div class="container">
      <div class="row">
         <div class="col-lg-3">
            <div class="first-item">
               <div class="logo">
                  <img src="assets/images/otzang_logo_bottom.png" width="230px">
               </div>
               <ul>
                  <li><a href="#">109, Dongcheon-ro, Busanjin-gu, Busan,
                        Republic of Korea</a></li>
                  <li><a href="#">ojjang@company.com</a></li>
                  <li><a href="#">010-020-0340</a></li>
               </ul>
            </div>
         </div>
         <div class="col-lg-3">
            <h4>Categories</h4>
            <ul>
               <li><a href="../sell/outer.jsp">Outer</a></li>
               <li><a href="../sell/shirts.jsp">Top</a></li>
               <li><a href="../sell/pants.jsp">Pants</a></li>
               <li><a href="../sell/dress.jsp">Dress</a></li>
            </ul>
         </div>
         <%
								/* 로그인 한 경우 */
					String M_id=(String)session.getAttribute("M_id");
					if(M_id != null){
					
				%>
		<div class="col-lg-3">
            <h4>Useful Links</h4>
            <ul>
               <li><a href="../Mypage/profile.jsp">My Profile</a></li>
               <li><a href="../Mypage/likeList.jsp">Wish List</a></li>
               <li><a href="../Mypage/sellHistory.jsp">Sales History</a></li>
               <li><a href="../Mypage/buyHistory.jsp">Purchase history</a></li>
               <!-- 일단 게시글모음은 여기서는 뺄게요! 너무 많아서요! -->
               <li><a href="../review/reviewList.jsp">My review</a></li>
            </ul>
         </div>
         <div class="col-lg-3">
            <h4>Help & Information</h4>
            <ul>
               <li><a href="#">About us</a></li>
               <li><a href="#">Help</a></li>
            </ul>
         </div>
				<%
					}else{
										/* 로그인 안 한 경우 */
				%>
		<div class="col-lg-3">
            <h4>Help & Information</h4>
            <ul>
               <li><a href="#">About us</a></li>
               <li><a href="#">Help</a></li>
            </ul>
         </div>
                   
				<%		
				}
				%>
         
         
         <div class="col-lg-12">
            <div class="under-footer"></div>
         </div>
      </div>
   </div>
</footer>