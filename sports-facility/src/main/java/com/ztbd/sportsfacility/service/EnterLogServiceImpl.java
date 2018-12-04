package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.dao.EnterLogRepository;
import com.ztbd.sportsfacility.model.EnterLog;
import com.ztbd.sportsfacility.model.EnterLogId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnterLogServiceImpl implements EnterLogService {

    @Autowired
    private EnterLogRepository enterLogRepository;

    @Override
    public void deleteEnterLog(EnterLogId id) {
        enterLogRepository.deleteById(id);
    }

    @Override
    public void saveEnterLog(EnterLog enterLog) {
        enterLogRepository.save(enterLog);
    }

    @Override
    public EnterLog getEnterLog(EnterLogId id) {
        return enterLogRepository.findById(id).orElse(null);
    }

    @Override
    public List<EnterLog> getEnterLogs() {
        List<EnterLog> enterLogs = new ArrayList<>();
        enterLogRepository.findAll().forEach(e -> enterLogs.add(e));
        return enterLogs;
    }
}
