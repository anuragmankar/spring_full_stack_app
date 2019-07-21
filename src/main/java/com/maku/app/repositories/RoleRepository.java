package com.maku.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maku.app.entities.Roles;

public interface RoleRepository extends JpaRepository<Roles, String>{

}
