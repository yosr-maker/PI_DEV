package com.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.config.JwtTokenUtil;
import com.esprit.spring.entites.Admin;

import com.esprit.spring.model.JwtRequest;
import com.esprit.spring.model.JwtResponse;
import com.esprit.spring.services.AdminService;


@RestController
public class AdminController {


	
	@Autowired
	AdminService adminService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	public static Admin ADMINCONNECTED ;
	
	@GetMapping("/bonjour-admin")
	@ResponseBody
	public String welcome() { return "Bonjour, Bienvenue à votre espace admin "; }
	

	@PostMapping("/register-admin")
	@ResponseBody
	public ResponseEntity<?> saveAdmin(@RequestBody Admin admin) throws Exception {
		System.out.println("Entring the register method ");
		return ResponseEntity.ok(adminService.addAdmin(admin));
	}

	@PostMapping("/authenticate-admin")
	@ResponseBody
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

			final UserDetails userDetails = adminService.loadAdminByUsername(authenticationRequest.getUsername());
			final Admin admin = adminService.findAdminByUsername(authenticationRequest.getUsername());
			ADMINCONNECTED = admin ;
			System.out.println(ADMINCONNECTED.getRole());


			final String token = jwtTokenUtil.generateToken(userDetails);
			System.out.println(token);
			return ResponseEntity.ok(new JwtResponse(token));
		} catch (Exception e) {
			System.out.println(e.toString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	
	
	@GetMapping("/retrieve_admins")
	@ResponseBody
	public List<Admin> getAdmins() {
	List<Admin> list = adminService.retrieveAllAdmins();
	return list;
	}
	
	@GetMapping("/retrieve-admin/admin-id}")
	@ResponseBody
	public Admin retrieveAdmin(@PathVariable("admin-id") long adminId) {
	return adminService.retrieveAdmin(adminId);
	}
    
    @DeleteMapping("/delete-admin/{admin-id}")
    @ResponseBody
    public void deleteAdmin(@PathVariable("admin-id") long adminId) {
    	adminService.deleteAdmin(adminId);
    }
    
   
    @PutMapping("/modify-admin")
	@ResponseBody
	public Admin modifyAdmin(@RequestBody Admin admin) {
	return adminService.updateAdmin(admin);
	}
    

}
