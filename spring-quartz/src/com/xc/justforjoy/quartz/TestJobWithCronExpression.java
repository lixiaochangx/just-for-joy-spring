package com.xc.justforjoy.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author lxcecho
 * @since 2020/7/30
 */
public class TestJobWithCronExpression {

	public void doRemind() throws SchedulerException {
		// 创建一个任务
		JobDetail job = JobBuilder.newJob(PlanJob.class).withIdentity("RemindJob", "group1").build();

		// 创建一个TriggerBuilder对象，为闯进触发器Trigger对象做准备
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();

		triggerBuilder = triggerBuilder.withIdentity("trigger1", "group1");
		//创建一个CronScheduleBuilder对象，并通过Cron表达式指定执行时间是：每分钟的第5秒
		CronScheduleBuilder scheduleBuilder = 
				CronScheduleBuilder.cronSchedule("5 * * * * ？");
		//根据TriggerBuilder对下个SimpleScheduleBuilder对象创建一个简单的触发器SimpleTrigger对象
		CronTrigger cronTrigger = triggerBuilder.withSchedule(scheduleBuilder).build();
		//创建调度工厂
		SchedulerFactory sfc = new StdSchedulerFactory();
		//创建一个调度器
		Scheduler sched = sfc.getScheduler();
		//执行调度
		sched.start();
//		注册任务和触发器
		sched.scheduleJob(job,cronTrigger);
//		关闭调度
//		sched.shutdown();
	}
	
	public static void main(String[] args) throws SchedulerException {
		TestJobWithCronExpression test = new TestJobWithCronExpression();
		test.doRemind();
	}
	
}
