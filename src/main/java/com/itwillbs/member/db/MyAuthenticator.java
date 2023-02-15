package com.itwillbs.member.db;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
	private PasswordAuthentication pa;
	public MyAuthenticator() {
		pa=new PasswordAuthentication("lg25sk@gmail.com","thtfoncvpoviutah" );
		
	}
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}
