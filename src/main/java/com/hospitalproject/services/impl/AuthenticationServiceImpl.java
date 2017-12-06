package com.hospitalproject.services.impl;

import com.hospitalproject.services.interfaces.IAuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 * Created by kingm on 26.11.2017.
 */
@Service
public class AuthenticationServiceImpl implements IAuthentificationService{

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * Authenticates the Authentication toekn past in.
     * @param proposedAuthenticationToken contains username and password to authenticate
     * @return Authentication object
     * @throws AuthenticationException if authentication fails (a runtime exception)
     */

    @Override
    public Authentication authenticate(Authentication proposedAuthenticationToken) throws AuthenticationException{
        Authentication authenticatedToken = authenticationManager.authenticate(proposedAuthenticationToken);
        System.out.println("User< {} > has been authenticated successfully");
        return authenticatedToken;
    }


}
