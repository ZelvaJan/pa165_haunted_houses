/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.pa165_haunted_houses.mvc.config;

import com.peta2kuba.pa165_haunted_houses.dto.PersonAuthenticateDTO;
import com.peta2kuba.pa165_haunted_houses.facade.PersonFacade;
import com.peta2kuba.pa165_haunted_houses.mvc.controllers.AbilityController;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 *
 * @author zelva
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PersonFacade personFacade;

    final static Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    /**
     * Authetication method
     * @param authentication
     * @return
     */
    @Override
    public Authentication authenticate(Authentication authentication) {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        PersonAuthenticateDTO personAuthenticateDTO = new PersonAuthenticateDTO(email, password);
        try {
            if (personFacade.authenticate(personAuthenticateDTO) && personFacade.isAdmin(personFacade.findPersonByEmail(email))) {
                logger.debug("Login succes");
                List<GrantedAuthority> grantedAuths = new ArrayList<>();
                grantedAuths.add(new SimpleGrantedAuthority("ADMIN"));
                Authentication auth = new UsernamePasswordAuthenticationToken(email, password, grantedAuths);
                return auth;
            } else {
                logger.error("Login failed");
            }
        } catch (Exception e) {
            logger.error("Login exception.", e);
        }
        return null;
    }

    /**
     *
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
