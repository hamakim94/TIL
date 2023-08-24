package com.hamakim94.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	// 내가 만들지 않은 객체들은 다 사라지게 하는 매법!
	
	// 스웨거 : 설정 정보를 갖고 있는 빈을 찾는다
	// 근데 독켓이라는 형태가 필요??
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
				// ApiSelectorBuilder라는 객체 하나 가져와서
				.select()
				// ApiSelectorBuilder : 해당 패키지로 거르고
				.apis(RequestHandlerSelectors.basePackage("com.hamakim94.swagger.controller"))
				//ApiSelectorBuilder : 어떤 uri 경로를 거르고
				.paths(PathSelectors.ant("/api/**"))
				// Docket
				.build() // 맹글어!
				// swagger 맨 위에 샤라락 나옴 
				.apiInfo(apiInfo()) // 따로 빼는 이유는 설정 많아
				; 
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
		// ApiInfoBuilder()
		.title("Hamakim Swagger")
		.description("Hamakim backend Swagger API Test")
		.version("v1")
		.build();
		
	}
}
