package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.BoardDao;
import com.web.model.Board;

@Service
public class BoardService {
	
	/*BoardDao를 해당 클래스에 주입*/
	@Autowired
	BoardDao boarddao;
	
	/*boarddao.SelectList의 값을 받기 위한 함수*/
	public List<Board> ServiceList() {
		return boarddao.SelectList();
	}
}
