package findfiles;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.08.2020
 * email roman9628@gmail.com
 * The class find files by condition.
 *
 * 1. Создать программу для поиска файла.
 * 2. Программа должна искать данные в заданном каталоге и подкаталогах.
 * 3. Имя файла может задаваться, целиком, по маске, по регулярному
 *  выражение(не обязательно).
 * 4. Программа должна собираться в jar и запускаться через
 *  java -jar find.jar -d c:/ -n *.txt -m -o log.txt
 * Ключи
 * -d - директория в которая начинать поиск.
 * -n - имя файл, маска, либо регулярное выражение.
 * -m - искать по макс, либо -f - полное совпадение имени.
 * -r регулярное выражение.
 * -o - результат записать в файл.
 * 5. Программа должна записывать результат в файл.
 * 6. В программе должна быть валидация ключей и подсказка.
 */
public class Find {
    /**
     * The field contain all possible operation to find.
     * String key. OperationOnFile instance that implements logic to serach.
     */
    private Map<String, OperationOnFiles> allOperations = new HashMap<>();

    /**
     * The main method.
     * @param args String args.
     */
    public static void main(String[] args) {
        ArgsName argsName =  ArgsName.of(args);
        Find find = new Find();
        find.process(argsName);
    }

    /**
     * The method start all process.
     * @param argsName Instance with args.
     */
    public void process(ArgsName argsName) {
        this.fillOperations();
        Path workDirectory = Paths.get(argsName.get("d"));
        String operationKey = argsName.findKeyEmptyValue();
        String outputFile = argsName.get("o");
        OperationOnFiles currentOperation = this.allOperations.get(operationKey);
        List<Path> allpaths = this.search(
                workDirectory,
                currentOperation,
                argsName
        );
        this.save(allpaths, outputFile);
    }

    /**
     * The method add operation to collection.
     * @param operation Instance that implements operation behavior.
     */
    public void addOperations(OperationOnFiles operation) {
        this.allOperations.put(operation.getKey(), operation);
    }

    /**
     * The method fill collection with all operations.
     */
    public void fillOperations() {
        this.addOperations(new FileNameOperation());
        this.addOperations(new MaskOperation());
        this.addOperations(new RegexOperation());
    }

    /**
     * The method find in all included sub folders. Use FileVisitor instance.
     * @param root folder to start position in filesystem.
     * @param operation Operation that implement search method.
     * @param argsName Instance with args.
     * @return List with all matched files path.
     */
    public List<Path> search(
            Path root,
            OperationOnFiles operation,
            ArgsName argsName
    ) {
        SearchFiles searchFiles = new SearchFiles(operation, argsName);
        try {
            Files.walkFileTree(root, searchFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchFiles.getPaths();
    }

    /**
     * The method save in file all found path with filenames.
     * @param log List to store.
     * @param file out filename.
     */
    public void save(List<Path> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (Path s : log) {
                out.printf("%s%n", s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}