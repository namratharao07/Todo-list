package com.practise.loginpage.logindemo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.practise.loginpage.logindemo.model.Todo;

@Service
public class TodoService {
	
	private static List<Todo> todoList = new ArrayList<Todo>();
	private static int todoCount = 3;
	
	static {
        todoList.add(new Todo(1, "namratha", "Sapiens", new Date(),
                false));
        todoList.add(new Todo(2, "namratha", "thinking faslt and thinking slow", new Date(), false));
        todoList.add(new Todo(3, "namratha", "the selfish gene", new Date(),
                false));
    }

	public List<Todo> retrieveTodos(String user){
		List<Todo> todosByUser = new ArrayList<Todo>();
		
		for(Todo todo : todoList) {
			if(todo.getUser().equals(user)) {
				todosByUser.add(todo);
			}
		}
		return todosByUser;	
	}
	
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todoList.add(new Todo(++todoCount, name,desc,targetDate, isDone));
	}
	
	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todoList.iterator();
		while(iterator.hasNext()) {
			Todo todo = iterator.next();
			if(todo.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public Todo retrieveTodo(int id) {

		for(Todo todo : todoList) {
			if(todo.getId() == id) {
				return todo;
			} 
		}	
		return null;
	}
	
	public void updateTodo(Todo todo) {
		todoList.remove(todo);
		todoList.add(todo);
	}
	
}
