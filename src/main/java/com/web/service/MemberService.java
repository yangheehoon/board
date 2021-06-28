package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.MemberDao;

@Service
public class MemberService {

	@Autowired
	MemberDao memberdao;
	
	/*회원가입 함수*/
	public void ServiceJoin(String id, String pw, String nick, String name, String gender, String email, 
			String phone, String address, String birth) {
		memberdao.insertMember(id,pw,nick,name,gender,email,phone,address,birth);
	}

}
