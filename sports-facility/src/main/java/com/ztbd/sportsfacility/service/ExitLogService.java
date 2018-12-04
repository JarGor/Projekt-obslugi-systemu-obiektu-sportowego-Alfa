package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.model.ExitLog;
import com.ztbd.sportsfacility.model.ExitLogId;

import java.util.List;

public interface ExitLogService {
    void deleteExitLog(ExitLogId id);
    void saveExitLog(ExitLog exitLog);
    ExitLog getExitLog(ExitLogId id);
    List<ExitLog> getExitLogs();
}
