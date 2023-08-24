package com.hamakim94.board.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hamakim94.board.dao.BoardDao;
import com.hamakim94.board.dto.Board;


@WebServlet("/board/write")
public class WriteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ㄴ ㅓ글작성 페이지가 필요하구나 거기로 보내줄게
		request.setAttribute("board", new Board("제목", "글쓴이", "내용"));
		request.getRequestDispatcher("write.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 너 글 작성 했고 submit 버튼을 눌렀구나 등록해줄게
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title"); 
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
				
		Board b = new Board(title, writer, content);
		
		// 나의 리스트에 저장을 해보자
		BoardDao.getInstance().insertBoard(b);
				
		// list 화면으로
		// request.getRequestDispatcher("list").forward(request, response);
		// 위와 같이 하면 오류남
		
		// 페이지 이동, reDirect는 다른 프로젝트 혹은 다른 사이트로 이동이 가능!
		response.sendRedirect("list");
		// 프로젝트의 페이지를 호출할 때 /로 시작하는 경우는 포트번호 이후의 주소를 다 써줘여함
	}

}
