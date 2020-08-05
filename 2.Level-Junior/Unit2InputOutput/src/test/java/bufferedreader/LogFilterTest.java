package bufferedreader;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
/**
 * The test check behavior LogFilter.java.
 */
public class LogFilterTest {
    /**
     * The filed with regex.
     */
    private String regex = "^.*\\s(404)\\s\\d+$";
    /**
     * The field contain correct string for regex.
     */
    private String string1 = "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:18 "
            + "+0300] \"GET /items/ajax.html HTTP/1.1\" 404 1113";
    /**
     * The field contain wrong string for regex.
     */
    private String string2 = "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:34 "
            + "+0300] \"GET /TrackStudioNew/ HTTP/1.1\" 404 -";

    /**
     * The test check string1 match to regex and must return true.
     * String2 don`t match to regex must return false.
     */
    @Test
    public void whenStringMatchThenListContainSting() {
        List<String> result = new ArrayList<>();
        result = LogFilter.filter("log.txt");
        Assert.assertTrue(result.stream()
                                .anyMatch(Predicate
                                        .isEqual(string1)));
        Assert.assertFalse(result.stream()
                                 .anyMatch(Predicate
                                         .isEqual(string2)));
    }

    /**
     * The test check correct work regular expression.
     * Must return only strings that contains last second number 404.
     */
    @Test
    public void whenSecondLast404ThenReturnTrue() {
        Assert.assertFalse(LogFilter.isContain("404"));
        Assert.assertFalse(LogFilter.isContain("404 1110"));
        Assert.assertFalse(LogFilter.isContain("4041110"));
        Assert.assertFalse(LogFilter.isContain("some text 404"));
        Assert.assertTrue(LogFilter.isContain("some text 404 1110"));
    }
}