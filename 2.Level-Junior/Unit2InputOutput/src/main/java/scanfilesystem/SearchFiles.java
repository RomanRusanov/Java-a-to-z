package scanfilesystem;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import static java.nio.file.FileVisitResult.CONTINUE;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 10.08.2020
 * email roman9628@gmail.com
 * The class implements FileVisitor behavior to walk over files tree
 * and chek file extension in each file. If extension math ext field
 * when add path file to collection match.
 */
public class SearchFiles implements FileVisitor<Path> {
    /**
     * The field contain extension that match.
     */
    private String ext;
    /**
     * The field contain collection that stored matched paths.
     */
    private List<Path> match = new ArrayList<>();

    /**
     * The default constructor.
     * @param ext String extension to find.
     */
    public SearchFiles(String ext) {
        this.ext = ext;
    }

    /**
     * Overrated method from FileVisitor class.
     * Invoked for a directory before entries in the directory are visited.
     * @param dir A reference to the directory.
     * @param attrs Attrs.
     * @return FileVisitResult.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    /**
     * Overrated method from FileVisitor class.
     * Invoked for a file in a directory.
     * Check if file have match extensions then add it path to collection.
     * @param file Current file.
     * @param attrs Attrs.
     * @return FileVisitResult.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toFile().getName().endsWith(ext)) {
            this.match.add(file);
        }
        return CONTINUE;
    }

    /**
     * Overrated method from FileVisitor class.
     * Invoked for a file that could not be visited.
     * @param file Current file.
     * @param exc The I/O exception that prevented the file from being visited
     * @return FileVisitResult.
     * @throws IOException if an I/O error occurs
     */
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    /**
     * Overrated method from FileVisitor class.
     * Invoked for a directory after entries in the directory,
     * and all of their descendants, have been visited.
     * @param dir A reference to the directory.
     * @param exc null if the iteration of the directory completes without an error
     *            otherwise the I/O exception that caused the iteration of the directory
     *            to complete prematurely.
     * @return FileVisitResult.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }

    /**
     * The method getter for collection field.
     * @return ArrayList with path.
     */
    public List<Path> getPaths() {
        return match;
    }
}