package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/el_jstl")
public class ELJstlServlet extends HttpServlet {

	//ctrl space 치면 나옴
	//GET방식 요청시
	//지정된 JSP로 바로 요청 위임
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1) JSP경로 (webapp 폴더 기준)
		String path = "/WEB-INF/views/el_jstl.jsp";
		
		// 2) 요청 발송자 얻어오기
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		// 3) 요청 위임(forward)
		dispatcher.forward(req, resp);
	}
}
