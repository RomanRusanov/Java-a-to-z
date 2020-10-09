package completablefuture;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 04.08.2020
 * email roman9628@gmail.com
 * The class read from file string lines. If line corresponds regex,
 * when add that line to list.
 */
public class ToFiles {

    private final Path path;

    public ToFiles(Path path) {
        this.path = path;
    }

    public CompletableFuture<Void> work(String[] dataForOneFile) {
        return CompletableFuture.runAsync(() -> {
            String fullPathAndFileName = this.path.resolve(
                    Parser.getCountryName(dataForOneFile[0]) + ".txt").toString();
            try (PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(fullPathAndFileName)
                    ))) {
                for (String s : dataForOneFile) {
                    out.println(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
//            System.out.println("Write one country");
        });
    }
}