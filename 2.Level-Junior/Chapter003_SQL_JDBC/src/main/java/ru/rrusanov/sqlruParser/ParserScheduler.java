package ru.rrusanov.sqlruParser;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class ParserScheduler {

    private final String cronTime;
    private final String configFile;

    public ParserScheduler(String cronTime, String configFile) {
        this.cronTime = cronTime;
        this.configFile = configFile;
    }

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
                .usingJobData("configFile", this.configFile)
                .withIdentity("parser", "group1")
                .build();
        // Trigger
        Trigger trigger = newTrigger()
                .withIdentity("ParserTriggerEveryDay", "group1")
                .startNow()
                .withSchedule(cronSchedule(this.cronTime))
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
