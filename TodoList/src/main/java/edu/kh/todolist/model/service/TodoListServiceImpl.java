package edu.kh.todolist.model.service;

import java.util.List;

import edu.kh.todolist.model.dao.TodolistDAO;
import edu.kh.todolist.model.dao.TodolistDAOImpl;
import edu.kh.todolist.model.dto.Todo;

public class TodoListServiceImpl implements TodoListService {

	private TodolistDAO dao = null; //변수 선언
	
	//기본생성자
	public TodoListServiceImpl() {
		// TodoListServiceImpl 객체 생성 시
		// TodoListDAO 객체 생성
		dao = new TodolistDAOImpl();
	}
	
	@Override
	public List<Todo> todoListFullView() {
		// DAO 호출
		
		// 할 일 목록 얻어오기 -> 반환
		List<Todo> todoList = dao.todoListFullView();
		
		return todoList;
	}
	
	@Override
	public int todoAdd(String title, String detail) {
		//Todo 객체 만들기
		Todo todo = new Todo(title, detail);
		
		//dao 메서드 호출 -> 반환한 값 -> controller 반환
		//int index = dao.todoAdd();
		return dao.todoAdd(todo);
	}

}
