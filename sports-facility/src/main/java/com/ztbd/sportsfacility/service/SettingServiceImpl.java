package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.dao.SettingRepository;
import com.ztbd.sportsfacility.model.Setting;
import com.ztbd.sportsfacility.model.SettingId;
import com.ztbd.sportsfacility.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    private SettingRepository settingRepository;

    @Autowired
    private UserService userService;

    @Override
    public void deleteSetting(SettingId id) {
        settingRepository.deleteById(id);
    }

    @Override
    public void deleteSetting(String username, String setting) {
        User user = userService.getUser(username);
        SettingId id = new SettingId(user, setting);
        deleteSetting(id);
    }

    @Override
    public void saveSetting(Setting setting) {
        settingRepository.save(setting);
    }

    @Override
    public Setting getSetting(SettingId id) {
        return settingRepository.findById(id).orElse(null);
    }

    @Override
    public String getSettingValue(String username, String setting) {
        User user = userService.getUser(username);
        SettingId id = new SettingId(user, setting);
        return settingRepository.findById(id).orElse(null).getValue();
    }

    @Override
    public List<Setting> getSettings() {
        List<Setting> settings = new ArrayList<>();
        settingRepository.findAll().forEach(e -> settings.add(e));
        return settings;
    }

    @Override
    public Map<String, String> getSettings(String username) {
        User user = userService.getUser(username);
        Map<String, String> settings = user.getUserSettings();
        return settings;
    }
}
