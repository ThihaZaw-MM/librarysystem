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

import com.thiha.libraryservices.entities.BookType;
import com.thiha.libraryservices.services.BookTypeService;

@RestController
@RequestMapping("/api")
public class BookTypeController {
	public static final Logger logger = LoggerFactory.getLogger(BookTypeController.class);
	private BookTypeService bookTypeService;
	
	@Autowired
	public void setBookTypeService(BookTypeService bookTypeService) {
		this.bookTypeService = bookTypeService;
	}
	
	@RequestMapping(value = "/booktypes", method = RequestMethod.GET)
	public Iterable<BookType> getAllBookTypes() {
		return bookTypeService.listAllBookTypes();
	}
	
	@RequestMapping(value = "/booktypes/{id}", method = RequestMethod.GET)
	public BookType getBookType(@PathVariable String id) {
		return bookTypeService.getBookTypeById(id);
	}
	
	@RequestMapping(value = "/booktypes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BookType createNewBookType(@RequestBody BookType bookType) {
		if(bookTypeService.isBookTypeExists(bookType)){
			logger.error("Unable to create. An book type with name {} already exist", bookType.getBookTypeName());
            return null;
		}
		UUID id = UUID.randomUUID();
		bookType.setId(id.toString());
		logger.info(id.toString());
		return bookTypeService.saveBookType(bookType);
	}
	
	@RequestMapping(value = "/booktypes/{id}", method = RequestMethod.PUT)
	public BookType updateBookType(@PathVariable String id, @RequestBody BookType bookType) {
		BookType updateType = bookTypeService.getBookTypeById(id);
		
		updateType.setBookTypeName(bookType.getBookTypeName());
		updateType.setCategory(bookType.getCategory());
		
		return bookTypeService.saveBookType(updateType);
	}
	
	@RequestMapping(value = "/booktypes/{id}", method = RequestMethod.DELETE)
	public void deleteBookType(@PathVariable String id) {
		bookTypeService.deleteBookType(id);
	}
}
