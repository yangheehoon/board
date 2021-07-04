package com.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.BoardDao;
import com.web.model.Board;

@Service
public class BoardService {
	
	/*BoardDao를 해당 클래스에 주입*/
	@Autowired
	BoardDao boarddao;
	
	/*게시판 목록을 조회하기 위한 함수*/
	public List<Board> ServiceList(String page, String field, String query) {
		return boarddao.SelectList(page,field,query);
	}
	
	/*게시글의 갯수를 조회하기 위한 함수*/
	public int ServiceCount() {
		return boarddao.SelectCount();
	}

	/*게시글 추가를 위한 함수*/
	public void ServiceAddBoard(String title, String content, String files, String nick) {
		
		boarddao.InsertBoard(title, content, files, nick);
	}

	/*게시글을 조회하기 위한 함수*/
	public Board ServiceDetail(int num) {
		/*게시글 조회수 증가 함수*/
		boarddao.UpdateHit(num);
		return boarddao.SelectBoard(num);
	}

}
