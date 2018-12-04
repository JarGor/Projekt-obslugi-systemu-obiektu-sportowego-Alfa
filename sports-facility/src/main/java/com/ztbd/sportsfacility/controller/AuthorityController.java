package com.ztbd.sportsfacility.controller;

import com.ztbd.sportsfacility.model.Authority;
import com.ztbd.sportsfacility.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @PostMapping("/authorities")
    public Authority addAuthority(@RequestBody Authority authority) {
        authorityService.saveAuthority(authority);
        return authority;
    }

    @GetMapping("/authorities")
    public List<Authority> getAuthorities() {
        return authorityService.getAuthorities();
    }

    @DeleteMapping("/authorities/{username}/{authority}")
    public void deleteAuthority(@PathVariable String username, @PathVariable String authority) {
        authorityService.deleteAuthority(username, authority);
    }

    @GetMapping("/authorities/{username}/{authority}")
    public Authority getAuthority(@PathVariable String username, @PathVariable String authority) {
        return authorityService.getAuthority(username, authority);
    }

    @GetMapping("/authorities/{username}")
    public List<String> getUserAuthorities(@PathVariable String username) {
        return authorityService.getAuthorities(username);
    }
}
