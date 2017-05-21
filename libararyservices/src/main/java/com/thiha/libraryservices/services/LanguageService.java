package com.thiha.libraryservices.services;

import com.thiha.libraryservices.entities.Language;

public interface LanguageService {
	Iterable<Language> listAllLanguage();
	Language getLanguageById(String id);
	Language saveLanguage(Language language);
	void deleteLanguage(String id);
	boolean isLanguageExists(Language language);
}
