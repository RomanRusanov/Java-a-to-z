package findfiles;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.08.2020
 * email roman9628@gmail.com
 * The class check if file math by passed regex.
 */
public class RegexOperation implements OperationOnFiles {
    /**
     * The filed contain patter to compare.
     */
    private Pattern mask;
    /**
     * The method return key of operation.
     * @return String.
     */
    @Override
    public String getKey() {
        return "r";
    }
    /**
     * The method implements logic how compare.
     * Take string params "n" and compile regex.
     * After compare filename with regex.
     * @param file File to compare.
     * @param args Instance with args.
     * @return If match return true, otherwise false.
     */
    @Override
    public boolean fileMathCondition(Path file, ArgsName args) {
        getPattern(args.get("n"));
        Matcher matcher = this.mask.matcher(file.toString());
        return matcher.find();
    }

    /**
     * The method generate pattern for regex.
     * If string with regex mot correct throw exception.
     * @param regex regex.
     */
    public void getPattern(String regex) {
        if (this.mask == null) {
            try {
                this.mask = Pattern.compile(regex);
            } catch (PatternSyntaxException e) {
                System.out.printf("Passed RegEx: %s not correct, and can't compiled!", regex);
                e.printStackTrace();
            }
        }
    }
}