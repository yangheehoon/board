package com.web.model;

import java.util.Date;

public class Board {

	/*필드 선언*/
	private int num;
	private String title;
	private String content;
	private String nick;
	private String files;
	private int hit;
	private Date regdate ;
	
	/*기본생성자*/
	public Board() {
		// TODO Auto-generated constructor stub
	}

	/*오버로드생성자*/
	public Board(int num, String title, String content, String nick, String files, int hit, Date regdate) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.nick = nick;
		this.hit = hit;
		this.files = files;
		this.regdate = regdate;
	}

	/*getter와 setter 함수*/
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}
	
	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	/*값을 확인하기 위한 toString 함수*/ 
	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", content=" + content + ", nick=" + nick + ", files=" + files
				+ ", hit=" + hit + ", regdate=" + regdate + "]";
	}
	
}
