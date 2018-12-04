package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.model.Language;

import java.util.List;

public interface LanguageService {
    void deleteLanguage(String code);
    void saveLanguage(Language language);
    Language getLanguage(String code);
    List<Language> getLanguages();
}
