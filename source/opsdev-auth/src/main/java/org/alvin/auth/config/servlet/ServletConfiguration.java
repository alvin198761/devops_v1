package org.alvin.auth.config.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.servlet.ServletContext;
import java.util.Properties;

/**
 * Created by tangzhichao on 2016/8/16.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.alvin.auth.system.controller"})
@EnableSpringDataWebSupport
public class ServletConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private ServletContext context;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("/favicon.ico");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver(){
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(false);
        resolver.setSuffix(".ftl");
        resolver.setContentType("text/html; charset=utf-8");
        resolver.setExposeRequestAttributes(true);
        resolver.setExposeSessionAttributes(true);
        resolver.setExposeSpringMacroHelpers(true);
        resolver.setRequestContextAttribute("request");
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(){
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/templates/");
        configurer.setDefaultEncoding("UTF-8");
        Properties properties = new Properties();
        properties.setProperty("template_update_delay", "0");
        properties.setProperty("locale", "zh_CN");
        properties.setProperty("datetime_format", "yyyy-MM-dd HH:mm:ss");
        properties.setProperty("date_format", "yyyy-MM-dd");
        properties.setProperty("number_format", "#.##");
        configurer.setFreemarkerSettings(properties);
        return configurer;
    }



}
