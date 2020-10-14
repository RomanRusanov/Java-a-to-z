package completablefuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.10.2020
 * email roman9628@gmail.com
 * The class take from parse collection and store on disk.
 */
public class ToFiles {

    /**
     * The instance with logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ToFiles.class.getName());
    /**
     * The field contain instance with path. Where store all files.
     */
    private final Path path;
    /**
     * The field contain instance with config params pairs.
     */
    private final Config config;

    /**
     * The default constructor.
     * @param config Config instance.
     */
    public ToFiles(Config config) {
        this.path = Path.of(config.value("path"));
        this.config = config;
    }

    /**
     * The method start async process. Take from Parse collection countries,
     * and make file from each country (file name - country_name.txt). Each
     * file contain all participants in this country.
     * @return Void.
     */
    public CompletableFuture<Boolean> writeToDisk() {
        return CompletableFuture.supplyAsync(() -> {
            LOG.info("Start write on disk.");
            for (Map.Entry<String, String[]> entry : Parser.getEntrySet()) {
                String country = entry.getKey();
                String[] records = entry.getValue();
                String fullPathAndFileName = this.path.resolve(country + ".txt").toString();
                try (PrintWriter out = new PrintWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(fullPathAndFileName)
                        ))) {
                    for (String s : records) {
                        out.println(s);
                    }
                } catch (Exception e) {
                    LOG.error("Error! insert in country table.", e);
                }
            }
            LOG.info("Complete write on disk.");
            return true;
        });
    }
}