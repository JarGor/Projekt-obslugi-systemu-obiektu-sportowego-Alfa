package com.ztbd.sportsfacility.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "static_texts")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.language",
                joinColumns = @JoinColumn(name = "lang_code")),
        @AssociationOverride(name = "primaryKey.name",
                joinColumns = @JoinColumn(name = "name"))
})
public class StaticText {

    @EmbeddedId
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private StaticTextId primaryKey;

    private String content;

    public StaticText() {}

    public StaticTextId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(StaticTextId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public Language getLanguage() {
        return getPrimaryKey().getLanguage();
    }

    public void setLanguage(Language language) {
        getPrimaryKey().setLanguage(language);
    }

    @Transient
    public String getName() {
        return getPrimaryKey().getName();
    }

    public void setName(String name) {
        getPrimaryKey().setName(name);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}