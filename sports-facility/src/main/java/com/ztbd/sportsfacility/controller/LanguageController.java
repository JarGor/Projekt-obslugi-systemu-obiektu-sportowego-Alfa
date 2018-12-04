package com.ztbd.sportsfacility.controller;

import com.ztbd.sportsfacility.model.Language;
import com.ztbd.sportsfacility.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping("/languages")
    public Language addLanguage(@RequestBody Language language) {
        languageService.saveLanguage(language);
        return language;
    }

    @GetMapping("/languages")
    public List<Language> getLanguages() {
        return languageService.getLanguages();
    }

    @DeleteMapping("/languages/{langCode}")
    public void deleteLanguage(@PathVariable String langCode) {
        languageService.deleteLanguage(langCode);
    }

    @GetMapping("/languages/{langCode}")
    public Language getLanguage(@PathVariable String langCode) {
        return languageService.getLanguage(langCode);
    }
}
