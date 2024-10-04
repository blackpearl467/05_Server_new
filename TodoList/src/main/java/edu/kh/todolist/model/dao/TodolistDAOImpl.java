package edu.kh.todolist.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.kh.todolist.model.dto.Todo;

public class TodolistDAOImpl implements TodolistDAO{

	//필드
	//C:/servlet_todoList_data/TodoList.dat
	private final String FILE_PATH = "/servlet_todoList_data/TodoList.dat";
	
	private List<Todo> todoList = null;
	
	private ObjectOutputStream oos = null; //객체 출력용 스트림
	private ObjectInputStream ois = null; //객체 입력용 스트림
	
	
	//기본생성자
	public TodolistDAOImpl() throws Exception{//throws로 다 잡아서 던지고 있음
		
		//TodoList.dat 파일이 없으면 새로운 List 생성, 있으면 읽어오기
		File file = new File(FILE_PATH);
		
		if(!file.exists()) {//파일이 존재하지 않는다면 !not연산자
			
			todoList = new ArrayList<Todo>();
			
			todoList.add(new Todo("Servlet 공부", "수업 내용 복습하기11"));
			todoList.add(new Todo("JSP 공부", "수업 내용 복습하기22"));
			todoList.add(new Todo("TodoList 만들기", "수업 내용 복습하기33"));
			
		} else { //파일이 이미 존재한다면
			//외부 파일에 작성된 List<Todo> 객체를 입력받아 todoList 대입
			
			try {
				 ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				 todoList = (ArrayList<Todo>) ois.readObject();
				
			} finally {
				if(ois != null) ois.close();
			}
		}
	}
	
	@Override
	public void saveFile() throws Exception{
		//예외는 throws로 던져버리기 때문에 catch문 불필요
		
		try {
			oos=new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(todoList);
			
		} finally {
			if(oos != null) oos.close();
		}
	}
	
	
	@Override
	public List<Todo> todoListFullView() {
		return todoList;
	}




	@Override
	public int todoAdd(Todo todo) throws Exception{
	
		if(todoList.add(todo)) {
			saveFile(); //외부파일로 출력
			return todoList.size() -1; //마지막인덱스번호 반환
		}
		
		return -1;
	}

	
	
}
