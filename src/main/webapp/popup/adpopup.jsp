<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <!-- ***** 팝업창 시작 ***** -->
        <script>
function setCookie( name, value, expiredays ) {
	var todayDate = new Date();
	todayDate.setDate( todayDate.getDate() + expiredays );
	document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"
}

function getCookie( name ) {
	var nameOfCookie = name + "=";
	var x = 0;
	while ( x <= document.cookie.length ) {
	var y = (x+nameOfCookie.length);
		if ( document.cookie.substring( x, y ) == nameOfCookie ) {
		if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 )
		endOfCookie = document.cookie.length;
			return unescape( document.cookie.substring( y, endOfCookie ) );
		}
	x = document.cookie.indexOf( " ", x ) + 1;
	if ( x == 0 )
	break;
	}
	return "";
}

if ( getCookie( "popup2" ) != "done" ) {
	noticeWindow =
	window.open('Popup2.ad','popup2','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=310,height=510,top=90,left=200');
	//경로 수정?
	noticeWindow.opener = self;
}
</script>
    <!-- ***** 팝업창 끝 ***** -->