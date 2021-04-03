package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.User;



public interface UserServiceI {
	List<User> retrieveAllUseraccounts();
	User addUseraccount(User u);
	void deleteUseraccount (String id);
	User updateUseraccount(User u);
	User retrieveUseraccount(String id);
	User loadUserByLogin(String login) ;

}
