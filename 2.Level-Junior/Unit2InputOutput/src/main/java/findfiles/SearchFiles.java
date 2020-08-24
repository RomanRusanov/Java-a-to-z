package findfiles;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.nio.file.FileVisitResult.CONTINUE;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.08.2020
 * email roman9628@gmail.com
 * The class implements FileVisitor behavior to walk over files tree
 * and find duplicate file. If file name and size equals then add to
 * collections math.
 */
public class SearchFiles implements FileVisitor<Path> {
    /**
     * The field contain collection that stored duplicates file paths.
     */
    private List<Path> match = new ArrayList<>();
    /**
     * The field contain collection with all files names and size.
     * Key - String filename.
     * Value - Long file size.
     */
    private Map<String, Long> allFiles = new HashMap<>();
    /**
     * The instance OperationOnFiles. How to serach.
     */
    private OperationOnFiles operation;
    /**
     * The instance with args.
     */
    private ArgsName argsName;

    /**
     * Default constructor.
     * @param operation The instance OperationOnFiles.
     * @param argsName The instance with args.
     */
    public SearchFiles(OperationOnFiles operation, ArgsName argsName) {
        this.operation = operation;
        this.argsName = argsName;
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
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (this.operation.fileMathCondition(file, this.argsName)) {
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