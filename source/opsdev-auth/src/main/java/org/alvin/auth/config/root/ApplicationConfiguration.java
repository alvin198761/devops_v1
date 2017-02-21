package org.alvin.auth.config.root;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by tangzhichao on 2016/8/16.
 */
@Configuration
@ComponentScan(basePackages = {
        "org.alvin.auth.system"
})
@PropertySource(value = {
        "classpath:jdbc.properties",
        "classpath:application.properties"
})
public class ApplicationConfiguration {

    public ApplicationConfiguration() {

    }
}
