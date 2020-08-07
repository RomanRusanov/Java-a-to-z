package checkserveraccessibility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class check behavior Analizy.java.
 */
public class AnalizyTest {
    /**
     * The field contain instance of test class.
     */
    private Analizy analizy = new Analizy();
    /**
     * The field contain path and file name where store lines with periods.
     */
    private File target;
    /**
     * The field contain path and file name source log.
     */
    private File source;
    /**
     * The temp folder instance.
     */
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    /**
     * The method start before each test.
     */
    @Before
    public void setUp() {
        try {
            source = folder.newFile("server.log");
            target = folder.newFile("unavailable.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(source)
                ))) {
                    out.println("200 10:56:01");
                    out.println("500 10:57:01");
                    out.println("400 10:58:01");
                    out.println("200 10:59:01");
                    out.println("500 11:01:02");
                    out.println("200 11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }

        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
    }

    /**
     * Test check behavior what analyze store to result.
      */
    @Test
    public void whenLogAnalyzeThenOutFileContainPeriods() {
        List<String> readFromSource = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            readFromSource = in.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = readFromSource.iterator();
        Assert.assertEquals(iterator.next(), "10:57:01;10:59:01");
        Assert.assertEquals(iterator.next(), "11:01:02;11:02:02");
    }

    /**
     * Test check correct work regular expressions.
     */
    @Test
    public void whenStringCorrectWhenReturnTrue() {
        String correct = "200 10:56:01";
        Assert.assertTrue(analizy.isContain(correct));
        String notCorrect = "10:56:01";
        Assert.assertFalse(analizy.isContain(notCorrect));
    }
}