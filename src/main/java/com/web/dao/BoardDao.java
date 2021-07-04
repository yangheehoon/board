package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.model.Board;

@Repository
public class BoardDao {
	
	/*sqlSession 객체를 해당 클래스에 주입*/
	@Autowired
	SqlSession sqlSession;
	
	/*게시판 목록을 조회하기 위한 함수*/
	public List<Board> SelectList(String page, String field, String query){
			
		Map<String,Object> param_map = new HashMap<>();
		param_map.put("page", page);
		param_map.put("field", field);
		param_map.put("query", query);
				
		/*mapper의 쿼리 값을 List로 반환*/
		return sqlSession.selectList("mapper_board.SelectList" , param_map);		
	}

	/*게시글의 갯수를 조회하기 위한 함수*/
	public int SelectCount() {
		
		/*mapper의 쿼리 값을 mapper의 resultType에 맞게 반환*/ 
		return sqlSession.selectOne("mapper_board.SelectCount");
	}

	/*게시글을 추가하기 위한 함수*/
	public void InsertBoard(String title, String content, String files, String nick) {
		
		/*mapper에 파라미터를 보내기위해 해쉬맵에 각 파라미터를 담음*/
		Map<String, Object> param_map = new HashMap<>();
		param_map.put("title", title);
		param_map.put("content", content);
		param_map.put("files", files);
		param_map.put("nick", nick);
		
		/*파라미터와 함께 인설트 실행*/
		sqlSession.insert("mapper_board.InsertBoard", param_map);
	}

	/*게시글을 조회하기 위한 함수*/
	public Board SelectBoard(int num) {
		/*num파라미터를 통해 mapper로 부터 게시글 객체 리턴 */ 
		return sqlSession.selectOne("mapper_board.SelectBoard",num);
	}

	/*게시글 조회수 증가 함수*/
	public void UpdateHit(int num) {
		sqlSession.update("mapper_board.UpdateHit", num);
	}

}
