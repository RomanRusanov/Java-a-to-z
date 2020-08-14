package consolechat;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class check Chat.java behavior.
 */
public class ChatTest {
    /**
     * The instance temp folder for test.
     */
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    /**
     * The field contain collection with all answers to user.
     */
    private List<String> allAnswers;
    /**
     * The field contain file where save all dialog.
     */
    private File fileLog;
    /**
     * The field contain file with all answers to user.
     */
    private File fileWithAnswers;

    /**
     * The method run before each test.
     * @throws Exception may throw I/O Exception.
     */
    @Before
    public void setUp() throws Exception {
        this.fileLog = folder.newFile("chatlog.txt");
        this.fileWithAnswers = new File("./data/answers.txt");
        this.allAnswers = Chat.loadAnswers(fileWithAnswers);
    }

    /**
     * The test chek behavior when user type "конец".
     */
    @Test
    public void whenUserTypeEndOrStopThenConsoleIsEmpty() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        StubInput stubInput = new StubInput(new String[] {("стоп"), ("конец")});
        Chat chat = new Chat(this.fileLog, this.fileWithAnswers);
        Interaction interaction = new Interaction(chat, stubInput);
        interaction.init();
        String result = byteArrayOutputStream.toString();
        String expect =  "";
        assertEquals(expect, result);
    }

    /**
     * The test chek that chat answer one of possible answer.
     */
    @Test
    public void whenTypeNotEndAndStopThenConsoleOutOneAnswer() {
        String endLine = System.getProperty("line.separator");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        StubInput stubInput = new StubInput(new String[] {("привет"), ("конец")});
        Chat chat = new Chat(this.fileLog, this.fileWithAnswers);
        Interaction interaction = new Interaction(chat, stubInput);
        interaction.init();
        String result = byteArrayOutputStream.toString().replaceAll(endLine, "");
        assertTrue(this.allAnswers.contains(result));
    }
}