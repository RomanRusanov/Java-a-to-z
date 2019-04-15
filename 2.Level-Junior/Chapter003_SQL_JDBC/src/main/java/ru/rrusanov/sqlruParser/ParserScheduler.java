package ru.rrusanov.sqlruParser;

import org.quartz.*;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class ParserScheduler {
    public void initScheduler() throws SchedulerException {
        SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
        Scheduler sched = schedFact.getScheduler();
        // define the job and tie it to our Parser class
        JobDetail job = newJob(Parser.class)
                .withIdentity("parser", "group1")
                .usingJobData("firstStart", true)
                .build();
        // Trigger the job to run now, and then every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("ParserTriggerEveryDay", "group1")
                .startNow()
                //.withSchedule(cronSchedule("0 0 12 * * ?"))
                .withSchedule(cronSchedule("0 7 13 * * ?"))
                .build();
        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
        sched.start();
    }
}
