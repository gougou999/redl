package ene.redl.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello")
	public String hello(Model model){
		model.addAttribute("name", "This is a test!");
		return "hello";
	}
	
	@RequestMapping(value="/login-page")
	public String loginPage(Model model){
		model.addAttribute("name", "This is a test!");
		return "login";
	}
	
	@RequestMapping(value="/login")
	public String login(User user, Model model){
		System.out.println("用户名：" +user.getUsername());
		System.out.println("密码：" +user.getPassword());
		model.addAttribute("user", user);
		List<User> users = new ArrayList<User>();
		users.add(user);
		users.add(user);
		users.add(user);
		model.addAttribute("users", users);
		return "success";
	}
	
}
