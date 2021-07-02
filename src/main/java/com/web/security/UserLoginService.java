package com.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.dao.MemberDao;
import com.web.model.Member;

@Service
public class UserLoginService implements UserDetailsService{
	
	@Autowired
	MemberDao memberdao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println(username+"........loadUserByUsername");
		
		Member member = memberdao.SelectId2(username);
		
		System.out.println("member="+member);
		
		UserDetails loginUser = null;
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(member.getAuthority()));
		loginUser = new User(member.getId(), "{noop}"+member.getPw() ,authorities) ;
		return loginUser;
	}

/*	public UserDetails loadUserByUsername(String id) {

		// 최종적으로 리턴해야할 객체
		UserDetailsImp userDetails = new UserDetailsImp();

		// 사용자 정보 select
		Member member = memberdao.SelectId2(id);

		// 사용자 정보 없으면 null 처리
		if (member == null) {
			return null;

		// 사용자 정보 있을 경우 로직 전개 (userDetails에 데이터 넣기)
		} else {
			userDetails.setUsername(member.getId());
			userDetails.setPassword(member.getPw());

			// 사용자 권한 select해서 받아온 List<String> 객체 주입
			List<String> list = new ArrayList<String>();
			list.add("sdf");
			userDetails.setAuthorities(list);
		}

		return userDetails;
	}
*/
}

