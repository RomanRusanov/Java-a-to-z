/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 11.08.2020
 *
 * Input.java The interface describes the input.
 *  String ask(String question) The method take message and return string.
 * StubInput.java Class need for check console input.
 *  public StubInput(String[] answers) Constructor take array strings.
 *  public String ask(String question) Method return string + 1 position from array.
 *   Each time that method called.
 * ConsoleInput.java A class implements an input from console.
 *  public String ask(String question) The method take string and out to console.
 *   Return what user type from console.
 * Chat.java The class implements chat behavior.
 *  public Chat(File fileLog, File fileWithAnswers)
 *   The default constructor.
 *  public static List<String> loadAnswers(File fileWithAnswers)
 *   The method load all answers from file.
 *  public String getRandomString() The method get random string from
 *   collection for answers.
 * Continued.java The class describe behavior when user type "продолжить".
 *  public void execute(Chat chat)
 *   The method implements behavior when user type some text.
 * Stop.java The class The class describe behavior when user type "стоп".
 *  public void execute(Chat chat)
 *   The method implements behavior when user type some text.
 * End.java The class describe behavior when user type "конец".
 *  public void execute(Chat chat)
 *   The method implements behavior when user type some text.
 * Interaction.java The class work with Chat, Input instance and describe
 *  interaction with user.
 *  public Interaction(Chat chat, Input input) The default constructor.
 *  public void addActions(String key, Action action)
 *   The method add actions to collection.
 *  public void init() Base logic for chat.
 *  public static void main(String[] args) The main method.
 */
package consolechat;