package namedargs;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The class test ArgsName.java.
 */
public class ArgsNameTest {
    /**
     * The test check that args parse correct.
     */
    @Test
    public void whenGetFirst() {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        assertEquals(jvm.get("Xmx"), ("512"));
    }
    /**
     * The test check that args parse correct. If args was added second params.
     */
    @Test
    public void whenGetFirstReorder() {
        ArgsName jvm = ArgsName.of(new String[] {"-encoding=UTF-8", "-Xmx=512"});
        assertEquals(jvm.get("Xmx"), "512");
    }

    /**
     * The test check if args don't passed then throw exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenGetNotExist() {
        ArgsName jvm = ArgsName.of(new String[] {});
        jvm.get("Xmx");
    }
}