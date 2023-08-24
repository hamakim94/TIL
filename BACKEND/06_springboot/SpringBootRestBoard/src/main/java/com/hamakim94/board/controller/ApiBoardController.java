package com.hamakim94.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hamakim94.board.model.dto.Board;
import com.hamakim94.board.model.service.BoardService;

@RestController
@RequestMapping("/api")
public class ApiBoardController {
	@Autowired
	private BoardService boardService;

	@Autowired
	private ServletContext servletContext;

	// 이렇게 하면 /board/list
	@GetMapping("/board")
	public ResponseEntity<List<Board>> list(@RequestParam(defaultValue = "") String mode,
			@RequestParam(defaultValue = "") String keyword) {

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("mode", mode);
		params.put("key", keyword);
		return new ResponseEntity<List<Board>>(boardService.getBoardList(params), HttpStatus.OK);
	}

	// 이렇게 하면 /board/list
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable int id) {
		
		return new ResponseEntity<Board>(boardService.readBoard(id), HttpStatus.OK);
	}

	@PostMapping("/board")
	public ResponseEntity<String> create(Board board, MultipartFile upload_file) {
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
		return new ResponseEntity<String>("SUCESS", HttpStatus.CREATED);

	}

	@DeleteMapping("/board/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int idd) {
		boardService.deleteBoard(idd);
		return new ResponseEntity<String>("DELETE SUCCESS", HttpStatus.NO_CONTENT);
	}

	// 여기선 보드 객체 자체를받아야함. 그래야 덮어씌우지.
	@PutMapping("/board")
	public ResponseEntity<String> update(Board board) {
		boardService.modifyBoard(board);
		return new ResponseEntity<String>("PUT SUCCESS", HttpStatus.OK);
	}

}
