package com.practise.loginpage.logindemo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.practise.loginpage.logindemo.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String showTodoList(ModelMap model) {
		
		String name = (String)model.get("name");
		
		model.put("todoList", todoService.retrieveTodos(name));
		return "list-todo";
	}
	
	//method to add a to do 
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		return "add-todo";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addTodo(ModelMap model, @RequestParam String desc) {
		String name = (String)model.get("name");
		todoService.addTodo(name, desc, new Date(), false);
		return "redirect:/list-todos";
	}
	
	

}
