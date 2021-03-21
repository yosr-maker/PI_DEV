package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Useraccount;



public interface UseraccountServiceI {
	List<Useraccount> retrieveAllUseraccounts();
	Useraccount addUseraccount(Useraccount u);
	void deleteUseraccount (String id);
	Useraccount updateUseraccount(Useraccount u);
	Useraccount retrieveUseraccount(String id);

}
