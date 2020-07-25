package com.deni.gunawan.belajar.spring.belajarswitchuser.utility;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.switchuser.SwitchUserGrantedAuthority;

public class SwitchUserHelper {
    public static Authentication userAsli(Authentication currentUser) {
        for (GrantedAuthority auth : currentUser.getAuthorities()) {
            if (SwitchUserGrantedAuthority.class.isAssignableFrom(auth.getClass())) {
                SwitchUserGrantedAuthority
                        original = (SwitchUserGrantedAuthority) auth;
                return original.getSource();
            }
        }
        return null;
    }
}
