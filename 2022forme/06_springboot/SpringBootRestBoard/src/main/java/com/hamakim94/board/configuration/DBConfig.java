package com.hamakim94.board.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

// xml을 안 쓰니까, 환경설정 할 때 java class를 이용한다
// 데이터베이스 연관 환경 설정
// 매퍼 등록은 했고, datasource 등록 했어 -> 연결은 여기서 한다.
@Configuration
@MapperScan(basePackages = "com.hamakim94.board.model.dao")
public class DBConfig {}
