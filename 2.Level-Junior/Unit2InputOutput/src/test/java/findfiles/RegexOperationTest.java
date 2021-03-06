package findfiles;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.IOException;
import java.nio.file.Path;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * The test chek behavior RegexOperation.java.
 */
public class RegexOperationTest {
    /**
     * The instance temporary folder. Delete after test complete.
     */
    @ClassRule
    public static TemporaryFolder folder = new TemporaryFolder();

    /**
     * The test check when user find by regex file name.
     * @throws IOException Throw when temp folder cant create file.
     */
    @Test
    public void fileMathCondition() throws IOException {
        ArgsName args = ArgsName.of(new String[] {
                "-d", "c:\\", "-n", ".*4[.].*", "-m", "-o", "log.txt"
        });
        RegexOperation operation = new RegexOperation();
        Path fileToFind = folder.newFile("findMe4.txt").toPath();
        assertTrue(operation.fileMathCondition(fileToFind, args));
        fileToFind = folder.newFile("findMe.txt").toPath();
        assertFalse(operation.fileMathCondition(fileToFind, args));
    }
}