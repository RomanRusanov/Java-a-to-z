package ru.rrusanov.sqlruParser;

public class StartParser {

    public static void main(String[] args) {
        Config config = new Config(args[0]);
        String cronTime = config.getConfig().getProperty("cron.time");
        String configFile = args[0];
        ParserScheduler scheduler = new ParserScheduler(cronTime, configFile);
        scheduler.initScheduler();
    }
}
