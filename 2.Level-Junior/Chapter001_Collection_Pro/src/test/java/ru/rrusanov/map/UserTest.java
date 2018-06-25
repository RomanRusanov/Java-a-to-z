package ru.rrusanov.map;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 25.06.2018
 *
 * The class UserTest.java test behavior of User.java.
 */
public class UserTest {
    /**
     * When equals not override.
     */
    @Test
    public void whenEqualsAndHashCodeNotOverride() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(1985, Calendar.MAY, 15);
        User user1 = new User("Ivan", 1, calendar);
        User user2 = new User("Ivan", 1, calendar);
        System.out.println(user1.equals(user2));
        Map<User, String> map = new HashMap<>();
        map.put(user1, "user1");
        map.put(user2, "user2");
        System.out.println(map);
    }
}