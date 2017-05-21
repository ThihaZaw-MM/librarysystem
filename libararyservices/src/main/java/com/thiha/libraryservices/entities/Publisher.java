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
@Table(name = "Publisher")
public class Publisher {
	@Id
	@Column(name = "PublisherID")
	private String id;
	@Column(name = "publishername")
	private String publisherName;
	@Column(name = "Address")
	private String address;
	@Column(name = "Phone")
	private String phone;
	
	@JsonManagedReference(value="publisher")
	@OneToMany(targetEntity=Book.class, mappedBy="publisher", fetch=FetchType.EAGER)
	private List<Book> books;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
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
