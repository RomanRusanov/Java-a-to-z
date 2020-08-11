package scanfilesystem;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 09.08.2020
 * email roman9628@gmail.com
 * The class search files certain extension and print to console
 *  relative path.
 */
public class Search {
    /**
     * The main method.
     * Should be two params. First root folder example(.).
     * Second file extension example(xml).
     * @param args String args.
     * @throws IOException walkFileTree may throw.
     */
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("First parameter not found! "
                    + "Root folder is null. "
                    + "Usage java -jar search.jar ROOT_FOLDER.");
        }
        if (args.length == 1) {
            throw new IllegalArgumentException("Second parameter not found! "
                    + "Extension of file is null."
                    + " Usage java -jar search.jar ROOT_FOLDER. xml");
        }
        Path start = Paths.get(args[0]);
        search(start, args[1]).forEach(System.out::println);
    }

    /**
     * The method take root(start) position in file system tree and
     * find files that extension math.
     * @param root Path to start.
     * @param ext String extension.
     * @return List whit fined paths.
     */
    public static List<Path> search(Path root, String ext) {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        try {
            Files.walkFileTree(root, searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searcher.getPaths();
    }
}