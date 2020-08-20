package terminal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    private String currentPath = "/";
    /**
     * The field contain pattern to math string with sub folders.
     */
    Pattern patternWithSubFolder = Pattern.compile("^.*[/](.*[/?])$");
    /**
     * The field contain pattern to string with one folder.
     */
    Pattern patternOnlyFolder = Pattern.compile("^[0-9,A-z]+");

    /**
     * The method take string with path and change current directory.
     * @param path String with path to change.
     */
    public void cd(String path) {
        String[] commands = path.split("/");
        for (String command : commands) {
            if (path.equals("/")) {
                this.currentPath = "/";
                break;
            }
            if (patternOnlyFolder.matcher(command).find()) {
                this.currentPath = this.currentPath.concat(command);
                this.currentPath = this.currentPath.concat("/");
            }
            if (command.equals("..")) {
                Matcher matcher = patternWithSubFolder.matcher(this.currentPath);
                String strFindInRegEx = "";
                while (matcher.find()) {
                    strFindInRegEx = matcher.group(1);
                    this.currentPath = this.currentPath.replace(strFindInRegEx, "");
                }
            }
        }
    }

    /**
     * The method print work directory.
     * @return String with current path.
     */
    public String pwd() {
        return this.currentPath;
    }
}