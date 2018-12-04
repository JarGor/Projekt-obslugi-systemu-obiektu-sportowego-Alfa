package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.model.EnterLog;
import com.ztbd.sportsfacility.model.EnterLogId;

import java.util.List;

public interface EnterLogService {
    void deleteEnterLog(EnterLogId id);
    void saveEnterLog(EnterLog enterLog);
    EnterLog getEnterLog(EnterLogId id);
    List<EnterLog> getEnterLogs();
}
