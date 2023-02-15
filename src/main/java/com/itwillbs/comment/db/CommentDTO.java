package com.itwillbs.comment.db;

public class CommentDTO{

	private int B_num;
	private int Co_num;
	private String Co_text;
	private String M_id;
	private int Co_available;
	public int getB_num() {
		return B_num;
	}
	public void setB_num(int b_num) {
		B_num = b_num;
	}
	public int getCo_num() {
		return Co_num;
	}
	public void setCo_num(int co_num) {
		Co_num = co_num;
	}
	public String getCo_text() {
		return Co_text;
	}
	public void setCo_text(String co_text) {
		Co_text = co_text;
	}
	public String getM_id() {
		return M_id;
	}
	public void setM_id(String m_id) {
		M_id = m_id;
	}
	public int getCo_available() {
		return Co_available;
	}
	public void setCo_available(int co_available) {
		Co_available = co_available;
	}
}