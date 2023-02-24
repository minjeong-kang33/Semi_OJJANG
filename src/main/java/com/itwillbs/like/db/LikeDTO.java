package com.itwillbs.like.db;

import java.sql.Timestamp;

public class LikeDTO {
	private int S_num;
	private String M_id;
	private Timestamp L_date;

	
	public Timestamp getL_date() {
		return L_date;
	}
	public void setL_date(Timestamp l_date) {
		L_date = l_date;
	}
	public int getS_num() {
		return S_num;
	}
	public void setS_num(int s_num) {
		S_num = s_num;
	}
	public String getM_id() {
		return M_id;
	}
	public void setM_id(String m_id) {
		M_id = m_id;
	}

	
	
	
}
