package consolechat;
/**
 * The interface describes the input.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 24.01.17
 */
public interface Input {
    /**
     * The method take message and return string.
     * @param question String
     * @return String
     */
    String ask(String question);
}
