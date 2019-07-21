package com.maku.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maku.app.entities.Task;

public interface TaskRepositiory extends JpaRepository<Task, Long> {

}
