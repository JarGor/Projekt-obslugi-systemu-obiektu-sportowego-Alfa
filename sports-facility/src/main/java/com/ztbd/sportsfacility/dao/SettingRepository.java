package com.ztbd.sportsfacility.dao;

import com.ztbd.sportsfacility.model.Setting;
import com.ztbd.sportsfacility.model.SettingId;
import org.springframework.data.repository.CrudRepository;

public interface SettingRepository extends CrudRepository<Setting, SettingId> {}