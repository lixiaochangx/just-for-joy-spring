package com.xc.justforjoy.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lxcecho
 * @since 2020/7/30
 */
public class TestJob {

	public void doRemind() throws SchedulerException, ParseException {
		
		// 创建一个任务
		JobDetail job = JobBuilder.newJob(PlanJob.class).withIdentity("RemindJob", "group1").build();
		
		//JobMap
		JobDataMap dataMap= job.getJobDataMap();
		List<String> students = new ArrayList<String>();
		students.add("张三");
		students.add("李四");
		dataMap.put("students", students);
		
		// 创建一个TriggerBuilder对象，为闯进触发器Trigger对象做准备
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
		
		// 为TriggerBuilder创建唯一标识符
		// 设置该对象的名字为trigger1，所在组名为group1
		triggerBuilder = triggerBuilder.withIdentity("trigger1", "group1");
		
		// 设置触发器的开始执行时间：立即执行
		triggerBuilder.startNow();
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//设置触发器开始执行时间为2018-08-29 11:20:30
		Date startDate = new Date();
		startDate = sdf.parse("2018-08-29 11:20:10");
		triggerBuilder.startAt(startDate);
		
		//设置触发器结束执行时间
		Date endDate = new Date();
		endDate = sdf.parse("2018-08-29 11:21:00");
		triggerBuilder.endAt(endDate);*/
		
		// 创建一个SimpleScheduleBuilder对象，为创建触发器Trigger对象做准备
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
		
		// 设置重复执行时间间隔为1秒
		scheduleBuilder = scheduleBuilder.withIntervalInMilliseconds(1000);
		
		// 设置额外重复执行次数。例如：设置为5
		// 表示一共要执行6次，（正常执行一次+额外重复5次）
		scheduleBuilder.withRepeatCount(5);
		
		// 根据TriggerBuilder对象和SimpleScheduleBuilder对象，创建一个简单触发器SimpleTrigger对象
		SimpleTrigger simpleTrigger = triggerBuilder.withSchedule(scheduleBuilder).build();
		
		// 创建调度器工厂
		SchedulerFactory sfc = new StdSchedulerFactory();
		
		// 创建一个调度器
		Scheduler sched = sfc.getScheduler();
		
		// 在调度器中，注册任务和触发器
		sched.scheduleJob(job, simpleTrigger);
		
		// 执行调度
		sched.start();
		
		// 关闭调度
//		 sched.shutdown();

	}

	public static void main(String[] args) throws SchedulerException, ParseException {
		TestJob testJob = new TestJob();
		testJob.doRemind();
	}

}
