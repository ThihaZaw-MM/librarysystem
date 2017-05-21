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
@Table(name = "Location")
public class Location {
	@Id
	@Column(name = "LocationID")
	private String id;
	@Column(name = "locationname")
	private String locationName;
	
	@JsonManagedReference(value="location")
	@OneToMany(targetEntity=Book.class, mappedBy="location", fetch=FetchType.EAGER)
	private List<Book> books;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
