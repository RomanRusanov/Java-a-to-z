package findduplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 10.08.2020
 * email roman9628@gmail.com
 * The class search duplicates in root project folder.
 */
public class Search {
    /**
     * The main method.
     * @param args String args.
     * @throws IOException walkFileTree may throw.
     */
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        searchDuplicate(start).forEach(System.out::println);
    }

    /**
     * The method find duplicates file.
     * @param root Path to start find include embedding folders.
     * @return ArrayList with duplicate path.
     */
    public static List<Path> searchDuplicate(Path root) {
        SearchFiles searcher = new SearchFiles();
        try {
            Files.walkFileTree(root, searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searcher.getPaths();
    }
}