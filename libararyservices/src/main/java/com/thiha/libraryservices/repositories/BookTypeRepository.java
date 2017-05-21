package com.thiha.libraryservices.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thiha.libraryservices.entities.BookType;

public interface BookTypeRepository extends CrudRepository<BookType, String> {

}
