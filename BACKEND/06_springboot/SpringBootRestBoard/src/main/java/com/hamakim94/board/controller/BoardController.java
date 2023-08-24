package com.hamakim94.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hamakim94.board.model.dto.Board;
import com.hamakim94.board.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController { 
	
	@Autowired
	private BoardService boardService;

	@Autowired
	private ServletContext servletContext;

	// 이렇게 하면 /board/board/list
	@GetMapping("list")
	public String list() {
		return "board/list"; 
	}

	@GetMapping("writeForm")
	public String writeForm() {
		return "board/writeform";
	}

	
	
	@GetMapping("detail")// list.jsp에서 제목 a tag가 /board/detail?id=${board.id}로 들어오니. : GET방식
	// 쿼리스트링  : key : id , value : ${board.id} 느낌. 그래서 int id 손을 벌림 => key를 가리키는 것! YEAH..
	public String detail(Model model, int id){
		Board board = boardService.getBoardById(id);
		model.addAttribute("board", board);
		return "board/detail"; // 디테일로 가렴(바로 /WEB-INF/......detail.jsp로 가!
		
	}
	// 준비물 : servlet-context에서 
	// <beans:bean class = "com.ssafy.board.controller.FileDownLoadView" id = "fileDownLoadView" ></beans:bean>
	// <beans:bean class = "org.springframework.web.servlet.view.BeanNameViewResolver"> 설정
	// BeannameViewResolver에서 너 새로운 아이디로 등록한 빈 있으면, /로 가지 말고 다른 곳으로 가게 해줄게!
	// 그래서 위에있는 id=fileDownLoadView 로 등록된 빈 객체에 model 속성을 넣어서 결과 만들어줌. 
	// 그리고 인터넷 검색.(해당 경로 파일 채우기)
	@GetMapping("download")
	public String download(Model model, int id) {
		Board board = boardService.getBoardById(id);
		model.addAttribute("fileuri", board.getFileUri());
		model.addAttribute("filename", board.getFileName());
		return "fileDownLoadView";
	}
	
	@GetMapping("updateForm")
	public String updateForm(Model model, int id) {
		Board board = boardService.getBoardById(id);
		model.addAttribute("board", board);
		return "board/updateform"; 
	}
	
	
	
	

}
