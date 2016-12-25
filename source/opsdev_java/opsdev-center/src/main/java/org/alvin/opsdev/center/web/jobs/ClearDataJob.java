package org.alvin.opsdev.center.web.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by tangzhichao on 2016/11/3.
 */
@Component
public class ClearDataJob {

    @Scheduled(fixedDelayString = "${time}")
    public void clearLog() {
       // System.out.println("clear logs");
    }

}
