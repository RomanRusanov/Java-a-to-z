package consolechat;
import bufferedoutputstream.LogFilter;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.08.2020
 * email roman9628@gmail.com
 * The class describe behavior when user type "конец".
 * Save all log to file, and change state flag in chat for shutdown chat.
 */
public class End  implements Action {
    /**
     * The method implements behavior when user type some text.
     * @param chat Instance chat.
     */
    @Override
    public void execute(Chat chat) {
        LogFilter.save(chat.getLog(), chat.getFileLog().toString());
        chat.setWork(false);
    }
}