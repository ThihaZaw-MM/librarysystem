package com.thiha.libraryservices.services;

import com.thiha.libraryservices.entities.Publisher;

public interface PublisherService {
	Iterable<Publisher> listAllPublisher();
	Publisher getPublisherById(String id);
	Publisher savePublisher(Publisher publisher);
	void deletePublisher(String id);
	boolean isPublisherExist(Publisher publisher);
}
