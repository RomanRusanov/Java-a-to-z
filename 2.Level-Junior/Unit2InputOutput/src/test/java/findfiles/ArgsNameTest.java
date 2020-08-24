package findfiles;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * The class test ArgsName.java.
 */
public class ArgsNameTest {
    /**
     * The test check that args parse correct.
     */
    @Test
    public void whenPassKeyThenGetValue() {
        ArgsName jvm = ArgsName.of(new String[] {"-d", "c:\\", "-n", "*.txt", "-m", "-o", "log.txt"});
        assertEquals(jvm.get("d"), ("c:\\"));
        assertEquals(jvm.get("n"), ("*.txt"));
        assertEquals(jvm.get("m"), ("Empty Value"));
        assertEquals(jvm.get("o"), ("log.txt"));
        assertEquals(jvm.get("z"), (null));
    }

    /**
     * The test check if args don't passed then throw exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenParamsNotFull() {
        ArgsName jvm = ArgsName.of(new String[] {});
        jvm.get("d");
    }
}