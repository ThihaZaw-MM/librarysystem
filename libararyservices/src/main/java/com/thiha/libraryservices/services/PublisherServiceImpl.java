package com.thiha.libraryservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiha.libraryservices.entities.Publisher;
import com.thiha.libraryservices.repositories.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService{
	
	private PublisherRepository publisherRepository;
	
	@Autowired
	public void setPublisherRepository(PublisherRepository publisherRepository) {
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public Iterable<Publisher> listAllPublisher() {
		return publisherRepository.findAll();
	}

	@Override
	public Publisher getPublisherById(String id) {
		return publisherRepository.findOne(id);
	}

	@Override
	public Publisher savePublisher(Publisher publisher) {
		return publisherRepository.save(publisher);
	}

	@Override
	public void deletePublisher(String id) {
		publisherRepository.delete(id);
	}

	@Override
	public boolean isPublisherExist(Publisher publisher) {
		return publisherRepository.exists(publisher.getId());
	}

}
