package com.thiha.libraryservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiha.libraryservices.entities.Language;
import com.thiha.libraryservices.repositories.LanguageRepository;

@Service
public class LanguageServiceImpl implements LanguageService {

	private LanguageRepository languageRepository;
	
	@Autowired
	public void setLanguageRepository(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	@Override
	public Iterable<Language> listAllLanguage() {
		return languageRepository.findAll();
	}

	@Override
	public Language getLanguageById(String id) {
		return languageRepository.findOne(id);
	}

	@Override
	public Language saveLanguage(Language language) {
		return languageRepository.save(language);
	}

	@Override
	public void deleteLanguage(String id) {
		languageRepository.delete(id);
	}

	@Override
	public boolean isLanguageExists(Language language) {
		return languageRepository.exists(language.getId());
	}

}
