package com.thiha.libraryservices.services;

import com.thiha.libraryservices.entities.BookType;

public interface BookTypeService {
	Iterable<BookType> listAllBookTypes();
	BookType getBookTypeById(String id);
	BookType saveBookType(BookType bookType);
	void deleteBookType(String id);
	boolean isBookTypeExists(BookType bookType);
}
