package ru.rrusanov.sqlruParser;

import org.quartz.*;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class ParserScheduler {

    public void initScheduler() {
        SchedulerFactory schedulerFactory = new org.quartz.impl.StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        // define the job and tie it to our Parser class
        JobDetail job = newJob(Parser.class)
                .withIdentity("parser", "group1")
                .build();
        // Trigger
        Trigger trigger = newTrigger()
                .withIdentity("ParserTriggerEveryDay", "group1")
                .startNow()
                //.withSchedule(cronSchedule("0 0 12 * * ?"))
                .withSchedule(cronSchedule("0/10 * * * * ?"))
                .build();
        // Tell quartz to schedule the job using our trigger
        try {
            scheduler.scheduleJob(job, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
