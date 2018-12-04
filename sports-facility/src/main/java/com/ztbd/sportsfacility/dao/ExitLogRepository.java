package com.ztbd.sportsfacility.dao;

import com.ztbd.sportsfacility.model.ExitLog;
import com.ztbd.sportsfacility.model.ExitLogId;
import org.springframework.data.repository.CrudRepository;

public interface ExitLogRepository extends CrudRepository<ExitLog, ExitLogId> {}