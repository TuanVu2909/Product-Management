package com.technology.apigateway.config.scheduling;

import com.technology.apigateway.service.impl.SMSSendingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);


    private SMSSendingServiceImpl smsSendingService;


    @Scheduled(cron = "0 0 8 * * ?")
    public void scheduledSendSms() {
        smsSendingService.getFindSMSByMobile();
    }

}
