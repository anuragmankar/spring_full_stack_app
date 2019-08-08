package com.maku.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.maku.app.entities.User;
import com.maku.app.services.TaskService;
import com.maku.app.services.UserService;

@Controller
public class ProfileController {

	
	@Autowired
	TaskService taskService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/profile")
	public String getUserProfile(Model model, Principal principal)
	{
		String email = principal.getName();
		User user = userService.findOne(email);
		model.addAttribute("tasks", taskService.findUserTask(user));
		
		return "views/profile";
	}
	
}
