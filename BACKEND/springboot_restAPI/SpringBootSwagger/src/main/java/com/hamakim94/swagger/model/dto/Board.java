package com.hamakim94.swagger.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "BoardDTO", description = "게시글 정보를 표현한다.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	@ApiModelProperty(value = "게시글 고유 번호", example = "10")
	private int id;
	private String writer;
	private String title;
	private String content;
	
}
