package com.web.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

	@Autowired
	SqlSession sqlSession;
	/*회원가입 함수*/
	public void insertMember(String id, String pw, String nick, String name, String gender, String email,
			 String phone, String address, String birth) {
		
		/*mapper에 다수의 파라미터를 보내기 위해 hashmap에 담는다*/
		Map<String, Object> param_map = new HashMap<>();
		param_map.put("id", id);
		param_map.put("pw", pw);
		param_map.put("nick", nick);
		param_map.put("name", name);
		param_map.put("gender", gender);
		param_map.put("email", email);
		param_map.put("phone", phone);
		param_map.put("address", address);
		param_map.put("birth", birth);
		
		/*mapper의 insert 실행을 위한 함수*/
		sqlSession.insert("mapper_member.InsertMember",param_map );
	}

}
