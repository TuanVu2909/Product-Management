package com.technology.apigateway.config.scheduling;

import com.technology.apigateway.service.SMSSendingService;
import com.technology.apigateway.service.impl.SMSSendingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private SMSSendingService smsSendingService;


    @Scheduled(cron = "0 15 8 * * ?")
    public void scheduledSendSms() {
        smsSendingService.getFindSMSByMobile();
    }

    @Scheduled(cron = "0 20 8 * * ?")
    public void scheduledCallSmsWebHook() {
        smsSendingService.callSmsByWebHook();
    }
}
