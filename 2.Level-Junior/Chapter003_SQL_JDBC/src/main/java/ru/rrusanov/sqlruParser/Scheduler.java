package ru.rrusanov.sqlruParser;

import org.quartz.JobDetail;
import org.quartz.Trigger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class Scheduler {

    public void init() {
        // define the job and tie it to our HelloJob class
        JobDetail job = newJob(Parser.class)
                .withIdentity("myJob", "group1") // name "myJob", group "group1"
                .build();

        // Trigger the job to run now, and then every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(40)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
    }
}
