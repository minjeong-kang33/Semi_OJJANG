package com.itwillbs.out.db;

import java.sql.Timestamp;

public class OutDTO {

private int O_num;
private String M_id;
private String O_reason;
private Timestamp O_outday;


public int getO_num() {
	return O_num;
}
public void setO_num(int o_num) {
	O_num = o_num;
}
public String getM_id() {
	return M_id;
}
public void setM_id(String m_id) {
	M_id = m_id;
}
public String getO_reason() {
	return O_reason;
}
public void setO_reason(String o_reason) {
	O_reason = o_reason;
}
public Timestamp getO_outday() {
	return O_outday;
}
public void setO_outday(Timestamp o_outday) {
	O_outday = o_outday;
}



	
	
}
