package com.xc.justforjoy.quartz02;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho
 * @since 2020/7/30
 */
public class TestJobWithSpring {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scheduler scheduler = (Scheduler) ctx.getBean("schedulerFactoryBean");
        //计划任务在100 秒内有效
        scheduler.start();
        Thread.sleep(100000);
        scheduler.shutdown();
    }

}
