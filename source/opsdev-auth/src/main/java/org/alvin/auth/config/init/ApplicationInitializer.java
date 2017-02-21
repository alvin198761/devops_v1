package org.alvin.auth.config.init;

import org.alvin.auth.config.jpa.JpaConfiguration;
import org.alvin.auth.config.root.ApplicationConfiguration;
import org.alvin.auth.config.security.SecurityConfiguration;
import org.alvin.auth.config.servlet.ServletConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by tangzhichao on 2016/8/16. web 系统启动的时候会先加载这个类作为启动类
 */
@Order(1)
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                ApplicationConfiguration.class,
                JpaConfiguration.class,
                SecurityConfiguration.class,
//				GlobalSecurityConfig.class
        };
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ServletConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
