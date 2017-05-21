package com.thiha.libraryservices.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thiha.libraryservices.entities.Location;

public interface LocationRepository extends CrudRepository<Location, String>{

}
