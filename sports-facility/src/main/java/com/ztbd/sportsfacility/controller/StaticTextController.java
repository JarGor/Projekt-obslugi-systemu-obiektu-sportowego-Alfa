package com.ztbd.sportsfacility.controller;

import com.ztbd.sportsfacility.model.Language;
import com.ztbd.sportsfacility.model.StaticText;
import com.ztbd.sportsfacility.model.StaticTextId;
import com.ztbd.sportsfacility.service.LanguageService;
import com.ztbd.sportsfacility.service.StaticTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StaticTextController {

    @Autowired
    private StaticTextService staticTextService;

    @Autowired
    private LanguageService languageService;

    @PostMapping("/staticTexts")
    public StaticText addStaticText(@RequestBody StaticText staticText) {
        staticTextService.saveStaticText(staticText);
        return staticText;
    }

    @GetMapping("/staticTexts")
    public List<StaticText> getStaticTexts() {
        return staticTextService.getStaticTexts();
    }

    @DeleteMapping("/staticTexts/{name}/{langCode}")
    public void deleteStaticText(@PathVariable String name, @PathVariable String langCode) {
        Language lang = languageService.getLanguage(langCode);
        StaticTextId id = new StaticTextId(name, lang);
        staticTextService.deleteStaticText(id);
    }

    @GetMapping("/staticTexts/{name}/{langCode}")
    public StaticText getStaticText(@PathVariable String name, @PathVariable String langCode) {
        Language lang = languageService.getLanguage(langCode);
        StaticTextId id = new StaticTextId(name, lang);
        return staticTextService.getStaticText(id);
    }
}
