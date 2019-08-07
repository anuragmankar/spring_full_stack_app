package com.maku.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.maku.app.entities.Role;
import com.maku.app.entities.User;
import com.maku.app.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public void createUser(User user)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}
	
	public void createAdmin(User user)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}
	
	public User findOne(String email)
	{
		Optional<User> userData=userRepository.findById(email);
		if(userData.isPresent())
			return userData.get();
		else 
			return null;
	}

	public boolean isUserPresent(@Valid User user) {
		Optional<User> userData=userRepository.findById(user.getEmail());
		if(userData.isPresent())
			return true;
		else 
			return false;
	}


	public List<User> findByName(String name) {
		
		return userRepository.findByNameLike("%"+name+"%");
	}
}
