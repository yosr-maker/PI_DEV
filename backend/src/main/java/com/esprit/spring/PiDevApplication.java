package com.esprit.spring;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.esprit.spring.data.MemoryStore;
import com.esprit.spring.data.Store;
import com.esprit.spring.entites.Contribution;
import com.esprit.spring.entites.Driver;
import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.EventCategory;
import com.esprit.spring.entites.Jackpot;
import com.esprit.spring.entites.Notification;
import com.esprit.spring.entites.Participation;
import com.esprit.spring.services.GeocodeService;
import com.google.maps.model.LatLng;

@SpringBootApplication
@EnableScheduling
public class PiDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiDevApplication.class, args);
	}
	


	@Bean(name = "geocodeService")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	@ConfigurationProperties(prefix = "config")
	public GeocodeService getGeocodeService() {
		GeocodeService service = new GeocodeService();
		return service;
	}

	@Bean(name = "memoryStore")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Store<Driver, LatLng> getMemoryStore() {
		return new MemoryStore();
	}
}



