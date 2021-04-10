package com.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.RayMaster;
import com.esprit.spring.repository.RayMasterRepository;




@Service

public class RayMasterService  implements RayMasterServiceI{
	@Autowired
	private RayMasterRepository rayMasterRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	

        @Override
	    public RayMaster addRayMaster(RayMaster rayMaster) {
        RayMaster newrayMaster = new RayMaster();
		newrayMaster.setUsername(rayMaster.getUsername());
		newrayMaster.setPassword(bcryptEncoder.encode(rayMaster.getPassword()));
		newrayMaster.setFirstName(rayMaster.getFirstName());
		newrayMaster.setLastName(rayMaster.getLastName());
		newrayMaster.setEmail(rayMaster.getEmail());
		newrayMaster.setCin(rayMaster.getCin());
		newrayMaster.setPhoneNumber(rayMaster.getPhoneNumber());
		newrayMaster.setRole(rayMaster.getRole());
		return rayMasterRepository.save(newrayMaster);
	}
        @Override
	public RayMaster findRayMasterByUsername(String username) {
		return rayMasterRepository.findByUsername(username);
	}
	
	
	@Override
	public UserDetails loadRayMasterByUsername(String username) throws UsernameNotFoundException {
		RayMaster rayMaster = rayMasterRepository.findByUsername(username);
		if (rayMaster == null) {
			throw new UsernameNotFoundException("rayMaster not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(rayMaster.getUsername(), rayMaster.getPassword(),
				new ArrayList<>());
	}

	@Override
	public RayMaster retrieveRayMaster(long id) {

		return rayMasterRepository.findById(id).get();
	}

	@Override
	public List<RayMaster> retrieveAllRayMasters() {

		return (List<RayMaster>) rayMasterRepository.findAll();
	}
	@Override
	public void deleteRayMaster(long id) {

		rayMasterRepository.deleteById(id);

	}
	@Override
	public RayMaster authenticate(String username, String email) {
		RayMaster ry  = rayMasterRepository.findByUsernameAndEmail(username, email);
		return ry;
	}


	@Override
	public RayMaster updateRayMaster(RayMaster ry) {
		rayMasterRepository.save(ry);
		return ry;
	}
	
}





