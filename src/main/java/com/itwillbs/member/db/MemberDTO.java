package com.itwillbs.member.db;

import java.sql.Timestamp;

public class MemberDTO {
	private String M_id;
	private String M_pw;
	private String M_name;
	private String M_nick;
	private String M_gender;
	private String M_phone;
	private String M_address;
	private String M_address2;
	private String M_email;
	private Timestamp M_createdate;
	private String M_play;
	private String M_admin;
	private String M_Profile;
	
	
	public String getM_Profile() {
		return M_Profile;
	}
	public void setM_Profile(String m_Profile) {
		M_Profile = m_Profile;
	}
	public String getM_id() {
		return M_id;
	}
	public void setM_id(String m_id) {
		M_id = m_id;
	}
	public String getM_pw() {
		return M_pw;
	}
	public void setM_pw(String m_pw) {
		M_pw = m_pw;
	}
	public String getM_name() {
		return M_name;
	}
	public void setM_name(String m_name) {
		M_name = m_name;
	}
	public String getM_nick() {
		return M_nick;
	}
	public void setM_nick(String m_nick) {
		M_nick = m_nick;
	}
	public String getM_gender() {
		return M_gender;
	}
	public void setM_gender(String m_gender) {
		M_gender = m_gender;
	}
	public String getM_phone() {
		return M_phone;
	}
	public void setM_phone(String m_phone) {
		M_phone = m_phone;
	}
	public String getM_address() {
		return M_address;
	}
	public void setM_address(String m_address) {
		M_address = m_address;
	}
	public String getM_address2() {
		return M_address2;
	}
	public void setM_address2(String m_address2) {
		M_address2 = m_address2;
	}
	public String getM_email() {
		return M_email;
	}
	public void setM_email(String m_email) {
		M_email = m_email;
	}
	public Timestamp getM_createdate() {
		return M_createdate;
	}
	public void setM_createdate(Timestamp m_createdate) {
		M_createdate = m_createdate;
	}
	public String getM_play() {
		return M_play;
	}
	public void setM_play(String m_play) {
		M_play = m_play;
	}
	public String getM_admin() {
		return M_admin;
	}
	public void setM_admin(String m_admin) {
		M_admin = m_admin;
	}
	
	
}