package com.mock.mock.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulingConfig {
    @Scheduled(cron = "0 0 0 * * ?") // Every day at midnight
    public void performTask() {
        System.out.println("Executing scheduled task");
    }
}
