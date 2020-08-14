package consolechat;
import java.io.File;
import java.util.HashMap;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.08.2020
 * email roman9628@gmail.com
 * The class work with Chat, Input instance and describe interaction
 * with user.
 */
public class Interaction {
    /**
     * The field contain instance of chat.
     */
    private Chat chat;
    /**
     * The field contain instance input.
     */
    private Input input;
    /**
     * The filed contain collection with all key word,
     * the chat interactions with that words.
     */
    private HashMap<String, Action> actions = new HashMap<>();

    /**
     * The default constructor.
     * @param chat Chat Intance.
     * @param input Input instance.
     */
    public Interaction(Chat chat, Input input) {
        this.chat = chat;
        this.input = input;
    }

    /**
     * The method add actions to collection.
     * @param key String.
     * @param action The instance for class that implements interface Action.
     */
    public void addActions(String key, Action action) {
        this.actions.put(key, action);
    }

    /**
     * Base logic for chat.
     */
    public void init() {
        this.addActions("продолжить", new Continued());
        this.addActions("стоп", new Stop());
        this.addActions("конец", new End());
        while (chat.getWork()) {
            String userSay = this.input.ask("Введите фразу:");
            this.chat.getLog().add(userSay);
            if (userSay.equals("продолжить") || userSay.equals("конец")) {
                this.chat.setStop(false);
            }
            if (this.chat.getStop()) {
                continue;
            }
            this.actions.getOrDefault(userSay, this.actions.get("продолжить")).execute(this.chat);
        }
    }

    /**
     * The main method.
     * @param args String args.
     */
    public static void main(String[] args) {
        File fileLog = new File("./2.Level-Junior/Unit2InputOutput/data/chatlog.txt");
        File fileWithAnswers = new File("./2.Level-Junior/Unit2InputOutput/data/answers.txt");
        ConsoleInput consoleInput = new ConsoleInput();
        Chat chat = new Chat(fileLog, fileWithAnswers);
        Interaction interaction = new Interaction(chat, consoleInput);
        interaction.addActions("продолжить", new Continued());
        interaction.addActions("стоп", new Stop());
        interaction.addActions("конец", new End());
        interaction.init();
    }
}