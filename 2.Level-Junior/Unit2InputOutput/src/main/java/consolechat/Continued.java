package consolechat;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.08.2020
 * email roman9628@gmail.com
 * The class describe behavior when user type "продолжить".
 * Print to console random string from file, and add this string to log.
 */
public class Continued implements Action {
    /**
     * The method implements behavior when user type some text.
     * @param chat Instance chat.
     */
    @Override
    public void execute(Chat chat) {
        chat.setStop(false);
        String random = chat.getRandomString();
        chat.getLog().add(random);
        System.out.println(random);
    }
}