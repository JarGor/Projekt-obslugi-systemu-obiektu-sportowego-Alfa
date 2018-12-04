package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.dao.LanguageRepository;
import com.ztbd.sportsfacility.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public void deleteLanguage(String code) {
        languageRepository.deleteById(code);
    }

    @Override
    public void saveLanguage(Language language) {
        languageRepository.save(language);
    }

    @Override
    public Language getLanguage(String code) {
        return languageRepository.findById(code).orElse(null);
    }

    @Override
    public List<Language> getLanguages() {
        List<Language> languages = new ArrayList<>();
        languageRepository.findAll().forEach(e -> languages.add(e));
        return languages;
    }
}
