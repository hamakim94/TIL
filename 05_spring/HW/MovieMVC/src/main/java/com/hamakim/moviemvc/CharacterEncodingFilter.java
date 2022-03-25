package com.hamakim.moviemvc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 어떤 요청이 서블릿으로 가기 전에 수행해야 될 작업
		request.setCharacterEncoding("utf-8");
		System.out.println("이 요청은 제가 encoding UTF-8 해드림");
		// 이렇게 해야 쏴줌
		chain.doFilter(request, response);
		// 갔다 옴...
		System.out.println("어때 내가 encoding 해주니 편하지");

		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}



}
