package com.thiha.libraryservices.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Book")
public class Book {
	@Id
	@Column(name = "BookID")
	private String id;
	@Column(name = "Title")
	private String title;
	@Column(name = "isbn")
	private String isbn;
	@Column(name  = "Barcode")
	private String barcode;
	
	//Book publisher relationship
	@Transient
	private String publisherName;
	@Transient
	private String publisherId;
	@ManyToOne
    @JoinColumn(name = "PublisherID")
	@JsonBackReference(value="publisher")
	private Publisher publisher;
	//Book publisher relationship
	
	@Column(name = "publisheddate")
	private String publishedDate;
	
	//Book author relationship
	@Transient
    private String authorName;
	@Transient
	private String authorId;
	@ManyToOne
    @JoinColumn(name = "AuthorID")
	@JsonBackReference(value="author")
	private Author author;
	//Book author relationship
	
	//Book language relationship
	@Transient
	private String languageName;
	@Transient
	private String languageId;
	@ManyToOne
    @JoinColumn(name = "LanguageID")
	@JsonBackReference(value="language")
	private Language language;
	//Book language relationship
	
	//Book booktype relationship
	@Transient
	private String bookTypeName;
	@Transient
	private String bookTypeId;
	@ManyToOne
	@JoinColumn(name = "booktypeid")
	@JsonBackReference(value = "bookType")
	private BookType bookType;
	//Book booktype relationship
	
	//Book location relationship
	@Transient
	private String locationName;
	@Transient
	private String locationId;
	@ManyToOne
	@JoinColumn(name = "LocationID")
	@JsonBackReference(value = "location")
	private Location location;
	//Book location relationship
	
	@Column(name = "Value")
	private BigDecimal value;
	@Column(name = "Photo")
	private String photo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	//Book author relationship
	public String getAuthorName() {
		if(author != null) {
			this.authorName = author.getAuthorName();
		}
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorId() {
		if(author != null) {
			this.authorId = author.getId();
		}
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	//Book author relationship
	
	//Book publisher relationship
	public String getPublisherName() {
		if(publisher != null) {
			this.publisherName = publisher.getPublisherName();
		}
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getPublisherId() {
		if(publisher != null) {
			this.publisherId = publisher.getId();
		}
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	//Book publisher relationship
	
	//Book language relationship
	public String getLanguageName() {
		if(language != null) {
			this.languageName = language.getLanguageName();
		}
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getLanguageId() {
		if(language != null) {
			this.languageId = language.getId();
		}
		return languageId;
	}
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	//Book language relationship
	
	//Book booktype relationship
	public String getBookTypeName() {
		if(bookType != null) {
			this.bookTypeName = bookType.getBookTypeName();
		}
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookTypeId() {
		if(bookType != null) {
			this.bookTypeId = bookType.getId();
		}
		return bookTypeId;
	}
	public void setBookTypeId(String bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public BookType getBookType() {
		return bookType;
	}
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	//Book booktype relationship
	
	//Book location relationship
	public String getLocationName() {
		if(location != null) {
			this.locationName = location.getLocationName();
		}
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLocationId() {
		if(location != null) {
			locationId = location.getId();
		}
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	//Book location relationship
	
}
