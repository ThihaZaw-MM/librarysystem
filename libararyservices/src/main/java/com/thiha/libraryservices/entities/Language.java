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
@Table(name = "Language")
public class Language {
	@Id
	@Column(name = "LanguageID")
	private String id;
	@Column(name = "languagename")
	private String languageName;
	
	@JsonManagedReference(value="language")
	@OneToMany(targetEntity=Book.class, mappedBy="language", fetch=FetchType.EAGER)
	private List<Book> books;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
