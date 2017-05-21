package com.thiha.libraryservices.services;

import com.thiha.libraryservices.entities.Author;
import com.thiha.libraryservices.entities.Book;
import com.thiha.libraryservices.entities.Publisher;

public interface BookService {
	Iterable<Book> listAllBooks();
	Book getBookById(String id);
	Book saveBook(Book book);
	void deleteBook(String id);
	boolean isBookExists(Book book);
	Iterable<Book> findByPublisher(Publisher publisher);
	Iterable<Book> findByAuthor(Author author);
}
