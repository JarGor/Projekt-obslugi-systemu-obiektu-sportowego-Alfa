package com.ztbd.sportsfacility.dao;

import com.ztbd.sportsfacility.model.EnterLog;
import com.ztbd.sportsfacility.model.EnterLogId;
import org.springframework.data.repository.CrudRepository;

public interface EnterLogRepository extends CrudRepository<EnterLog, EnterLogId> {}