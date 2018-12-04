package com.ztbd.sportsfacility.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "tinyint(1)")
    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "primaryKey.user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Authority> authorities;

    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "primaryKey.user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Setting> settings;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> userAuthorities;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Map<String, String> userSettings;

    public User() {}

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public void addAuthority(Authority authority) {
        if(authorities == null) {
            authorities = new ArrayList<>();
        }

        authorities.add(authority);
    }

    public List<Setting> getSettings() {
        return settings;
    }

    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

    public void addSetting(Setting setting) {
        if(settings == null) {
            settings = new ArrayList<>();
        }

        settings.add(setting);
    }

    public List<String> getUserAuthorities() {
        if (authorities != null) {
            userAuthorities = new ArrayList<>();
            for(Authority authority: authorities) {
                userAuthorities.add(authority.getAuthority());
            }
        }
        return userAuthorities;
    }

    public void setUserAuthorities(List<String> userAuthorities) {
        this.userAuthorities = userAuthorities;
    }

    public Map<String, String> getUserSettings() {
        if (settings != null) {
            userSettings = new HashMap<>();
            for(Setting setting: settings) {
                userSettings.put(setting.getSetting(), setting.getValue());
            }
        }
        return userSettings;
    }

    public void setUserSettings(Map<String, String> userSettings) {
        this.userSettings = userSettings;
    }
}