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
	public String list(Model model, @RequestParam(defaultValue = "") String mode,
			@RequestParam(defaultValue = "") String keyword) {

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("mode", mode);
		params.put("key", keyword);

		List<Board> list = boardService.getBoardList(params);
		model.addAttribute("list", list);
		return "board/list"; 
	}

	@GetMapping("writeForm")
	public String writeForm() {
		return "board/writeform";
	}

	@PostMapping("write")
	public String write(Board board, MultipartFile upload_file) {
		if (upload_file.getSize() != 0) {
			// 원래 경로에서 뒤에 /file 경로 붙이기
			String uploadPath = servletContext.getRealPath("/file");
			// 해당 경로에 파일 넣기 위해 파일 이름 가져오고
			String fileName = upload_file.getOriginalFilename();
			// 이름이 같은 경우에 어떡할래. 그래서 고유한 UUID를 활용해서 이름을 정해줄래~
			String saveName = UUID.randomUUID() + "";

			// 아경로에 이 파일명으로 저장하기 위해 파일 객체를 만들었고.
			File target = new File(uploadPath, saveName);
			// 이 폴더가 없으면 만들어줘
			// uploadpath가 담겨있는 파일 객체를 만들었는데 폴더가 존재하고 
			if (!new File(uploadPath).exists()) {
				// 대충 폴더 만드샘. 폴더니까, 객체겠지? ㅋㅋ 
				new File(uploadPath).mkdirs();
			}

			try { // 첨부파일의 바이트 내용을 target에다 써낸다.
				FileCopyUtils.copy(upload_file.getBytes(), target);
				board.setFileName(fileName);
				board.setFileUri(target.getCanonicalPath()); // 쓸데없는거 뺀 절대경로.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		boardService.writeBoard(board);
		// 여기서, redirect방식으로 /board/board/list로보내면 다시 이 서블릿으로 오고
		// mode, keyword가 defaultValue인 ""로 되기 때문에, params에 아무것도 안 들어와서 전체 리스트를 가져온다.
		return "redirect:/board/list"; // get방식, url로 접근하니까.
		// forward(객체를 가진 상태에서 다른 페이지로) vs redirect(재시작, 가지고있는거 다 지워) 
		// '/'가 있으면 ViewResolver가 안해줌. => '/'가 있으면 서블릿 컨텍스트가 가로챔.
	}
	
	@GetMapping("detail")// list.jsp에서 제목 a tag가 /board/detail?id=${board.id}로 들어오니. : GET방식
	// 쿼리스트링  : key : id , value : ${board.id} 느낌. 그래서 int id 손을 벌림 => key를 가리키는 것! YEAH..
	public String detail(Model model, int id){
		
		Board board = boardService.readBoard(id); // board 가져와서, 만약 board자체의 id가 들어왔더면 이건 필요가 없겠지..
		model.addAttribute("board", board); // model 새로 가져온 board 객체를 넣어줘서
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
	
	@GetMapping("delete")
	public String delete(int id) {
		boardService.deleteBoard(id);
		return "redirect:/board/list";
	}
	
	@PostMapping("update")
	public String update(Board board) {
		boardService.modifyBoard(board);
		return "redirect:/board/detail?id=" + board.getId();
	}

}
