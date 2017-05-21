package com.thiha.libraryservices.controllers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thiha.libraryservices.entities.Location;
import com.thiha.libraryservices.services.LocationService;

@RestController
@RequestMapping("/api")
public class LocationController {
	public static final Logger logger = LoggerFactory.getLogger(LocationController.class);
	private LocationService locationService;
	
	@Autowired
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}
	
	@RequestMapping(value = "/locations", method = RequestMethod.GET)
	public Iterable<Location> getAllLocation() {
		return locationService.listAllLocation();
	}
	
	@RequestMapping(value = "/locations/{id}", method = RequestMethod.GET)
	public Location getLocation(@PathVariable String id) {
		return locationService.getLocationById(id);
	}
	
	@RequestMapping(value = "/locations", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Location createNewLocation(@RequestBody Location location) {
		if(locationService.isLocationExists(location)){
			logger.error("Unable to create. An location with name {} already exist", location.getLocationName());
            return null;
		}
		UUID id = UUID.randomUUID();
		location.setId(id.toString());
		logger.info(id.toString());
		return locationService.saveLocation(location);
	}
	
	@RequestMapping(value = "/locations/{id}", method = RequestMethod.PUT)
	public Location updateLocation(@PathVariable String id, @RequestBody Location location) {
		Location updateLocation = locationService.getLocationById(id);
		
		updateLocation.setLocationName(location.getLocationName());
		
		return locationService.saveLocation(updateLocation);
	}
	
	@RequestMapping(value = "/locations/{id}", method = RequestMethod.DELETE)
	public void deleteLocation(@PathVariable String id) {
		locationService.deleteLocation(id);
	}
}
