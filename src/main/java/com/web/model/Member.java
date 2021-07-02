package com.web.model;

import java.util.Date;

public class Member {

	/*필드 선언*/
	private String id;
	private String pw;
	private String nick;
	private String gender;
	private String email;
	private String phone;
	private String address;
	private String birth;
	private Date regdate;
	private String authority;
	
	
	/*기본 생성자*/
	public Member() {
		// TODO Auto-generated constructor stub
	}

	/*오버로드 생성자*/
	public Member(String id, String pw, String nick, String gender, String email, String phone, String address,
			String birth, Date regdate, String authority) {
		super();
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.birth = birth;
		this.regdate = regdate;
		this.authority = authority;
	}

	/*클래스의 데이터에 접근하기 위한 getter setter 생성*/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", nick=" + nick + ", gender=" + gender + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", birth=" + birth + ", regdate=" + regdate
				+ ", authority=" + authority + "]";
	}

	
}
