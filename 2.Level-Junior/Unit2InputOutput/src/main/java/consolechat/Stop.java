package consolechat;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.08.2020
 * email roman9628@gmail.com
 * The class The class describe behavior when user type "стоп".
 * Set flag in chat instance.
 */
public class Stop implements Action {
    /**
     * The method implements behavior when user type some text.
     * @param chat Instance chat.
     */
    @Override
    public void execute(Chat chat) {
        chat.setStop(true);
    }
}