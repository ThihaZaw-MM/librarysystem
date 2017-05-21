package com.thiha.libraryservices.services;

import com.thiha.libraryservices.entities.Location;

public interface LocationService {
	Iterable<Location> listAllLocation();
	Location getLocationById(String id);
	Location saveLocation(Location location);
	void deleteLocation(String id);
	boolean isLocationExists(Location location);
}
