package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberservice;
	
	/*회원가입 함수*/
	@RequestMapping("/join")
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
			
			return "redirect:/member/login";
		}		
		
		return "member/join";
	}
	
	/*로그인 함수*/
	@RequestMapping("/login")
	public String login() {
		
		
		return "member/login";
	}
}
