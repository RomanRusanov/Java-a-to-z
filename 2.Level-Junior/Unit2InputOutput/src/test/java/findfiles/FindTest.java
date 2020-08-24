package findfiles;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

/**
 * The test check Find.java behavior.
 */
public class FindTest {
    /**
     * The instance temporary folder. Delete after test complete.
     */
    @ClassRule
    public static TemporaryFolder folder = new TemporaryFolder();

    /**
     * The test check all process find.
     * @throws IOException Temp folder may throw exception.
     */
    @Test
    public void whenFileFindThenLogFileContainThem() throws IOException {
        Find find = new Find();
        File fileMustBeFunded = folder.newFile("findMe.txt");
        File fileLog = folder.newFile("log.txt");
        ArgsName args = ArgsName.of(new String[] {
                "-d", folder.getRoot().toString(),
                "-n", "findMe.txt", "-f",
                "-o", fileLog.getAbsolutePath()
        });
        find.process(args);
        try (BufferedReader in = new BufferedReader(
                new FileReader(fileLog))) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String expect = fileMustBeFunded.getAbsolutePath()
                    + System.getProperty("line.separator");
            assertEquals(expect, text.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}