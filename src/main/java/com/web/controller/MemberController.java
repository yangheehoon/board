package com.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberservice;
	
	/*회원가입 함수*/
	@RequestMapping("/joinform")
	public String join(@RequestParam(value="id", required=false) String id,			
		@RequestParam(value="pw", required=false) String pw,
		@RequestParam(value="nick", required=false) String nick,
		@RequestParam(value="name", required=false) String name,
		@RequestParam(value="gender", required=false) String gender,
		@RequestParam(value="email", required=false) String email,
		@RequestParam(value="phone", required=false) String phone,
		@RequestParam(value="address", required=false) String address,
		@RequestParam(value="birth", required=false) String birth
			) {
		
		/*파라미터 값이 넘어오면 회원가입 서비스를 진행*/
		if(id!=null&&pw!=null&&nick!=null&&name!=null&&gender!=null&&email!=null&&phone!=null&&address!=null&&birth!=null) {
			
			memberservice.ServiceJoin(id,pw,nick,name,gender,email,phone,address,birth);
			
			return "member/join_success";
		}		
		
		return "member/joinform";
	}
	
	/*로그인 페이지 호출 함수*/  
	@RequestMapping("/loginform")
	public String Login() {
		
		return "member/loginform";
	}
	
	/*로그인 체크 함수*/
	@RequestMapping("/login_ck")
	/*ajax에 viewresolve를 거치지 않고 
	string 값을 그대로 리턴 받기 위해 reponsebody 사용*/
	@ResponseBody
	public String LoginCk(@RequestParam(value="id") String id,
			@RequestParam(value="pw") String pw,
			HttpSession session) {
		
		/*로그인 정보를 담기 위해 session도 보내준다*/
		return memberservice.ServiceLoginCk(id,pw,session);		
	}
	
	
}
