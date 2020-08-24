package findfiles;
import java.nio.file.Path;

/**
 * The interface implements operation how search file.
 */
public interface OperationOnFiles {
    /**
     * The method return key value.
     * @return String value;
     */
    String getKey();

    /**
     * The method implements logic how compare.
     * @param file File to compare.
     * @param args Instance with args.
     * @return If match return true, otherwise false.
     */
    boolean fileMathCondition(Path file, ArgsName args);
}