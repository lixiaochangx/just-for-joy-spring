package com.xc.justforjoy.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.List;

/**
 * 创建需要执行的“计划任务”。需要实现Quartz框架提供的Job接口
 *
 * @author lxcecho
 * @since 2020/7/30
 */
public class PlanJob implements Job {

    private RemindService remindService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        /*remindService = new RemindService();
        remindService.callClassMeeting();*/

        /*System.out.println("触发器的key值（触发器组名+触发器名）:" + jobExecutionContext.getTrigger().getKey()
                + "\t任务的key值（任务组名+任务名）" + jobExecutionContext.getJobDetail().getKey());*/

        JobDataMap dataMap = jobExecutionContext.getJobDetail()
                .getJobDataMap();
        List students = (List) dataMap.get("students");
        System.out.println(students);

    }

}
