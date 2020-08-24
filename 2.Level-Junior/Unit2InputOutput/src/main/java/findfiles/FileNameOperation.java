package findfiles;
import java.nio.file.Path;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.08.2020
 * email roman9628@gmail.com
 * The class Compare passed file name. Must be fully identical.
 */
public class FileNameOperation implements OperationOnFiles {
    /**
     * The method return key of operation.
     * @return String.
     */
    @Override
    public String getKey() {
        return "f";
    }

    /**
     * The method implements logic how compare.
     * If file name math full with passed.
     * @param file File to compare.
     * @param args Instance with args.
     * @return If match return true, otherwise false.
     */
    @Override
    public boolean fileMathCondition(Path file, ArgsName args) {
        String nameToFind = args.get("n");
        return file.toFile().getName().equals(nameToFind);
    }
}