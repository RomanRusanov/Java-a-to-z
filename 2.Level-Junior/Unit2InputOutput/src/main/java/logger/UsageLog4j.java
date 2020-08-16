package logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    /**
     * The main method.
     * @param args String args.
     */
    public static void main(String[] args) {
        boolean booleanVar = false;
        byte byteVar = 127;
        short shortVar = 32767;
        int intVar = 2147483647;
        long longVar = 9223372036854775807L;
        float floatVar = 3.40282347E+38f;
        double doubleVar = 1.7976931348623157E+308d;
        char charVar = 65535;
        LOG.debug(String.format("%n boolean: {}%n byteVar: {}%n shortVar: "
                + "{}%n intVar: {}%n longVar: {}%n floatVar: {}%n "
                + "doubleVar: {}%n charVar : {}"), booleanVar, byteVar,
                shortVar, intVar, longVar, floatVar, doubleVar, charVar);
    }
}