package com.ztbd.sportsfacility.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "settings")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.user",
                joinColumns = @JoinColumn(name = "username")),
        @AssociationOverride(name = "primaryKey.setting",
                joinColumns = @JoinColumn(name = "setting"))
})
public class Setting {

    @EmbeddedId
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private SettingId primaryKey;

    @Column(nullable = false)
    private String value;

    public Setting() {}

    public SettingId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(SettingId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public User getUser() {
        return getPrimaryKey().getUser();
    }

    public void setUser(User user) {
        getPrimaryKey().setUser(user);
    }

    @Transient
    public String getSetting() {
        return getPrimaryKey().getSetting();
    }

    public void setSetting(String setting) {
        getPrimaryKey().setSetting(setting);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}