package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.dao.ChangeLogRepository;
import com.ztbd.sportsfacility.model.ChangeLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChangeLogServiceImpl implements ChangeLogService {

    @Autowired
    private ChangeLogRepository changeLogRepository;

    @Override
    public void deleteChangeLog(int year, int month, int day) {
        LocalDate localDate = LocalDate.of(year, month, day);
        changeLogRepository.deleteById(localDate);
    }

    @Override
    public void saveChangeLog(ChangeLog changeLog) {
        changeLogRepository.save(changeLog);
    }

    @Override
    public ChangeLog getChangeLog(int year, int month, int day) {
        LocalDate localDate = LocalDate.of(year, month, day);
        return changeLogRepository.findById(localDate).orElse(null);
    }

    @Override
    public List<ChangeLog> getChangeLogs() {
        List<ChangeLog> changeLogs = new ArrayList<>();
        changeLogRepository.findAll().forEach(e -> changeLogs.add(e));
        return changeLogs;
    }
}
