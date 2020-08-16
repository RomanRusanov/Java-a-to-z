package logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 16.08.2020
 * email roman9628@gmail.com
 * The class Describe Log4j logger implementation.
 */
public class UsageLog4j {
    /**
     * The instance with logger.
     */
    private static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName());

    /**
     * The main method.
     * @param args String args.
     */
    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}