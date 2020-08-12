package arhivateproject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.ZipInputStream;
import static org.junit.Assert.assertEquals;
/**
 * The class test Zip.java.
 */
public class ZipTest {
    /**
     * The string to write in file.
     */
    private String testString;
    /**
     * The root directory to work.
     */
    private String directory;
    /**
     * The file with test string.
     */
    private File source;
    /**
     * The archive file(zip).
     */
    private File output;
    /**
     * The instance of test class.
     */
    private Zip zip;
    /**
     * The instance temp folder for test.
     */
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    /**
     * The method run before each test.
     * @throws Exception I/O Exception.
     */
    @Before
    public void setUp() throws Exception {
        this.testString = "Test string 123";
        this.directory = folder.getRoot().toString();
        this.source = folder.newFile("source.txt");
        this.output = folder.newFile("archive.zip");
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(source)
                ))) {
                out.print(testString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.zip = new Zip(new ArgZip(new String[] {("-d=" + directory),
                ("-e=zip"), ("-o=" + output.toString())}));
    }

    /**
     * The test chek if write some data to file,
     * then data in file same what we wrote.
     */
    @Test
    public void whenWriteToFileThenGetSameThatWrite() {
        try (BufferedReader in = new BufferedReader(
                new FileReader(source))) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            assertEquals(this.testString, text.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The test check equals contain file after unzip.
     */
    @Test
    public void whenArchiveFileContainThenExtractSameContain() {
        try (ZipInputStream zip = new ZipInputStream(
                new BufferedInputStream(
                        new FileInputStream(output)))) {
            while (zip.available() != 0) {
                zip.getNextEntry();
                int i = 1;
                File extractedFile = folder.newFile("ext.txt" + i++);
                try (FileOutputStream out = new FileOutputStream(extractedFile)) {
                    out.write(zip.readAllBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try (BufferedReader in = new BufferedReader(
                        new FileReader(extractedFile))) {
                    StringBuilder text = new StringBuilder();
                    int read;
                    while ((read = in.read()) != -1) {
                        text.append((char) read);
                    }
                    assertEquals(this.testString, text.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}