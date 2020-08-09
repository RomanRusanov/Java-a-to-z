package file;
import java.io.File;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 09.08.2020
 * email roman9628@gmail.com
 * The class print to console all files names and size in directory.
 */
public class Dir {
    /**
     * The main method.
     * @param args Strings args.
     */
    public static void main(String[] args) {
        File file = new File("c:\\projects\\Java-a-to-z");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        for (File subfile : file.listFiles()) {
            if (subfile.isFile()) {
                System.out.println(subfile.getAbsoluteFile() + String.format("  size: %s", subfile.length()));
            }
        }
    }
}