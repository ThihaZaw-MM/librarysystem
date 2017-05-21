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
import com.thiha.libraryservices.entities.Book;
import com.thiha.libraryservices.entities.BookType;
import com.thiha.libraryservices.entities.Language;
import com.thiha.libraryservices.entities.Location;
import com.thiha.libraryservices.entities.Publisher;
import com.thiha.libraryservices.services.AuthorService;
import com.thiha.libraryservices.services.BookService;
import com.thiha.libraryservices.services.BookTypeService;
import com.thiha.libraryservices.services.LanguageService;
import com.thiha.libraryservices.services.LocationService;
import com.thiha.libraryservices.services.PublisherService;

@RestController
@RequestMapping("/api")
public class BookController {
	public static final Logger logger = LoggerFactory.getLogger(BookController.class);
	private BookService bookService;
	private PublisherService publisherService;
	private AuthorService authorService;
	private LanguageService languageService;
	private BookTypeService bookTypeService;
	private LocationService locationService;
	
	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@Autowired
	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	
	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@Autowired
	public void setLanguageService(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@Autowired
	public void setBookTypeService(BookTypeService bookTypeService) {
		this.bookTypeService = bookTypeService;
	}
	
	@Autowired
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}
	
	//Filtering section
	@RequestMapping(value = "/publishedbooks/{id}", method = RequestMethod.GET)
	public Iterable<Book> getBookByPublisher(@PathVariable String id) {
		Publisher publisher = publisherService.getPublisherById(id);
		return bookService.findByPublisher(publisher);
	}
	@RequestMapping(value = "/authoredbooks/{id}", method = RequestMethod.GET)
	public Iterable<Book> getBookByAuthor(@PathVariable String id) {
		Author author = authorService.getAuthorById(id);
		return bookService.findByAuthor(author);
	}
	//Filtering section
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public Iterable<Book> getAllBooks() {
		return bookService.listAllBooks();
	}
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public Book getBook(@PathVariable String id) {
		return bookService.getBookById(id);
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Book createNewBook(@RequestBody Book book) {
		if(bookService.isBookExists(book)) {
			logger.error("Unable to create. A book with name {} already exist", book.getTitle());
			return null;
		}
		UUID id = UUID.randomUUID();
		book.setId(id.toString());
		logger.info(id.toString());
		return bookService.saveBook(book);
	}
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
	public Book updateBook(@PathVariable String id, @RequestBody Book book) {
		Book updateBook = bookService.getBookById(id);
		
		Publisher publisher = publisherService.getPublisherById(book.getPublisher().getId());
		Author author = authorService.getAuthorById(book.getAuthor().getId());
		Language language = languageService.getLanguageById(book.getLanguage().getId());
		BookType bookType = bookTypeService.getBookTypeById(book.getBookType().getId());
		Location location = locationService.getLocationById(book.getLocation().getId());
		
		updateBook.setTitle(book.getTitle());
		updateBook.setIsbn(book.getIsbn());
		updateBook.setBarcode(book.getBarcode());
		updateBook.setPublisher(publisher);
		updateBook.setPublishedDate(book.getPublishedDate());
		updateBook.setAuthor(author);
		updateBook.setLanguage(language);
		updateBook.setBookType(bookType);
		updateBook.setLocation(location);
		updateBook.setValue(book.getValue());
		updateBook.setPhoto(book.getPhoto());
		
		return bookService.saveBook(updateBook);
	}
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable String id) {
		bookService.deleteBook(id);
	}
}
