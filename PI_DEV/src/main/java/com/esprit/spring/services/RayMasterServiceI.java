package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.RayMaster;

public interface RayMasterServiceI {

	RayMaster addRayMaster(RayMaster rm);

	void deleteRayMaster(String id);

	RayMaster updateRayMaster(RayMaster rm);

	RayMaster retrieveRayMaster(String id);

	List<RayMaster> retrieveAllRayMaster();

}
