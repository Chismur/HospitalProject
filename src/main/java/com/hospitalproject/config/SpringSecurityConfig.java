package com.hospitalproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * Created by kingm on 26.11.2017.
 */
@Configuration
@EnableGlobalMethodSecurity
public class SpringSecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) {
        try {
            authenticationManagerBuilder.inMemoryAuthentication()
                    .withUser("matvey").password("1234").roles("USER")
                    .and().withUser("admin").password("admin").roles("USER", "ADMIN");
        } catch (Exception exception) {
            System.out.println("In Memory Authentication has failed");
        }
    }
}
