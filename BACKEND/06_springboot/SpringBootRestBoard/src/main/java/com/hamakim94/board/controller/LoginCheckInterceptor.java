package com.hamakim94.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



@Component
public class LoginCheckInterceptor implements HandlerInterceptor{
	private static final Logger logger = LoggerFactory.getLogger(LoginCheckInterceptor.class);
	@Override
	// servlet-context에서 /board/* 로 접근하면 인터셉터가 request를 가로챔. 등록된
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		// 세션에 username이라는 속성의 값이 없다면
		if(session.getAttribute("username") == null) {
			logger.debug("로그인안됨"); // 응안대
			response.sendRedirect(request.getContextPath() + "/user/login"); // 로그인 페이지로 가벼렷!
			return false;
		}
		return true;
	}
	
}
