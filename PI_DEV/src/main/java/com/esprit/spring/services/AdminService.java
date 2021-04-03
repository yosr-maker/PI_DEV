package com.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Admin;
import com.esprit.spring.repository.AdminRepository;



@Service
public class AdminService implements AdminServiceI {
	

		@Autowired
		AdminRepository adminRepository;
		private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(AdminService.class);


	@Override
	public Admin addAdmin(Admin a) {
		return	adminRepository.save(a);
		
	}

	@Override
	public void deleteAdmin(String id) {
		adminRepository.deleteById(Long.parseLong(id));
		
	}


	@Override
	public Admin updateAdmin(Admin a) {
		 return adminRepository.save(a);
		
	}

	@Override
	public Admin retrieveAdmin(String id) {
		Admin a  =adminRepository.findById(Long.parseLong(id)).orElse(null);
			return a;
	}
	@Override
	public List<Admin> retrieveAllAdmins() {
		List<Admin> admins = (List<Admin>) adminRepository.findAll();
		for (Admin admin: admins){
			l.info("les admins  +++ :" + admin);
		}
			
	return admins;	
	}

	}


