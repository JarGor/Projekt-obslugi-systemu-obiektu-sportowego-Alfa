package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.dao.AuthorityRepository;
import com.ztbd.sportsfacility.model.Authority;
import com.ztbd.sportsfacility.model.AuthorityId;
import com.ztbd.sportsfacility.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserService userService;

    @Override
    public void deleteAuthority(AuthorityId id) {
        authorityRepository.deleteById(id);
    }

    @Override
    public void saveAuthority(Authority authority) {
        authorityRepository.save(authority);
    }

    @Override
    public Authority getAuthority(AuthorityId id) {
        return authorityRepository.findById(id).orElse(null);
    }

    @Override
    public Authority getAuthority(String username, String authority) {
        User user = userService.getUser(username);
        AuthorityId id = new AuthorityId(user, authority);
        return getAuthority(id);
    }

    @Override
    public List<Authority> getAuthorities() {
        List<Authority> authorities = new ArrayList<>();
        authorityRepository.findAll().forEach(e -> authorities.add(e));
        return authorities;
    }

    @Override
    public List<String> getAuthorities(String username) {
        User user = userService.getUser(username);
        List<String> authorities = user.getUserAuthorities();
        return authorities;
    }

    @Override
    public void deleteAuthority(String username, String authority) {
        User user = userService.getUser(username);
        AuthorityId id = new AuthorityId(user, authority);
        deleteAuthority(id);
    }
}
