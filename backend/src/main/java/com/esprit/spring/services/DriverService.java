package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Driver;

public interface DriverService {

	List<Driver> retrieveAllDrivers();
	Driver addDriver(Driver driver);
	void deleteDriver (Long idDriver);		
	Driver updateDriver(Driver driver);
	Driver retrieveDriver(Long idDriver);
	Long  getDelivery(Long nbrDeliveryAffected,Long idDriver);
	public Long setSalary(Long idDriver);
	public long DriverMounth();
	public String affecterAutotoDriver(Long idDriver,Long idAuto);
	String affecterDeliverytoDriver(Long idDriver, Long idDeli);
}
