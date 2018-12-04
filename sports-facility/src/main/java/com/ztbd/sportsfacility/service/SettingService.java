package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.model.Setting;
import com.ztbd.sportsfacility.model.SettingId;

import java.util.List;
import java.util.Map;

public interface SettingService {
    void deleteSetting(SettingId id);
    void deleteSetting(String username, String setting);
    void saveSetting(Setting setting);
    Setting getSetting(SettingId id);
    String getSettingValue(String username, String setting);
    List<Setting> getSettings();
    Map<String, String> getSettings(String username);
}
