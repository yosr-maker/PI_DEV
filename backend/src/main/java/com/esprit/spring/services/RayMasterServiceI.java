package com.esprit.spring.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.esprit.spring.entites.RayMaster;

public interface RayMasterServiceI {

	RayMaster findRayMasterByUsername(String username);

	RayMaster addRayMaster(RayMaster rayMaster);

	UserDetails loadRayMasterByUsername(String username) throws UsernameNotFoundException;

	RayMaster retrieveRayMaster(long id);

	List<RayMaster> retrieveAllRayMasters();

	void deleteRayMaster(long id);

	RayMaster authenticate(String username, String email);

	RayMaster updateRayMaster(RayMaster ry);


}
