package org.alvin.opsdev.sync.mgr.config;

import org.alvin.opsdev.sync.mgr.service.ProcessService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/24.
 */
@Component
@EnableScheduling
public class JobConfiguratioin {

    @Autowired
    private ProcessService processService;


    @Scheduled(cron = "0 0 * * * *")
    public void execute() {
        try {
            processService.exec();
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(this.getClass()).error(e);
        }
    }

}
