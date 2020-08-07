package checkserveraccessibility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
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
    private String fileResult = "data/unavailable.csv";
    /**
     * The field contain path and file name source log.
     */
    private String fileSource = "data/server.log";

    /**
     * The method start before each test.
     */
    @Before
    public void setUp() {
        analizy.unavailable(fileSource, fileResult);
    }

    /**
     * Test check behavior what analyze store to result.
      */
    @Test
    public void whenLogAnalyzeThenOutFileContainPeriods() {
        List<String> readFromSource = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(fileResult))) {
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