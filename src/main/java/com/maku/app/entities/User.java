package com.maku.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@Email
	@NotEmpty
	@Column(unique = true)
	private String email;
	
	@NotEmpty
	private String name;
	
	@Size(min = 4)
	private String password;
	
	/*
	 * One User can have multiple tasks
	 * mappedBy here represents the owner of the relationship
	 * 			and the "user" text that should be the name of 
	 * 			User class column in Task class
	 * cascade	
	 * */
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Task> tasks;
	
	/*
	 * A user may have multiple roles and
	 * one role may belong  to many users.
	 * In many to many there is a third table too
	 * 
	 * In One to many relationship where we define
	 * mappedBy is the owner of the relationship.
	 * 
	 * In case of many to many when we specify @JoinTable
	 * marks the owner of the relationship.
	 * If we want to make both as owners  then we have to specify
	 * @JoinTable in other class and remove the "mappedBy"
	 * 
	 * inverseJoinColumns : specifies the other table referenced
	 * */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLES",joinColumns = {
			@JoinColumn(name = "USER_EMAIL",referencedColumnName = "email")
	},inverseJoinColumns = {
		 @JoinColumn(name = "ROLE_NAME",  referencedColumnName = "name" )
	})
	private List<Roles> roles;
	
	
	public User() {
		
	}
	public User(String email, String name, String password) {
		
		this.email = email;
		this.name = name;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Task> getTask() {
		return tasks;
	}
	public void setTask(List<Task> task) {
		this.tasks = task;
	}
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	

	
	
}
