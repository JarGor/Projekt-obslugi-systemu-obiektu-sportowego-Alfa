package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.dao.ExitLogRepository;
import com.ztbd.sportsfacility.model.ExitLog;
import com.ztbd.sportsfacility.model.ExitLogId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExitLogServiceImpl implements ExitLogService {

    @Autowired
    private ExitLogRepository exitLogRepository;

    @Override
    public void deleteExitLog(ExitLogId id) {
        exitLogRepository.deleteById(id);
    }

    @Override
    public void saveExitLog(ExitLog exitLog) {
        exitLogRepository.save(exitLog);
    }

    @Override
    public ExitLog getExitLog(ExitLogId id) {
        return exitLogRepository.findById(id).orElse(null);
    }

    @Override
    public List<ExitLog> getExitLogs() {
        List<ExitLog> exitLogs = new ArrayList<>();
        exitLogRepository.findAll().forEach(e -> exitLogs.add(e));
        return exitLogs;
    }
}
