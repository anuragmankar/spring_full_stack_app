package com.maku.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maku.app.entities.Task;
import com.maku.app.entities.User;
import com.maku.app.repositories.TaskRepositiory;

@Service
public class TaskService {

	@Autowired
	TaskRepositiory taskRepositiory;
	
	public void addTask(Task task, User user)
	{
		task.setUser(user);
		taskRepositiory.save(task);
	}
	
	public List<Task> findUserTask(User user)
	{
		return taskRepositiory.findByUser(user);
	}
}
