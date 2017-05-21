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

import com.thiha.libraryservices.entities.Language;
import com.thiha.libraryservices.services.LanguageService;


@RestController
@RequestMapping("/api")
public class LanguageController {
	public static final Logger logger = LoggerFactory.getLogger(LanguageController.class);
	private LanguageService languageService;
	
	@Autowired
	public void setLanguageService(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping(value = "/languages", method = RequestMethod.GET)
	public Iterable<Language> getAllLanguage() {
		return languageService.listAllLanguage();
	}
	
	@RequestMapping(value = "/languages/{id}", method = RequestMethod.GET)
	public Language getLanguage(@PathVariable String id) {
		return languageService.getLanguageById(id);
	}
	
	@RequestMapping(value = "/languages", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Language createNewLanguage(@RequestBody Language language) {
		if(languageService.isLanguageExists(language)){
			logger.error("Unable to create. An Language with name {} already exist", language.getLanguageName());
            return null;
		}
		UUID id = UUID.randomUUID();
		language.setId(id.toString());
		logger.info(id.toString());
		return languageService.saveLanguage(language);
	}
	
	@RequestMapping(value = "/languages/{id}", method = RequestMethod.PUT)
	public Language updateLanguage(@PathVariable String id, @RequestBody Language language) {
		Language updateLanguage = languageService.getLanguageById(id);
		
		updateLanguage.setLanguageName(language.getLanguageName());
		
		return languageService.saveLanguage(updateLanguage);
	}
	
	@RequestMapping(value = "/languages/{id}", method = RequestMethod.DELETE)
	public void deleteLanguage(@PathVariable String id) {
		languageService.deleteLanguage(id);
	}
}
