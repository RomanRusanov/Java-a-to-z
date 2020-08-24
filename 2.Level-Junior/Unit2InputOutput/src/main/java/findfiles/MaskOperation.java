package findfiles;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.08.2020
 * email roman9628@gmail.com
 * The class check if file math by passed mask.
 */
public class MaskOperation implements OperationOnFiles {
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
        return "m";
    }

    /**
     * The method implements logic how compare.
     * Take string params "n" and replace each "." to "[.]" and after
     *  replace each "*" to ".*" that need to make correct regex.
     * After compare filename with regex.
     * @param file File to compare.
     * @param args Instance with args.
     * @return If match return true, otherwise false.
     */
    @Override
    public boolean fileMathCondition(Path file, ArgsName args) {
        String maskToFind = args.get("n").replace(".", "[.]").replace("*", ".*");
        getPattern(maskToFind);
        Matcher matcher = this.mask.matcher(file.toString());
        return matcher.find();
    }

    /**
     * The method generate pattern for regex.
     * @param parsedMask mask string for regex.
     */
    public void getPattern(String parsedMask) {
        if (this.mask == null) {
            this.mask = Pattern.compile(parsedMask);
        }
    }
}