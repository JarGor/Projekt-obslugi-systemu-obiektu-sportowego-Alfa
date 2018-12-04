package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.model.ChangeLog;

import java.time.LocalDate;
import java.util.List;

public interface ChangeLogService {
    void deleteChangeLog(int year, int month, int day);
    void saveChangeLog(ChangeLog changeLog);
    ChangeLog getChangeLog(int year, int month, int day);
    List<ChangeLog> getChangeLogs();
}
