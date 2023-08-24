package com.hamakim94.swagger.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hamakim94.swagger.model.dto.Board;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;
//@ApiIgnore 안 보이게
@Api(tags = "게시글")
@RestController
@RequestMapping("/api")
// @CrossOrigin("*") // 모든 오리진 사이트가 쓸 수 있게 해주겠다 이말이야
public class BoardController {
	@ApiOperation(
			value = "게시글 조회",
			notes = "페이지에 해당하는 게시물을 조회합니다"
			)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "pageNo", value = "페이지 번호", required = true),
		@ApiImplicitParam(name = "key", value = "제목 | 내용 | 제목 + 내용"),
		@ApiImplicitParam(name = "word", value = "검색어")
	})
	@GetMapping("/board")
	public ResponseEntity<List<Board>> retrieveBoard(
			 int pageNo, String key,String word	) {

		return new ResponseEntity<List<Board>>(
				Arrays.asList(
						new Board(1, "hamakim", "swager", "swaggerfun"),
						new Board(2, "hamakim2", "swager2", "swagger is fun")
						), 
				HttpStatus.OK
				);

	}
}
