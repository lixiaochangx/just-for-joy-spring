package com.xc.justforjoy.quartz02;

import com.xc.justforjoy.quartz.RemindService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author lxcecho
 * @since 2020/7/30
 */
public class PlanJobSpring implements Job {

    private RemindService remindService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("任务成功运行");
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        System.out.println("任务名称=【" + scheduleJob.getJobName() + "】");
        remindService = new RemindService();
        remindService.callClassMeeting();
        System.out.println();
    }


}
