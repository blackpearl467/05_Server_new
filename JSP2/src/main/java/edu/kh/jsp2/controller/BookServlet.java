package edu.kh.jsp2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp2.dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book/list")
public class BookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 요청 처리
		
		//Book으로 타입이 제한된 List 생성
		List<Book> bookList = new ArrayList<Book>();
		
		//bookList에 데이터 추가
		bookList.add(new Book("자바 공부", "피촌투", 10000));
		bookList.add(new Book("HTML 공부", "꼬부기", 20000));
		bookList.add(new Book("JS 공부", "이상해씨", 14900));
		bookList.add(new Book("CSS 공부", "지우", 15000));
		bookList.add(new Book("Servlet이란", "파이리", 18200));
		bookList.add(new Book("JSP란", "피카츄", 13400));
		bookList.add(new Book("Spring이란", "버터풀", 19000));
		
		//bookList를 요청 위임된 JSP에서도
		//유지되어 사용할 수 있도록
		//request scope 객체에 속성으로 추가(세팅)
		req.setAttribute("bookList", bookList);
		
		
		
		// 응답 처리
		
		//JSP로 요청 위임(webapp 폴더 기준)
		String path = "/WEB-INF/views/book/bookList.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
}
