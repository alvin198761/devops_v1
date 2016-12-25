package org.alvin.opsdev.center.config;

import org.alvin.opsdev.center.client.CommandClient;
import org.alvin.opsdev.center.client.FileClient;
import org.alvin.opsdev.center.client.RestfulClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tangzhichao on 2016/11/3.
 */
@Configuration
public class AppConfiguration {

    @Value("${opsdev.engin.ip}")
    private String rest_ip;

    @Value("${opsdev.engin.port}")
    private int rest_port;

    @Autowired
    private RestfulClient restfulClient;

    @Bean
    public CommandClient commandClient() {
        return restfulClient.getClient(rest_ip, rest_port, CommandClient.class);
    }

    @Bean
    public FileClient fileClient() {
        return restfulClient.getClient(rest_ip, rest_port, FileClient.class);
    }


}
