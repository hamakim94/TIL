package com.hamakim94.board.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.hamakim94.board.controller.LoginCheckInterceptor;

@Configuration // 약간, servlet-context가 여기로 넘어오네...
@EnableWebMvc // 스프링 자체 설정보다 더 우선순위 높게, 여기서 다 설정~
public class WebConfig implements WebMvcConfigurer {

	@Value("${spring.mvc.view.prefix}") // application.properties 키값이랑 연결 가능
	private String prefix;
	@Value("${spring.mvc.view.suffix}")
	private String suffix;

	// 내가 직접 BeanNameViewResolver를 등록 => 이걸 등록해놔
	// @Bean이라고 하면, 반환하는 객체가 spring이 관리하는 bean으로 등록함
	@Bean
	public ViewResolver beanViewResolver() {
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(0);
		return resolver;
	}

	@Bean
	public ViewResolver internalViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(prefix);
		resolver.setSuffix(suffix);
		return resolver; // 해당 객체를 반환하면 됨 : bean으로?
	}

	/*
	 * <!-- 3.여기로 가서 실행해줘! --> <beans:bean class =
	 * "com.ssafy.board.controller.LoginCheckInterceptor" id = "confirms">
	 * </beans:bean> <interceptors> <interceptor> <mapping path =
	 * "/board/*"></mapping> <!-- 1.board 안에 들어가려면 confirm이라는 빈이 가로채감 --> <beans:ref
	 * bean = "confirms"/> <!-- 2.id가 confirm이라는 bean 실행시켜줘, --> </interceptor>
	 * </interceptors>
	 */
	@Autowired // LoginCheckInterceptor를 Component, bean으로 등록해놔서 바로 가져와짐
	LoginCheckInterceptor confirm; //

	@Override // 인터셉터 등록하는 함수 Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(confirm).addPathPatterns("/board/*");
	}

	// resource 부분 채우기
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 아래거 하면 위에 img 필요 합니까?
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}

}
