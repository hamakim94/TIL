package com.hamakim94.board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hamakim94.board.dao.BoardDao;
import com.hamakim94.board.dto.Board;


@WebServlet("/board/list")
public class ListBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 등록 되어 있는 게시글을 전부 읽어와서 그 친구를 list.jsp로 보내주면 좋겠음
		BoardDao dao = BoardDao.getInstance();
		List<Board> list = dao.selectBoard();
		// list.jsp에 실제 내 데이터를 실어서 전달할래
		request.setAttribute("list", list);
		// request.setAttribute("list", BoardDao.getInstance().selectBoard());
		
		// JSP페이지에 이동, list.jsp의 풀 주소는 무엇인가
		// http://localHost:8080/Board/board/list.jsp
		// forward는 같은 프로젝트 내에서만 페이지 이동이 가능하다.
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/board/list.jsp").forward(req, resp);
	}
	
}
