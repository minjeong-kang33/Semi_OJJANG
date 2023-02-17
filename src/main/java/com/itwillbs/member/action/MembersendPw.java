package com.itwillbs.member.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.member.db.MyAuthenticator;

public class MembersendPw implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MembersendPw execute() ");
		request.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
		MemberDAO dao=new MemberDAO();
		MemberDTO dto=new MemberDTO();
		String M_pw = request.getParameter("M_pw");
		String M_id = request.getParameter("M_id");

		try{
			request.setCharacterEncoding("utf-8");
			//1) 사용하고자 하는 메일서버에서 인증받은 계정과 비번을 등록하기
			//-> MyAuthenticator 클래스 생성

			//2) 메일서버(POP3/SMTP) 지정하기

			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.googlemail.com"); // google SMTP 주소
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");
			props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // 추가된 코드
			props.put("mail.smtp.ssl.enable", "true");  // 추가된 코드
			
			//3) 메일서버에서 인증받은 계정+비번
			Authenticator myAuth = new MyAuthenticator();
//		 	PasswordAuthentication=myAuth.getPasswordAuthentication2();
			//다형성으로 객체 생성(자식이 부모집에 들어감)
			
			//4) 2)와 3)이 유효한지 검증
			Session sess = Session.getInstance(props, myAuth);
			//out.print("메일서버 인증 성공!");
			
			//5) 메일 보내기
			
			String to = request.getParameter("M_email");
			String from	   = "itwillbs.co.kr";
			String subject = "[(주)옺장] 임시 비밀번호";
			String content = "임시 비밀번호를 발급해드립니다.";	
			content += "<hr>";
			content += M_pw;
			dto.setM_pw(M_pw);
			dto.setM_id(M_id);	
			//받는 사람 이메일 주소
			InternetAddress[] address = { new InternetAddress(to) };
			//메일 관련 정보 작성
			Message msg = new MimeMessage(sess);
			//받는 사람
			msg.setRecipients(Message.RecipientType.TO, address);
			//보내는 사람
			msg.setFrom(new InternetAddress(from));
			//메일 제목
			msg.setSubject(subject);
			//메일 내용
			msg.setContent(content, "text/html; charset=UTF-8");
			//메일 보낸 날짜
			msg.setSentDate(new Date());
			
			int cnt = dao.updatePasswd(dto);;
			if(cnt == 0){
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				Transport.send(msg);
				out.println(to);
				out.println("님의 이메일에 메일이 발송되었습니다.");
				System.out.println(msg.getContent());
			}else{
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				response.setContentType("text/html; charset=UTF-8");
				out.println("<script>");
				out.println("	location.href='MemberLoginForm.me';");	//인트로페이지 이동
				out.println("</script>");
			}//if end

		}catch(Exception e){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<p>메일전송 실패!" + e + "</p>");
			out.println("<p><a href='javascript:history.back();'>[다시시도]</a></p>");
			e.printStackTrace();
		}//end
		return null;
		
	}

}
