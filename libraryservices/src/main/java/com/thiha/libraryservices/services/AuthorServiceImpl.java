package com.thiha.libraryservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiha.libraryservices.entities.Author;
import com.thiha.libraryservices.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{
	private AuthorRepository authorRepository;
	
	@Autowired
	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public Iterable<Author> listAllAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public Author getAuthorById(String id) {
		return authorRepository.findOne(id);
	}

	@Override
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public void deleteAuthor(String id) {
		authorRepository.delete(id);
	}

	@Override
	public boolean isAuthorExists(Author author) {
		return authorRepository.exists(author.getId());
	}
}
