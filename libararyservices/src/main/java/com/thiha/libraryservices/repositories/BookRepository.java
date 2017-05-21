package com.thiha.libraryservices.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thiha.libraryservices.entities.Author;
import com.thiha.libraryservices.entities.Book;
import com.thiha.libraryservices.entities.Publisher;

public interface BookRepository extends CrudRepository<Book, String>{
	Iterable<Book> findByPublisher(Publisher publisher);
	Iterable<Book> findByAuthor(Author author);
}
