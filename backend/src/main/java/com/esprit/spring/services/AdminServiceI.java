package com.esprit.spring.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.esprit.spring.entites.Admin;


public interface AdminServiceI {

	
	UserDetails loadAdminByUsername(String username) throws UsernameNotFoundException;

	Admin addAdmin(Admin admin);

	Admin retrieveAdmin(long id);

	List<Admin> retrieveAllAdmins();

	void deleteAdmin(long id);

	Admin updateAdmin(Admin a);
	

}
