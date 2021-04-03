package com.esprit.spring.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.User;

import com.esprit.spring.repository.UserRepository;




@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	
	
	
	public User addUser(User user) {
		User newuser = new User();
		newuser.setUsername(user.getUsername());
		newuser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newuser.setFirstName(user.getFirstName());
		newuser.setLastName(user.getLastName());
		newuser.setEmail(user.getEmail());
		newuser.setRole(user.getRole());
		return userRepo.save(newuser);
	}

	public User findUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}


	public User findbyid(long id) {

		return userRepo.findById(id).get();
	}


	public List<User> mylist() {

		return (List<User>) userRepo.findAll();
	}

	public void deleteUser(long id) {

		userRepo.deleteById(id);

	}
	
	public User authenticate(String username, String email) {
		User u = userRepo.findByUsernameAndEmail(username, email);
		return u;
	}


}
