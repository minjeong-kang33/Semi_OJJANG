package com.itwillbs.review.db;

import java.sql.Timestamp;

public class reviewDTO {
	
	private int RE_num;
	private int S_id;
	private String RE_writer;
	private String RE_title;
	private String RE_text;
	private Timestamp RE_createtime;
	private String RE_img1;
	private String RE_delivery;
	private String RE_manner;
	private String RE_ProductStatus;
	private String RE_fast;
	private String RE_time;

	public int getRE_num() {
		return RE_num;
	}
	public void setRE_num(int rE_num) {
		RE_num = rE_num;
	}

	
	
	public int getS_id() {
		return S_id;
	}
	public void setS_id(int s_id) {
		S_id = s_id;
	}
	public String getRE_writer() {
		return RE_writer;
	}
	public void setRE_writer(String rE_writer) {
		RE_writer = rE_writer;
	}
	public String getRE_title() {
		return RE_title;
	}
	public void setRE_title(String rE_title) {
		RE_title = rE_title;
	}
	public String getRE_text() {
		return RE_text;
	}
	public void setRE_text(String rE_text) {
		RE_text = rE_text;
	}
	public Timestamp getRE_createtime() {
		return RE_createtime;
	}
	public void setRE_createtime(Timestamp rE_createtime) {
		RE_createtime = rE_createtime;
	}

	public String getRE_img1() {
		return RE_img1;
	}
	public void setRE_img1(String rE_img1) {
		RE_img1 = rE_img1;
	}
	public String getRE_delivery() {
		return RE_delivery;
	}
	public void setRE_delivery(String rE_delivery) {
		RE_delivery = rE_delivery;
	}
	public String getRE_manner() {
		return RE_manner;
	}
	public void setRE_manner(String rE_manner) {
		RE_manner = rE_manner;
	}
	public String getRE_ProductStatus() {
		return RE_ProductStatus;
	}
	public void setRE_ProductStatus(String rE_ProductStatus) {
		RE_ProductStatus = rE_ProductStatus;
	}
	public String getRE_fast() {
		return RE_fast;
	}
	public void setRE_fast(String rE_fast) {
		RE_fast = rE_fast;
	}
	public String getRE_time() {
		return RE_time;
	}
	public void setRE_time(String rE_time) {
		RE_time = rE_time;
	}
	
}
