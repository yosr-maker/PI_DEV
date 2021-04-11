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
import com.esprit.spring.entites.RayMaster;
import com.esprit.spring.model.JwtRequest;
import com.esprit.spring.model.JwtResponse;
import com.esprit.spring.services.RayMasterService;


@RestController
public class RayMasterController {


	
	@Autowired
	RayMasterService rayMasterService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	public static RayMaster RAYMASTERCONNECTED ;
	
	@GetMapping("/bonjour-rayMaster")
	@ResponseBody
	public String welcome() { return "Bonjour, Bienvenue à votre espace RayMaster "; }
	

	@PostMapping("/register-rayMaster")
	@ResponseBody
	public ResponseEntity<?> saveRayMaster(@RequestBody RayMaster rayMaster) throws Exception {
		System.out.println("Entring the register method ");
		return ResponseEntity.ok(rayMasterService.addRayMaster(rayMaster));
	}

	@PostMapping("/authenticate-rayMaster")
	@ResponseBody
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

			final UserDetails userDetails = rayMasterService.loadRayMasterByUsername(authenticationRequest.getUsername());
			final RayMaster rayMaster = rayMasterService.findRayMasterByUsername(authenticationRequest.getUsername());
			RAYMASTERCONNECTED = rayMaster ;
			System.out.println(RAYMASTERCONNECTED.getRole());


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
	
	
	
	@GetMapping("/retrieve_rayMasters")
	@ResponseBody
	public List<RayMaster> getRayMaster() {
	List<RayMaster> list = rayMasterService.retrieveAllRayMasters();
	return list;
	}
	
	@GetMapping("/retrieve-rayMaster/{rayMasterId}")
	@ResponseBody
	public RayMaster findbyid(@PathVariable("rayMasterId") long rayMasterId) {
	return rayMasterService.retrieveRayMaster(rayMasterId);
	}
	
	
	@PutMapping("/modify-rayMaster")
	@ResponseBody
	public RayMaster modifyRayMaster(@RequestBody RayMaster rayMaster) {
	return rayMasterService.updateRayMaster(rayMaster);
	}
    
    @DeleteMapping("/delete-rayMaster/{rayMaster-id}")
    @ResponseBody
    public void deleteRayMaster(@PathVariable("rayMaster-id") long rayMasterId) {
    	rayMasterService.deleteRayMaster(rayMasterId);
    }
    
   
	
    

}
