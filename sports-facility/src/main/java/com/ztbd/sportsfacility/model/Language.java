package com.ztbd.sportsfacility.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "languages")
public class Language {

    @Id
    @Column(nullable = false)
    private String code;

    private String lang;

    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "primaryKey.language")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<StaticText> staticTexts;

    public Language() {}

    public Language(String code, String lang) {
        this.code = code;
        this.lang = lang;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<StaticText> getStaticTexts() {
        return staticTexts;
    }

    public void setStaticTexts(List<StaticText> staticTexts) {
        this.staticTexts = staticTexts;
    }

    public void addStaticText(StaticText staticText) {
        if(staticTexts == null) {
            staticTexts = new ArrayList<>();
        }

        staticTexts.add(staticText);
    }
}