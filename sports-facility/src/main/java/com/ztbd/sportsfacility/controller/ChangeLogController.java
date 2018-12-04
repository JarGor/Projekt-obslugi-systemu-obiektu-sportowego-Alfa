package com.ztbd.sportsfacility.controller;

import com.ztbd.sportsfacility.model.ChangeLog;
import com.ztbd.sportsfacility.service.ChangeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ChangeLogController {

    @Autowired
    private ChangeLogService changeLogService;

    @GetMapping("/changeLogs")
    public List<ChangeLog> getChangeLogs() {
        return changeLogService.getChangeLogs();
    }

    @GetMapping("/changeLogs/{year}/{month}/{day}")
    public ChangeLog getChangeLog(@PathVariable int year, @PathVariable int month, @PathVariable int day) {
        return changeLogService.getChangeLog(year, month, day);
    }

    @PostMapping("/changeLogs")
    public ChangeLog addChangeLog(@RequestBody ChangeLog changeLog) {
        changeLogService.saveChangeLog(changeLog);
        return changeLog;
    }

    @PutMapping("/changeLogs")
    public ChangeLog updateChangeLog(@RequestBody ChangeLog changeLog) {
        changeLogService.saveChangeLog(changeLog);
        return changeLog;
    }

    @DeleteMapping("/changeLogs/{year}/{month}/{day}")
    public void deleteChangeLog(@PathVariable int year, @PathVariable int month, @PathVariable int day) {
        changeLogService.deleteChangeLog(year, month, day);
    }
}
