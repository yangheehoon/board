package com.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.model.Board;
import com.web.service.BoardService;

@Controller
/*리퀘스트매핑을 통해 요청 url을 클래스에 매핑*/
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	ServletContext sc;	
	
	/*BoardService를 해당 클래스에 주입*/
	@Autowired
	BoardService boardservice;
	
	/*리퀘스트매핑을 통해 요청 url을 메소드에 매핑*/
	@RequestMapping("/boardlist")
	/*게시판 목록을 조회하기 위한 함수*/
	public String BoardList(Model model) {
		
		/*list에 게시판 목록 담음*/
		List<Board> list = boardservice.ServiceList();
		
		/*count에 게시글 갯수 담음*/
		int count = boardservice.ServiceCount();
		
		/*list를 모델 객체에 담음*/
		model.addAttribute("list", list);
		
		/*count를 모델 객체에 담음*/
		model.addAttribute("count", count);				
		
		/*반환될 뷰페이지*/
		return "board/boardlist";
	}
	
	/*url매핑*/
	@RequestMapping("/add_board")
	/*게시글 추가 함수*/        /*브라우저에서 넘어온 파람을 해당 변수에 담음*/
	public String AddBoard(@RequestParam(value="title",required=false) String title,
			@RequestParam(value="content",required=false) String content,
			@RequestParam(value="nick",required=false) String nick,
			@RequestParam(value="reqfiles",required=false) MultipartFile[] reqfiles) throws IllegalStateException, IOException {
		
		System.out.println(title);
		System.out.println(content);
		System.out.println(nick);
		System.out.println(reqfiles);
		
		/*넘어온 파일들의 이름을 담기위한 빌더 객체 생성*/
		StringBuilder builder = new StringBuilder();
		
		/*게시글을 작성후 요청이 오면 파일을 첨부했든 안했든 reqfiles에
		값이 들어가기 때문에 게시글 작성전인지 후인지 체크*/
		if(reqfiles!=null) {
			/*reqfiles 배열에 있는 값들을 file 변수에 담음*/ 
			for(MultipartFile file : reqfiles) {
				System.out.println(file.getSize());
				/*file변수에 파일이 담겨있는지 확인*/
				if(file.getSize()==0) {
					break; /*파일이 담겨있지 않으면 포문 종료*/ 
				}
				/*파일의 이름을 구해 구분인,와 함께 빌더에 담아준다*/
				String filename= file.getOriginalFilename();
				builder.append(filename+",");
				/*워크스페이스 경로가 아닌 실제 프로젝트 배포 후 파일이 저장될 경로를 알아야함*/
				/*파일이 저장될 실제 경로를 구해 파일이름과 합침*/				
				String realpath = sc.getRealPath("/resources/board"); 
				realpath += File.separator + filename;
				System.out.println(realpath);
				/*실제 경로에 파일을 담기위해 파일 객체 생성*/
				File savefile = new File(realpath);
				/*해당 경로에 파일을 만들어준다*/
				file.transferTo(savefile);
			}
			
		}
		
		/*빌더에 파일이름이 담기면 맨 마지막 파일이름 뒤에 콤마를 제거*/
		if(!builder.toString().equals("")) {
			builder.delete(builder.length()-1, builder.length());
		}
		
	    /*빌더에 저장된 값을 db에 보내기 위한 변수에 담음*/ 
		String files = builder.toString();
		
		/*파라미터 값이 널이 아니면 서비스 함수 실행 후 게시판목록으로 리턴*/
		/*빈값은 뷰단에서 막는다*/  
		if(title!=null&&content!=null&&nick!=null) {
			/* 넘겨받은 파라미터를 서비스함수로 넘겨준다*/
			boardservice.ServiceAddBoard(title,content,files,nick);
			
			/*게시글 목록을 재 요청*/  
			return "redirect:/board/boardlist";
		}
						
		return "board/add_board";
	}
	
	/*url 매핑*/
	@RequestMapping("/detailed_board")
	/*게시글을 조회하기 위한 함수*/    /*게시글 넘버의 파라미터를 받는다*/
	public String DetailedBoard(@RequestParam(value="num")int num,
			Model model) {
		/*서비스함수에서 넘어온 게시글 데이터를 board에 담음*/
		Board board = boardservice.ServiceDetail(num);
		/*모델 객체에 board 담음*/
		model.addAttribute("board",board);
		
		return "board/detailed_board";
	}
	
}
