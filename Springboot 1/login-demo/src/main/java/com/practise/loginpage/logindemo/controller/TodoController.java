package com.practise.loginpage.logindemo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.practise.loginpage.logindemo.model.Todo;
import com.practise.loginpage.logindemo.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	//initbinder to format the date across the application
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	
	/***** Display Todo List for the logged in user *****/	
	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String showTodoList(ModelMap model) {
		
		String name = (String)model.get("name");
		
		model.put("todoList", todoService.retrieveTodos(name));
		return "list-todo";
	}
	
	
	/***** Add a Todo to the list of Todo(todoList) of the logged in user *****/
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0,(String)model.get("name"),"Default desc",new Date(),false));
		return "add-todo";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "add-todo";
		}
		
		String name = (String)model.get("name");
		String desc = todo.getDesc();
		todoService.addTodo(name, desc, todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}
	
	
	/***** Delete a Todo from the list of Todo(todoList) for the logged in user *****/
	@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	/***** Update the selected Todo to the list of Todo(todoList) of the logged in user *****/	
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {	
		Todo todo = todoService.retrieveTodo(id);
		model.put("todo", todo);
		return "update-todo";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result ) {

		if(result.hasErrors()) {
			return "/update-todo";
		}
		todo.setUser((String)model.get("name"));
		todoService.updateTodo(todo);	
		return "redirect:/list-todos";
	}
	
	

}











