package com.itwillbs.report.db;

import java.sql.Timestamp;

import com.itwillbs.member.db.MemberDTO;

public class ReportDTO extends MemberDTO{

private String R_type;
private String M_id;
private String R_id;
private String R_reason;
private String R_writeNum;
private String R_category;
private String R_title;
private String R_play;
private Timestamp R_date;



public Timestamp getR_date() {
	return R_date;
}
public void setR_date(Timestamp r_date) {
	R_date = r_date;
}
public String getR_play() {
	return R_play;
}
public void setR_play(String r_play) {
	R_play = r_play;
}
public String getR_title() {
	return R_title;
}
public void setR_title(String r_title) {
	R_title = r_title;
}
public String getR_writeNum() {
	return R_writeNum;
}
public void setR_writeNum(String r_writeNum) {
	R_writeNum = r_writeNum;
}
public String getR_category() {
	return R_category;
}
public void setR_category(String r_category) {
	R_category = r_category;
}

public String getR_type() {
	return R_type;
}
public void setR_type(String r_type) {
	R_type = r_type;
}
public String getM_id() {
	return M_id;
}
public void setM_id(String m_id) {
	M_id = m_id;
}
public String getR_id() {
	return R_id;
}
public void setR_id(String r_id) {
	R_id = r_id;
}
public String getR_reason() {
	return R_reason;
}
public void setR_reason(String r_reason) {
	R_reason = r_reason;
}

	
	
}
