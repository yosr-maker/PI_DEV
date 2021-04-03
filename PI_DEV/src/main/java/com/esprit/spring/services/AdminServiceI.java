package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Admin;


public interface AdminServiceI {

	List<Admin> retrieveAllAdmins();
	Admin addAdmin(Admin a);
	void deleteAdmin (String id);
	Admin updateAdmin(Admin a);
	Admin retrieveAdmin(String id);
	

}
