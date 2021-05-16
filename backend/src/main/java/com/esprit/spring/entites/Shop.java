package com.esprit.spring.entites;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Shop {
    @Column
	private String DriverName;
    
    @Embedded
	private Address DriverAddress;
    
	@Column
	private double DriverLatitude;
	
	@Column
	private double DriverLongitude;

	public String getDriverName() {
		return DriverName;
	}

	public void setDriverName(String driverName) {
		DriverName = driverName;
	}

	public Address getDriverAddress() {
		return DriverAddress;
	}

	public void setDriverAddress(Address driverAddress) {
		DriverAddress = driverAddress;
	}

	public double getDriverLatitude() {
		return DriverLatitude;
	}

	public void setDriverLatitude(double driverLatitude) {
		DriverLatitude = driverLatitude;
	}

	public double getDriverLongitude() {
		return DriverLongitude;
	}

	public void setDriverLongitude(double driverLongitude) {
		DriverLongitude = driverLongitude;
	}
	
	


	
	
}