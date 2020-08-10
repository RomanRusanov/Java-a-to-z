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
     * @param args String args.
     * @throws IOException walkFileTree may throw.
     */
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, "xml").forEach(System.out::println);
    }

    /**
     * The method take root(start) position in file system tree and
     * find files that extension math.
     * @param root Path to start.
     * @param ext String extension.
     * @return List whit fined paths.
     */
    public static List<Path> search(Path root, String ext) {
        SearchFiles searcher = new SearchFiles(ext);
        try {
            Files.walkFileTree(root, searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searcher.getPaths();
    }
}