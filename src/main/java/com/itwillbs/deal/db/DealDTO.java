package com.itwillbs.deal.db;

import java.sql.Timestamp;

public class DealDTO {
	
	private int D_num;
	private int S_num;
	private String M_id;
	private String D_buy;
	private Timestamp D_date;
	public int getD_num() {
		return D_num;
	}
	public void setD_num(int d_num) {
		D_num = d_num;
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
	public String getD_buy() {
		return D_buy;
	}
	public void setD_buy(String d_buy) {
		D_buy = d_buy;
	}
	public Timestamp getD_date() {
		return D_date;
	}
	public void setD_date(Timestamp d_date) {
		D_date = d_date;
	}
	

}