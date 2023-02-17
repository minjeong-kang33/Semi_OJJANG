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
               <li><a href="Outer.sell">Outer</a></li>
               <li><a href="Shirts.sell">Top</a></li>
               <li><a href="Pants.sell">Pants</a></li>
               <li><a href="Dress.sell">Dress</a></li>
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
               <li><a href="Profile.moi">My Profile</a></li>
               <li><a href="Likelist.moi">Wish List</a></li>
               <li><a href="Sellhistory.moi">Sales History</a></li>
               <li><a href="Buyhistory.moi">Purchase history</a></li>
               <!-- 일단 게시글모음은 여기서는 뺄게요! 너무 많아서요! -->
               <li><a href="ReviewList.rev">My review</a></li>
            </ul>
         </div>
         <div class="col-lg-3">
            <h4>Help & Information</h4>
            <ul>
               <li><a href="Introduce.buy">About us</a></li>
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
               <li><a href="Introduce.buy">About us</a></li>
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