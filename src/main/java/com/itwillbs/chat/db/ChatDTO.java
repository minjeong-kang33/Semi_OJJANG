package com.itwillbs.chat.db;

public class ChatDTO {
	
	int chatID;
	String fromID;
	String toID;
	String chatContent;
	String chatTime;
	int chatRead;
	
	public int getChatRead() {
		return chatRead;
	}
	public void setChatRead(int chatRead) {
		this.chatRead = chatRead;
	}
	public int getChatID() {
		return chatID;
	}
	public void setchatID(int chatID) {
		this.chatID = chatID;
	}
	public String getFromID() {
		return fromID;
	}
	public void setFromID(String fromID) {
		this.fromID = fromID;
	}
	public String getToID() {
		return toID;
	}
	public void setToID(String toID) {
		this.toID = toID;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public String getChatTime() {
		return chatTime;
	}
	public void setChatTime(String chatTime) {
		this.chatTime = chatTime;
	}
}
