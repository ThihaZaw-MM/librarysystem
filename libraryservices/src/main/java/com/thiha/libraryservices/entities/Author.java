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
@Table(name = "Author")
public class Author {
	@Id
	@Column(name = "AuthorID")
	private String id;
	@Column(name = "authorname")
	private String authorName;
	@Column(name = "Address")
	private String address;
	@Column(name = "Phone")
	private String phone;
	
	@JsonManagedReference(value="author")
	@OneToMany(targetEntity=Book.class, mappedBy="author", fetch=FetchType.EAGER)
	private List<Book> books;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
