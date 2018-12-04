package com.ztbd.sportsfacility.controller;

import com.ztbd.sportsfacility.model.Setting;
import com.ztbd.sportsfacility.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @PostMapping("/settings")
    public Setting addSetting(@RequestBody Setting setting) {
        settingService.saveSetting(setting);
        return setting;
    }

    @GetMapping("/settings/{username}")
    public Map<String, String> getSettings(@PathVariable String username) {
        return settingService.getSettings(username);
    }

    @GetMapping("/settings")
    public List<Setting> getSettings() {
        return settingService.getSettings();
    }

    @DeleteMapping("/settings/{username}/{setting}")
    public void deleteSetting(@PathVariable String username, @PathVariable String setting) {
        settingService.deleteSetting(username, setting);
    }

    @GetMapping("/settings/{username}/{setting}")
    public String getSetting(@PathVariable String username, @PathVariable String setting) {
        return settingService.getSettingValue(username, setting);
    }
}
