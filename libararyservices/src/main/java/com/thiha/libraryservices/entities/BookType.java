package com.thiha.libraryservices.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "booktype")
public class BookType {
	@Id
	@Column(name = "booktypeid")
	private String id;
	@Column(name = "booktypename")
	private String bookTypeName;
	@Column(name = "Category")
	private String category;
	
	@JsonManagedReference(value="bookType")
	@OneToMany(targetEntity=Book.class, mappedBy="bookType", fetch=FetchType.EAGER)
	private List<Book> books;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
