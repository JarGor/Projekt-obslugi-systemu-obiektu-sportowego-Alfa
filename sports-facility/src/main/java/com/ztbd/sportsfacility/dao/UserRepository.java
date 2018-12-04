package com.ztbd.sportsfacility.dao;

import com.ztbd.sportsfacility.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {}