package org.alvin.auth.system.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by tangzhichao on 2016/12/8.
 */
@Component
public class AuthPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        ScopeUser scopeUser = (ScopeUser) authentication.getPrincipal();
        System.out.println("----");
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        System.out.println("11111");
        return false;
    }
}
