package com.web.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.MemberDao;
import com.web.model.Member;

@Service
public class MemberService {

	@Autowired
	MemberDao memberdao;
	
	/*회원가입 함수*/
	public void ServiceJoin(String id, String pw, String nick, String name, String gender, String email, 
			String phone, String address, String birth) {
		memberdao.insertMember(id,pw,nick,name,gender,email,phone,address,birth);
	}

	/*로그인  함수*/
	public String ServiceLoginCk(String id, String pw, HttpSession session) {
		
		/*아이디 조회 함수*/
		String id2= memberdao.SelectId(id);
		/*회원 조회 함수*/
		Member member = memberdao.SelectMember(id,pw);
		
		System.out.println(id2);
		System.out.println(member);
		/*아이디 체크*/
		if(id2==null) {
			return "id_doesnt_exist";	
		/*패스워드 체크*/	
		}else if(member==null) {
			return "pw_mismatch";
		/*아이디와 패스워드가 일치할 경우 세션 객체에 멤버를 담음*/ 	
		}else {
			System.out.println(member.toString());
			/*세션에 회원데이터 담음*/
			session.setAttribute("member", member);
			return "success";
		}
		
	}
	

}
