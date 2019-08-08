package com.maku.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.maku.app.entities.Task;
import com.maku.app.entities.User;
import com.maku.app.services.TaskService;
import com.maku.app.services.UserService;

@Controller
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/addTask")
	public String taskForm(String email, Model model, HttpSession session)
	{
		if(email == null || email.isEmpty()) {
			return "redirect:/users";
		}
		model.addAttribute("task", new Task());
		session.setAttribute("email", email);
		return "views/taskForm";
	}
	
	@PostMapping("/addTask")
	public String addTask(@Valid Task task,BindingResult bindingResult,Model model,HttpSession session)
	{
		if(bindingResult.hasErrors())
		{
			return "views/taskForm";
		}
		String email = (String)session.getAttribute("email");
		User user = userService.findOne(email);
		if(user == null)
		{
			model.addAttribute("userNotExists", true);
			return "views/taskForm";
		}
		taskService.addTask(task, userService.findOne(email));
		return "redirect:/users";
	}
}
