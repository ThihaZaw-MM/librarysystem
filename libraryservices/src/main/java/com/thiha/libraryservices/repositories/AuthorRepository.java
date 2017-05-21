package com.thiha.libraryservices.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thiha.libraryservices.entities.Author;

public interface AuthorRepository extends CrudRepository<Author, String>{

}
