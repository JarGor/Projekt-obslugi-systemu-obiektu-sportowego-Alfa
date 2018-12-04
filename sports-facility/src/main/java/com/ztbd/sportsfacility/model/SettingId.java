package com.ztbd.sportsfacility.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SettingId implements Serializable {

    @ManyToOne(optional = false)
    private User user;

    private String setting;

    public SettingId() {}

    public SettingId(User user, String setting) {
        this.user = user;
        this.setting = setting;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        SettingId that = (SettingId) o;
        return Objects.equals(user, that.user) &&
                setting.equalsIgnoreCase(that.setting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, setting);
    }
}
