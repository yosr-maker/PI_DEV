package com.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.data.Store;
import com.esprit.spring.entites.Delivery;
import com.esprit.spring.entites.Driver;
import com.esprit.spring.services.DriverService;
import com.esprit.spring.services.GeocodeService;
import com.google.maps.model.LatLng;

@RestController
@RequestMapping("/api")
public class DriverController {

	@Autowired
	DriverService driverService;
	
	
	
//localhost:8092/api/add-driver
	/*	"lastName":"ihsen",
	"firstName":"kilani",
	"phone":"2589348",
	"salaire":"800",
	"emailDriver":"ghrgh@fgefg.com",
	"location":"fgnrnrn",
	"nbrDeliveryAffected":70*/
	@PostMapping(value = "/add-driver")
	@ResponseBody
	public Driver addDriver(@RequestBody Driver driver) {
		Driver driv = driverService.addDriver(driver);
		System.out.println("Driver add works properly");
	return  driv;	
	}
	
	//localhost:8092/api/remove- driver/2
	@DeleteMapping("/remove- driver/{driver-id}")
	@ResponseBody
	public void removeDriver(@PathVariable("driver-id")Long driverId) {
		driverService.deleteDriver(driverId);
	}
	
	//localhost:8092/api/modify-driver
	/*{	"idDriver":1,
	"lastName":"ilhemn",
	"firstName":"kilani",
	"phone":"22914704",
	"salaire":"800",
	"emailDriver":"ghrgh@fgefg.com",
	"location":"fgnrnrn",
	"nbrDeliveryAffected":60*/

	@PutMapping("/modify-driver")
	@ResponseBody
	public Driver modifyDriver(@RequestBody Driver driver) {
	return driverService.updateDriver(driver);
	}
	
	//localhost:8092/api/retrieve-driver/4
	@GetMapping("/retrieve-driver/{driver-id}")
	@ResponseBody
	public Driver retrieveDriver(@PathVariable("driver-id") Long driverId) {
	return driverService.retrieveDriver(driverId);
	}
	//localhost:8092/api/retrieve-all-drivers
	@GetMapping("/retrieve-all-drivers")
	@ResponseBody
	public List<Driver> getDriver() {
	List<Driver> list = driverService.retrieveAllDrivers();
	return list;
	}
	@GetMapping("/drivermounth")
	@ResponseBody
	public long DriverMounth() {
		return driverService.DriverMounth();
		
	}
	/*@PostMapping(value = "/affecterDrivertoDeli/{id-driver}")
	@ResponseBody
	public void affecterDriverToDelivery(@PathVariable("id-driver")Long idDriver, Long deliveryId) {
		return  driverService.affecterDriverToDelivery(idDriver, deliveryId);
	}*/
	
	
	@GetMapping("/setSal/{id-driver}")
	@ResponseBody
	public Long setSalary(Long nbrDeliveryAffected, @PathVariable("id-driver")Long idDriver) {
		return  driverService.setSalary(idDriver);
		
	}
	@GetMapping("/getDelivery/{driver-id}")
	@ResponseBody
	public Long getDelivery(Long nbrDeliveryAffected,@PathVariable("driver-id")Long idDriver) {
		return driverService.getDelivery(nbrDeliveryAffected, idDriver);
	}
	
	@PostMapping("/affecterAutotoDrive/{driver-id}/{auto-id}")
	public String affecterAutotoDriver(@PathVariable("driver-id")Long idDriver,@PathVariable("auto-id") Long idAuto) {
		return driverService.affecterAutotoDriver(idDriver, idAuto);
	}
	
	

	@Autowired
	@Qualifier("geocodeService")
	private GeocodeService geocodeService;

	/**
	 * the data store
	 */
	@Autowired
	@Qualifier("memoryStore")
	private Store<Driver, LatLng> store;

	/**
	 * REST endpoint for adding a shop
	 * 
	 * @param shop
	 */
	@RequestMapping(path = "/shop", method = RequestMethod.POST)
	public void addShop(@RequestBody Driver shop) {
		LatLng geocode = geocodeService.getGeocode(shop);
		if (null != geocode) {
			shop.getShop1().setShopLatitude(geocode.lat);
			shop.getShop1().setShopLongitude(geocode.lng);
		}
		store.add(shop);
	}

	/**
	 * REST endpoint to find the nearest shop from a location marked with
	 * latitude and longitude
	 * 
	 * @param latitude,
	 *            the latitude of the customer
	 * @param longitude,
	 *            the longitude of the customer
	 * @return the nearest shop
	 */
	@RequestMapping(path = "/shop/{latitude}/{longitude}", method = RequestMethod.GET)
	public Driver getShop(@PathVariable double latitude, @PathVariable double longitude) {
		LatLng geocode = new LatLng(latitude, longitude);
		Driver shop = store.get(geocode);
		return shop;
	}

	/**
	 * REST endpoint for a default request without the customer latitude and
	 * longitude
	 * 
	 * @return returns all the registered shops
	 */
	@RequestMapping(path = "/shop", method = RequestMethod.GET)
	public List<Driver> getShops() {
		return store.getAll();
	}

}

