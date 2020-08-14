package consolechat;

/**
 * The interface for execute actions for certain words.
 */
public interface Action {
    /**
     * The method implements behavior when user type some text.
     * @param chat Instance chat.
     */
    void execute(Chat chat);
}
