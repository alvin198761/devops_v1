package org.alvin.opsdev.core.listener;

import org.alvin.opsdev.core.annotation.ObjectFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/12/11.
 */
@Component
public class StartUpListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ObjectFactory objectFactory;

    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            objectFactory.doScanService("org.alvin.opsdev.core.executor");
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
