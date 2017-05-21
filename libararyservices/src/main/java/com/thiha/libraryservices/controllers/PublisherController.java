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

import com.thiha.libraryservices.entities.Publisher;
import com.thiha.libraryservices.services.PublisherService;


@RestController
@RequestMapping("/api")
public class PublisherController {
	public static final Logger logger = LoggerFactory.getLogger(PublisherController.class);
	private PublisherService publisherService;
	
	@Autowired
	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	
	@RequestMapping(value = "/publishers", method = RequestMethod.GET)
	public Iterable<Publisher> getAllPublisher() {
		return publisherService.listAllPublisher();
	}
	
	@RequestMapping(value = "/publishers/{id}", method = RequestMethod.GET)
	public Publisher getPubliser(@PathVariable String id) {
		return publisherService.getPublisherById(id);
	}
	
	@RequestMapping(value = "/publishers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Publisher createNewPublisher(@RequestBody Publisher publisher) {
		if(publisherService.isPublisherExist(publisher)){
			logger.error("Unable to create. A Publisher with name {} already exist", publisher.getPublisherName());
            return null;
		}
		UUID id = UUID.randomUUID();
		publisher.setId(id.toString());
		logger.info(id.toString());
		return publisherService.savePublisher(publisher);
	}
	
	@RequestMapping(value = "/publishers/{id}", method = RequestMethod.PUT)
	public Publisher updatePublisher(@PathVariable String id, @RequestBody Publisher publisher) {
		Publisher updatePublisher = publisherService.getPublisherById(id);
		
		updatePublisher.setPublisherName(publisher.getPublisherName());
		updatePublisher.setAddress(publisher.getAddress());
		updatePublisher.setPhone(publisher.getPhone());
		
		return publisherService.savePublisher(updatePublisher);
	}
	
	@RequestMapping(value = "/publishers/{id}", method = RequestMethod.DELETE)
	public void deletePublisher(@PathVariable String id) {
		publisherService.deletePublisher(id);
	}
}
