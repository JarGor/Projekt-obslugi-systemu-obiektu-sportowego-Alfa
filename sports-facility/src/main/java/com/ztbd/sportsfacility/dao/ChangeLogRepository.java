package com.ztbd.sportsfacility.dao;

import com.ztbd.sportsfacility.model.ChangeLog;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface ChangeLogRepository extends CrudRepository<ChangeLog, LocalDate> {}