package nonblockingcache;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 01.10.2020
 * email roman9628@gmail.com
 * The class implements runtime exception.
 * When cache may corrupt stored data.
 */
public class OptimisticException extends RuntimeException {
    /**
     * The default constructor.
     * @param s The string message to inform user.
     */
    public OptimisticException(String s) {
        super(s);
    }
}