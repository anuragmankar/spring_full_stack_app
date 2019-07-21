package com.maku.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Roles {

	@Id
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLES",joinColumns = {
			@JoinColumn(name = "ROLE_NAME",referencedColumnName = "name")
	},inverseJoinColumns = {
		 @JoinColumn(name = "USER_EMAIL",  referencedColumnName = "email" )
	})
	private List<User> users;
	
	public Roles() {
	}
	
	public Roles(String name) {
		super();
		this.name = name;
	}

	public Roles(String name, List<User> users) {
		this.name = name;
		this.users = users;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
