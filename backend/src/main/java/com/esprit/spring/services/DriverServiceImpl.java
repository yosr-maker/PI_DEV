package com.esprit.spring.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Automobile;
import com.esprit.spring.entites.Command_line;
import com.esprit.spring.entites.Delivery;
import com.esprit.spring.entites.Driver;
import com.esprit.spring.repository.AutomobileRepository;
import com.esprit.spring.repository.DeliveryRepository;
import com.esprit.spring.repository.DriverRepository;


@Service
public class DriverServiceImpl implements DriverService {

@Autowired
DeliveryRepository deliveryRepository ;
@Autowired
DriverRepository driverRepository ;
@Autowired
AutomobileRepository autoRepository ;



private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(DriverService.class);

	@Override
	public List<Driver> retrieveAllDrivers() {
		List<Driver> drivers = (List<Driver>) driverRepository.findAll();
		for(Driver driver:drivers) {
			l.info("driver" + driver);
		}
		return drivers;
	}

	@Override
	public Driver addDriver(Driver driver) {
	
		return driverRepository.save(driver);
	}

	@Override
	public void deleteDriver(Long idDriver) {
		 driverRepository.deleteById(idDriver);
		
	}

	@Override
	public Driver updateDriver(Driver driver) {
		return driverRepository.save(driver);
	}

	@Override
	public Driver retrieveDriver(Long idDriver) {
		// TODO Auto-generated method stub
		return driverRepository.findById(idDriver).get();
	}
//connaitre le nombre de delivery par driver OK
	@Override
	public Long getDelivery(Long nbrDeliveryAffected, Long idDriver) {
		// TODO Auto-generated method stub
		return driverRepository.getOne(idDriver).getNbrDeliveryAffected();
	}
//chaque livreur aura un salire fixe , si il depasse 50 nbrdeliveri il aura une prime de 200dt
	//sion il prendra le 3/4 de chaque livraison effectuer 
	//OK
	@Override
	public Long setSalary(Long idDriver) {
		Driver d = driverRepository.findById(idDriver).get();
		float salaryFix = 800f;
		float prixDeliv = 5f;
		if (d.getNbrDeliveryAffected()<= 20) {
			d.getIdDriver();
			d.setSalaire((long) salaryFix);
			
		}
		else if( d.getNbrDeliveryAffected()<50) {
			d.setSalaire((long) salaryFix+200);
		}else
		{
			d.setSalaire((long) (((d.getNbrDeliveryAffected()*prixDeliv)*3)/4+salaryFix));
			
		}
		 driverRepository.save(d);
		return d.getSalaire();
	}
//OK
	@Override
	public long DriverMounth() {
		long idmax =  0;
		long max = driverRepository.getDriverLMounth();
		for (Driver d :driverRepository.findAll() ){
		 if(d.getNbrDeliveryAffected()==max)
		{
			idmax=d.getIdDriver();
		}
			
		}
		return idmax;
	}
//OK
	@Override
	public String affecterAutotoDriver(Long idDriver, Long idAuto) {
	Driver d = driverRepository.findById(idAuto).get();
	Automobile auto = autoRepository.findById(idDriver).get();
	
	auto.setDriver(d);
	driverRepository.save(d);
	return "affecterAutotoDriver";
	
	}
	//ok
	@Override
	public String affecterDeliverytoDriver(Long idDriver, Long idDeli) {
	Driver d = driverRepository.findById(idDeli).get();
	Delivery deli = deliveryRepository.findById(idDriver).get();
	
	deli.setDriver(d);
	driverRepository.save(d);
	return "affecterDeliverytoDriver";
	
	}
	
	

	
	

}
