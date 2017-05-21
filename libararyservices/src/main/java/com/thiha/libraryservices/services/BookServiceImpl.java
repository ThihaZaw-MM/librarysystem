package com.thiha.libraryservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiha.libraryservices.entities.Author;
import com.thiha.libraryservices.entities.Book;
import com.thiha.libraryservices.entities.Publisher;
import com.thiha.libraryservices.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	private BookRepository bookRepository;
	
	@Autowired
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Iterable<Book> listAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(String id) {
		return bookRepository.findOne(id);
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(String id) {
		bookRepository.delete(id);
	}

	@Override
	public boolean isBookExists(Book book) {
		return bookRepository.exists(book.getId());
	}
	
	@Override
	public Iterable<Book> findByPublisher(Publisher publisher) {
		return bookRepository.findByPublisher(publisher);
	}

	@Override
	public Iterable<Book> findByAuthor(Author author) {
		return bookRepository.findByAuthor(author);
	}
}
