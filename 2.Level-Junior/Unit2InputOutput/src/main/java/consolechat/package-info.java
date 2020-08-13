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
 *  public Chat(Input input, File fileLog, File fileWithAnswers)
 *   The default constructor.
 *  public void interaction() Base logic for interaction with user.
 *  public static void main(String[] args) Main method.
 *  public static List<String> loadAnswers(File fileWithAnswers)
 *   The method load all answers from file.
 *  public String getRandomString() The method get random string from
 *   collection for answers.
 *  public void continued() The method change behavior of chat if user
 *   type "продолжить".
 *  public void end() The method stop cycle of chat, and save all log to file.
 */
package consolechat;