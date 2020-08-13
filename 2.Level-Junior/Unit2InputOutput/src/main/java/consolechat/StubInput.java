package consolechat;
/**
 * Class need for check console input.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 08.02.17
 */
public class StubInput  implements Input {
    /**
     * answers -  an array of strings which was obtained during initialization
     * of the instance StubInput.
     */
    private String[] answers;
    /**
     * The field contain index - for array field StubInput.
     */
    private int index;

    /**
     * Constructor take array strings.
     * @param answers Array string.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Method return string + 1 position from array.
     * Each time that method called.
     * @param question String
     * @return Stringin
     */
    public String ask(String question) {
        return this.answers[index++];
    }
}
