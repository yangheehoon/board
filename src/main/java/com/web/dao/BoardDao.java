package com.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.model.Board;

@Repository
public class BoardDao {
	
	/*SqlSession 객체를 선언함과 동시에 오토와이어드로 해당 클래스에 주입*/
	@Autowired
	SqlSession sqlSession;
	
	/*게시판 목록을 조회하기 위한 함수*/
	public List<Board> SelectList(){
			
		/*mapper의 쿼리문을 통해 db의 반환 값을 리턴한다*/
		return sqlSession.selectList("mapper_board.SelectList");		
	}

}
