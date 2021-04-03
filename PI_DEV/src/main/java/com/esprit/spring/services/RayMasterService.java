package com.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.RayMaster;
import com.esprit.spring.repository.RayMasterRepository;



@Service
public class RayMasterService implements RayMasterServiceI {
	
	@Autowired
	RayMasterRepository rayMasterRepository;
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(RayMasterService.class);



public RayMaster addRayMaster(RayMaster rm) {
   return 	rayMasterRepository.save(rm);
	
}


public void deleteRayMaster(String id) {
	rayMasterRepository.deleteById(Long.parseLong(id));
	
}



public RayMaster updateRayMaster(RayMaster rm) {
	return rayMasterRepository.save(rm);
	
}


public RayMaster retrieveRayMaster(String id) {
	 RayMaster rm  =rayMasterRepository.findById(Long.parseLong(id)).orElse(null);
	 return rm ;	
}

public List<RayMaster> retrieveAllRayMaster() {
	List<RayMaster> rayMasters = (List<RayMaster>) rayMasterRepository.findAll();
	for (RayMaster rayMaster: rayMasters){
		l.info("les RayMasters  +++ :" + rayMaster);
	}
		
return rayMasters;	
}

}





