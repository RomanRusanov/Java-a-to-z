package arhivateproject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/**
 * The class test ArgZip.java.
 */
public class ArgZipTest {
    /**
     * The instance of test class.
     */
    private ArgZip argZip;
    /**
     * The method run before each test.
     */
    @Before
    public void setup() {
        this.argZip = new ArgZip(new String[]{"-d=c:\\project\\job4j\\",
                "-e=class", "-o=project.zip"});
    }

    /**
     * The test check passed params.
     */
    @Test
    public void whenParamsThreeAndTheyCorrectThenReturnTrue() {
        assertTrue(argZip.valid());
    }

    /**
     * The test check if params write not correct then trow exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenParamsNotMatchThenThrowException() {
        ArgZip notValid = new ArgZip(new String[]{"-d="});
        notValid.valid();
    }
    /**
     * The test check if passed not three params then trow exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenParamsNotTreeThenThrowException() {
        ArgZip notValid = new ArgZip(new String[]{"-d=c:\\project\\job4j\\",
                "-e=class}"});
        notValid.valid();
    }

    /**
     * The test check correct parse for param directory.
     */
    @Test
    public void directory() {
        assertEquals("c:\\project\\job4j\\", argZip.directory());
    }
    /**
     * The test check correct parse for param exclude.
     */
    @Test
    public void exclude() {
        assertEquals("class", argZip.exclude());
    }
    /**
     * The test check correct parse for param output.
     */
    @Test
    public void output() {
        assertEquals("project.zip", argZip.output());
    }
}