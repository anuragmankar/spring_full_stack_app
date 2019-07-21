package com.maku.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maku.app.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}
