package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.model.Authority;
import com.ztbd.sportsfacility.model.AuthorityId;

import java.util.List;
import java.util.Map;

public interface AuthorityService {
    void deleteAuthority(AuthorityId id);
    void deleteAuthority(String username, String authority);
    void saveAuthority(Authority authority);
    Authority getAuthority(AuthorityId id);
    Authority getAuthority(String username, String authority);
    List<Authority> getAuthorities();
    List<String> getAuthorities(String username);
}
