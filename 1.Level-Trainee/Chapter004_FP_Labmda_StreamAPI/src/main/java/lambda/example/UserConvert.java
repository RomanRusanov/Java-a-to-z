package lambda.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
/**
 * The Example.
 */
public class UserConvert {
    /**
     * User inner class.
     */
    public static class User {
        /**
         * Field contain name.
         */
        private final String name;
        /**
         * Default constructor.
         * @param name string.
         */
        public User(String name) {
            this.name = name;
        }
        /**
         * The method override toString method.
         * @return string.
         */
        @Override
        public String toString() {
            return "User{name='" + name + '\'' + '}';
        }
    }
    /**
     * The method convert array names to array users.
     * @param names List string names.
     * @param op Functional interface.
     * @return List Users.
     */
    public List<User> convert(List<String> names, Function<String, User> op) {
        List<User> users = new ArrayList<>();
        names.forEach(
                n -> users.add(op.apply(n))
        );
        return users;
    }
    /**
     * Main method.
     * @param args arguments.
     */
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Petr", "Nick", "Ban");
        UserConvert users = new UserConvert();
        List<User> data = users.convert(names, User::new);
        data.forEach(System.out::println);

    }
}