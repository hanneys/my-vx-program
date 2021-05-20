package com.eve.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @Author han aijun
 * @Date 2021/5/20 14:34
 * @Version 1.0
 */
@Configuration
@Slf4j
public class SaticScheduleTask {


    @Scheduled(cron = "0 */1 * * * ?")
    private void configureTasks() {
        log.info("执行静态1分钟定时任务时间: " + LocalDateTime.now());
    }


    @Scheduled(cron = "0 */5 * * * ?")
    private void configureTaskss() {
        log.info("执行静态5分钟定时任务时间: " + LocalDateTime.now());
    }
}
