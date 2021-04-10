package com.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Admin;

import com.esprit.spring.repository.AdminRepository;



@Service
public class AdminService implements AdminServiceI {
	

	@Autowired
	 AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
        @Override

	    public Admin addAdmin(Admin admin) {
	    Admin newadmin = new Admin();
		newadmin.setUsername(admin.getUsername());
		newadmin.setPassword(bcryptEncoder.encode(admin.getPassword()));
		newadmin.setFirstName(admin.getFirstName());
		newadmin.setLastName(admin.getLastName());
		newadmin.setEmail(admin.getEmail());
		newadmin.setCin(admin.getCin());
		newadmin.setPhoneNumber(admin.getPhoneNumber());
		newadmin.setRole(admin.getRole());
		newadmin.setDateNaissance(admin.getDateNaissance());
		return adminRepository.save(newadmin);
	}

	public Admin findAdminByUsername(String username) {
		return adminRepository.findByUsername(username);
	}
	
	
	@Override
	public UserDetails loadAdminByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByUsername(username);
		if (admin == null) {
			throw new UsernameNotFoundException("Client not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(admin.getUsername(), admin.getPassword(),
				new ArrayList<>());
	}

	@Override
	public Admin retrieveAdmin(long id) {

		return adminRepository.findById(id).get();
	}

	@Override
	public List<Admin> retrieveAllAdmins() {

		return (List<Admin>) adminRepository.findAll();
	}
	@Override
	public void deleteAdmin(long id) {

		adminRepository.deleteById(id);

	}
	
	public Admin authenticate(String username, String email) {
		Admin a  = adminRepository.findByUsernameAndEmail(username, email);
		return a;
	}


	
	@Override
	public Admin updateAdmin(Admin a) {
		adminRepository.save(a);
		return a;
	}
	
}






	


