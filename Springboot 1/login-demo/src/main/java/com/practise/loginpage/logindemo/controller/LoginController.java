package com.practise.loginpage.logindemo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.practise.loginpage.logindemo.service.LoginService;


@Controller
@SessionAttributes("name")
public class LoginController {

	@Autowired
	LoginService loginservice;
	
	//initbinder to format the date across the application
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		model.put("name", name);
		model.put("password", password);
		
		if(!loginservice.validateUser(name,password)) {
			model.put("errorMessage", "Invalid User");
			return "login";
		}
		
		return "welcome";
	}
	
	
	/*@RequestMapping("/logout")
	public String logoutMessage(@RequestParam String place, ModelMap model) {
		
		model.put("place", place);
		return "logout";
	}
	*/
	
}
