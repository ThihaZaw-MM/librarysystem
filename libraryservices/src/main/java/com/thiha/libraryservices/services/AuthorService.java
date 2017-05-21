package com.thiha.libraryservices.services;

import com.thiha.libraryservices.entities.Author;

public interface AuthorService {
	Iterable<Author> listAllAuthors();
	Author getAuthorById(String id);
	Author saveAuthor(Author author);
	void deleteAuthor(String id);
	boolean isAuthorExists(Author author);
}
