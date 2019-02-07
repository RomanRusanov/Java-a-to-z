package ru.rrusanov.log4j2;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.02.2019
 * <p>
 * The class .
 */
public class UsageLog4j2 {
    /**
     * comment.
     */
    private static final Logger LOG = LogManager.getLogger(UsageLog4j2.class.getName());

    /**
     * Main method.
     * @param args arguments.
     */
    public static void main(String[] args) {

        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
