package com.ztbd.sportsfacility.dao;

import com.ztbd.sportsfacility.model.Authority;
import com.ztbd.sportsfacility.model.AuthorityId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorityRepository extends CrudRepository<Authority, AuthorityId> {}