package com.ztbd.sportsfacility.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/users/**").hasRole("ADMIN")
                .antMatchers("/api/register").permitAll()
                .antMatchers("/api/changeLogs/**").hasRole("ADMIN")
                .antMatchers("/api/employees/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/customers/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/files/**").hasRole("ADMIN")
                .antMatchers("/api/languages/**").hasRole("ADMIN")
                .antMatchers("/api/staticTexts/**").hasRole("ADMIN")
                .antMatchers("/api/authorities/**").hasRole("ADMIN")
                .antMatchers("/api/settings/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/services/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/purchases/**").hasAnyRole("ADMIN", "USER")
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);;
    }
}