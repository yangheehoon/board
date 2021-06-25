package com.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.model.Board;
import com.web.service.BoardService;

@Controller
/*리퀘스트매핑을 통해 요청 url을 클래스에 매핑*/
@RequestMapping("/board")
public class BoardController {
	
	/*BoardService를 해당 클래스에 주입*/
	@Autowired
	BoardService boardservice;
	
	/*리퀘스트매핑을 통해 요청 url을 메소드에 매핑*/
	@RequestMapping("/boardlist")
	/*게시판 목록을 조회하기 위한 함수*/
	public String BoardList(Model model) {
		
		/*boardservice.ServiceList()의 리턴 값을 리스트에 담음*/
		List<Board> list = boardservice.ServiceList();
		
		/*리스트를 모델 객체에 담음*/
		model.addAttribute("list", list);
		
		/*반환될 뷰페이지*/
		return "board/boardlist";
	}
	
}
