package com.maku.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maku.app.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String>{

}
