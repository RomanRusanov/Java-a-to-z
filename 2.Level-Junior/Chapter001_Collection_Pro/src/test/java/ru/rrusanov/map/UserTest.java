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
 * The class UserTest.java test behavior of UserNotOverride.java, UserOverrideHashCode.
 */
public class UserTest {
    /**
     * When equals and hashcode not override.
     */
    @Test
    public void whenEqualsAndHashCodeNotOverride() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(1985, Calendar.MAY, 15);
        UserNotOverride user1 = new UserNotOverride("Ivan", 1, calendar);
        UserNotOverride user2 = new UserNotOverride("Ivan", 1, calendar);
        System.out.println(user1.equals(user2));
        Map<UserNotOverride, String> map = new HashMap<>();
        map.put(user1, "user1");
        map.put(user2, "user2");
        System.out.println(map);
    }
    /**
     * When override only hashCode.
     */
    @Test
    public void whenHashCodeOverrideAndEqualsNot() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(1985, Calendar.MAY, 15);
        UserOverrideHashCode user1 = new UserOverrideHashCode("Ivan", 2, calendar);
        UserOverrideHashCode user2 = new UserOverrideHashCode("Ivan", 2, calendar);
        System.out.println(user1.equals(user2));
        Map<UserOverrideHashCode, String> map = new HashMap<>();
        map.put(user1, "user1");
        map.put(user2, "user2");
        System.out.println(map);
    }
}