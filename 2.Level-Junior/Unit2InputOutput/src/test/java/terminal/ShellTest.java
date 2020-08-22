package terminal;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 20.08.2020
 * email roman9628@gmail.com
 * The class test Shell.java.
 */
public class ShellTest {
    /**
     * The test check if pass .. then go back to one level.
     */
    @Test
    public void whenCdBack() {
        Shell shell = new Shell();
        shell.cd("/user/..");
        assertEquals(
                "/", shell.pwd()
        );
    }
    /**
     * The test check if pass / then go back to root directory.
     */
    @Test
    public void whenCdRoot() {
        Shell shell = new Shell();
        shell.cd("/");
        assertEquals(
                "/", shell.pwd()
        );
    }
    /**
     * The test check if pass change folder then current path is changed folder.
     */
    @Test
    public void whenCdUserLocal() {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("local");
        assertEquals(
                 "/user/local", shell.pwd()
        );
    }
    /**
     * The test check if pass folder and after .. then go back to one level.
     */
    @Test
    public void whenCdUserBack() {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("..");
        assertEquals(
                "/", shell.pwd()
        );
    }
}