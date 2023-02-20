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
                  <li><a href="Introduce.buy">109, Dongcheon-ro, Busanjin-gu, Busan,
                        Republic of Korea</a></li>
                  <li><a href="Introduce.buy">ojjang@company.com</a></li>
                  <li><a href="Introduce.buy">010-020-0340</a></li>
               </ul>
            </div>
         </div>
         
		<%

	String M_id=(String)session.getAttribute("M_id");
	if(!"admin".equals(M_id)){
		//admin이면 안보이게 
	%>

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

				<%
					}
										/* admin 인 경우 */
				}else if(M_id.equals("admin")){
					%>
        <div class="col-lg-3">
            <h4>User Management</h4>
            <ul>
               <li><a href="AdUserList.ad">General User</a></li>
               <li><a href="AdUserReportList.ad">Reported User</a></li>
               <li><a href="AdOutList.ad">Withdrawal User</a></li>
            </ul>
         </div>
         
        <div class="col-lg-3">
            <h4>Posts Management</h4>
            <ul>
               <li><a href="AdSellList.ad">Post for Sell</a></li>
               <li><a href="AdBuyList.ad">Post for Buy</a></li>
            </ul>
         </div>
					<%
				}
	
										/* 모든 경우 */
				%>
		<div class="col-lg-3">
            <h4>Help & Information</h4>
            <ul>
               <li><a href="Introduce.buy">About us</a></li>
               <li><a href="#">Help</a></li>
            </ul>
         </div>
                   
         
         <div class="col-lg-12">
            <div class="under-footer"></div>
         </div>
      </div>
   </div>
</footer>