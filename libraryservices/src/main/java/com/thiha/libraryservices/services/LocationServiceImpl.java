package com.thiha.libraryservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiha.libraryservices.entities.Location;
import com.thiha.libraryservices.repositories.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService{
	
	private LocationRepository locationRepository;
	
	@Autowired
	public void setLocationRepository(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}
	
	@Override
	public Iterable<Location> listAllLocation() {
		return locationRepository.findAll();
	}

	@Override
	public Location getLocationById(String id) {
		return locationRepository.findOne(id);
	}

	@Override
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public void deleteLocation(String id) {
		locationRepository.delete(id);
	}

	@Override
	public boolean isLocationExists(Location location) {
		return locationRepository.exists(location.getId());
	}

}
