package terminal;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 20.08.2020
 * email roman9628@gmail.com
 * The class simulate works cd command.
 */
public class Shell {
    /**
     * The field contain root directory.
     */
    private LinkedList<String> currentPath = new LinkedList<>();

    /**
     * The method take string with path and change current directory.
     * @param path String with path to change.
     */
    public void cd(String path) {
        String[] commands = path.split("/");
        for (String command : commands) {
            if (path.equals("/")) {
                this.currentPath.clear();
                break;
            }
            if (command.equals("..")) {
                this.currentPath.pollLast();
                break;
            }
            this.currentPath.addLast(command);
        }
    }

    /**
     * The method print work directory.
     * @return String with current path.
     */
    public String pwd() {
        return this.currentPath.stream().collect(Collectors.joining("/", "/", ""));
    }
}