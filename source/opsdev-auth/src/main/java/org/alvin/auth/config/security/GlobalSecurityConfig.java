package org.alvin.auth.config.security;

import org.alvin.auth.system.security.AuthPermissionEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * Created by tangzhichao on 2016/9/20.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GlobalSecurityConfig extends GlobalMethodSecurityConfiguration {

    public GlobalSecurityConfig() {
    }

    @Autowired
    private AuthPermissionEvaluator authPermissionEvaluator;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler handler = (DefaultMethodSecurityExpressionHandler) super.createExpressionHandler();
        handler.setPermissionEvaluator(authPermissionEvaluator);
        return handler;
    }

}
