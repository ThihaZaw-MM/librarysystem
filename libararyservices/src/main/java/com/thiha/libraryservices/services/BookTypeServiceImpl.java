package com.thiha.libraryservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiha.libraryservices.entities.BookType;
import com.thiha.libraryservices.repositories.BookTypeRepository;

@Service
public class BookTypeServiceImpl implements BookTypeService {

	private BookTypeRepository bookTypeRepository;
	
	@Autowired
	public void setBookTypeRepisitory(BookTypeRepository bookTypeRepository) {
		this.bookTypeRepository = bookTypeRepository;
	}
	
	@Override
	public Iterable<BookType> listAllBookTypes() {
		return bookTypeRepository.findAll();
	}

	@Override
	public BookType getBookTypeById(String id) {
		return bookTypeRepository.findOne(id);
	}

	@Override
	public BookType saveBookType(BookType bookType) {
		return bookTypeRepository.save(bookType);
	}

	@Override
	public void deleteBookType(String id) {
		bookTypeRepository.delete(id);
	}

	@Override
	public boolean isBookTypeExists(BookType bookType) {
		return bookTypeRepository.exists(bookType.getId());
	}

}
