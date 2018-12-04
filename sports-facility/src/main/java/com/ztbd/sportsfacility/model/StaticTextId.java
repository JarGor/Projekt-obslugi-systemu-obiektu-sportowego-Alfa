package com.ztbd.sportsfacility.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StaticTextId implements Serializable {

    @ManyToOne(optional = false)
    private Language language;

    private String name;

    public StaticTextId() {}

    public StaticTextId(String name, Language language) {
        this.name = name;
        this.language = language;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        StaticTextId that = (StaticTextId) o;
        return Objects.equals(language, that.language) &&
                name.equalsIgnoreCase(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, name);
    }
}