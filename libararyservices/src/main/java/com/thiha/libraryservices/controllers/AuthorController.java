package com.thiha.libraryservices.controllers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thiha.libraryservices.entities.Author;
import com.thiha.libraryservices.services.AuthorService;

@RestController
@RequestMapping("/api")
public class AuthorController {

	public static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
	private AuthorService authorService;
	
	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public Iterable<Author> getAllAuthors() {
		return authorService.listAllAuthors();
	}
	
	@RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
	public Author getAuthor(@PathVariable String id) {
		return authorService.getAuthorById(id);
	}
	
	@RequestMapping(value = "/authors", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Author createNewAuthor(@RequestBody Author author) {
		if(authorService.isAuthorExists(author)){
			logger.error("Unable to create. An author with name {} already exist", author.getAuthorName());
            return null;
		}
		UUID id = UUID.randomUUID();
		author.setId(id.toString());
		logger.info(id.toString());
		return authorService.saveAuthor(author);
	}
	
	@RequestMapping(value = "/authors/{id}", method = RequestMethod.PUT)
	public Author updateAuthor(@PathVariable String id, @RequestBody Author author) {
		Author updateAuthor = authorService.getAuthorById(id);
		
		updateAuthor.setAuthorName(author.getAuthorName());
		updateAuthor.setAddress(author.getAddress());
		updateAuthor.setPhone(author.getPhone());
		
		return authorService.saveAuthor(updateAuthor);
	}
	
	@RequestMapping(value = "/authors/{id}", method = RequestMethod.DELETE)
	public void deleteAuthor(@PathVariable String id) {
		authorService.deleteAuthor(id);
	}
}
