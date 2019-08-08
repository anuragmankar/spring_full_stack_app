package com.maku.app;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.maku.app.entities.Task;
import com.maku.app.entities.User;
import com.maku.app.services.TaskService;
import com.maku.app.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFullStackAppApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	
	@Before
	public void initDb() {
		{
			User newUser = new User("testUser@email.com", "testUser", "1234556");
			userService.createUser(newUser);
		}
		{
			User newUser = new User("testAdmin@email.com", "testAdmin", "1234556");
			userService.createAdmin(newUser);
		}
		
		Task userTask = new Task("27-07-2019","00:11","11:00", "YOu need to work today");
		User user = userService.findOne("testUser@email.com");
		taskService.addTask(userTask, user);
	}
	
	
	@Test
	public void testUser()
	{
		User user = userService.findOne("testUser@email.com");
		assertNotNull(user);
		User admin = userService.findOne("testAdmin@email.com");
		assertNotNull(admin);
	}
	
	@Test
	public void testTask()
	{
		User user = userService.findOne("testUser@email.com");
		List<Task> userTasks = taskService.findUserTask(user);
		assertNotNull(userTasks);
		
	}

	
}
