package com.hospitalproject.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by kingm on 26.11.2017.
 */
public interface IAuthentificationService {
    Authentication authenticate(Authentication authenticationToken) throws AuthenticationException;

}
