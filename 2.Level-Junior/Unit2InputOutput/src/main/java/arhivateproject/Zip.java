package arhivateproject;
import scanfilesystem.SearchFiles;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 11.08.2020
 * email roman9628@gmail.com
 *
 * The class zip files.
 *
 * 1. При запуске указывается папка, которую мы хотим архивировать, например:
 * c:\project\job4j\
 * 2. В качестве ключа передается  расширения файлов, которые не нужно
 * включать в архив.
 * 3. Архив должен сохранять структуру проекта. То есть содержать подпапки.
 * 4. Запуск проекта.
 *
 * java -jar pack.jar -d=c:\project\job4j\ -e=xml -o=project.zip
 *
 * java -jar pack.jar - Это собранный jar.
 *
 * -d - directory - которую мы хотим архивировать
 * -e - exclude - исключить файлы *.xml
 * -o - output - во что мы архивируем..
 */
public class Zip {
    /**
     * The filed contain instance with arguments.
     */
    private ArgZip argZip;

    /**
     * The default constructor.
     * @param argZip Instance with arguments.
     */
    public Zip(ArgZip argZip) {
        this.argZip = argZip;
        this.init();
    }

    /**
     * The method start zip process.
     */
    public void init() {
        Path directory = Path.of(argZip.directory());
        Path output = Path.of(argZip.output());
        List<Path> allPathToArchive = search(directory, this.argZip.exclude());
        List<File> allFileToArchive = allPathToArchive.stream().collect(ArrayList::new,
                (list, element) -> list.add(element.toFile()),
                ArrayList::addAll);
        this.packFiles(allFileToArchive, output.toFile());
    }

    /**
     * The method take root(start) position in file system tree and
     * find all files besides that extension(ext).
     * @param root Path to start.
     * @param ext String extension exclude.
     * @return List of path that files fined.
     */
    public static List<Path> search(Path root, String ext) {
        SearchFiles searcher = new SearchFiles(p -> (!p.toFile().getName().endsWith(ext)));
        try {
            Files.walkFileTree(root, searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searcher.getPaths();
    }

    /**
     * The method zip files passed in list. Store to target zip file.
     * @param sources List files to archive.
     * @param target Target zip file.
     */
    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Main method.
     * @param args arguments.
     */
    public static void main(String[] args) {
        Zip zip = new Zip(new ArgZip(args));
    }
}