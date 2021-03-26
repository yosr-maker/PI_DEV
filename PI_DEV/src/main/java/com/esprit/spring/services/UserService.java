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
import com.esprit.spring.entites.Userinfo;
import com.esprit.spring.repository.UserRepository;


@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	
	
	
	public User addUser(Userinfo user) {
		User newuser = new User();
		newuser.setUsername(user.getUsername());
		newuser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newuser.setFirstName(user.getFirstName());
		newuser.setLastName(user.getLastName());
		newuser.setEmail(user.getEmail());
		newuser.setRole(user.getRole());
		return userRepository.save(newuser);
	}

	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	//NEW ONE 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}


	public User findbyid(long id) {

		return userRepository.findById(id).get();
	}


	public List<User> mylist() {

		return (List<User>) userRepository.findAll();
	}

	public void deleteUser(long id) {

		userRepository.deleteById(id);

	}
	
	public User authenticate(String username, String email) {
		User u = userRepository.findByUsernameAndEmail(username, email);
		return u;
	}



}

	
	
	