package com.maku.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maku.app.entities.Task;
import com.maku.app.entities.User;

public interface TaskRepositiory extends JpaRepository<Task, Long> {

	List<Task> findByUser(User user);

}
