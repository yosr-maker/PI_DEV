package com.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.Admin;
import com.esprit.spring.repository.AdminRepository;

@RestController

public class AdminController {
	
	
	@Autowired
	AdminRepository adminRepository;
	
	@PostMapping("/add-admin")
	@ResponseBody
	public Admin addAdmin(Admin a) {
		return	adminRepository.save(a);

}
}