package ru.rrusanov.map;
import org.junit.Before;
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
     * This field contain calendar instance.
     */
    private Calendar calendar = new GregorianCalendar();
    /**
     * This section execute before each test.
     */
    @Before
    public void setUp() {
        calendar.set(1985, Calendar.MAY, 15);
    }
    /**
     * When equals and hashcode not override.
     */
    @Test
    public void whenEqualsAndHashCodeNotOverride() {
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
        UserOverrideHashCode user1 = new UserOverrideHashCode("Ivan", 2, calendar);
        UserOverrideHashCode user2 = new UserOverrideHashCode("Ivan", 2, calendar);
        System.out.println(user1.equals(user2));
        Map<UserOverrideHashCode, String> map = new HashMap<>();
        map.put(user1, "user1");
        map.put(user2, "user2");
        System.out.println(map);
    }
    /**
     * When override only equals.
     */
    @Test
    public void whenEqualsOverrideAndHashCodeNot() {
        UserOverrideEquals user1 = new UserOverrideEquals("Ivan", 2, calendar);
        UserOverrideEquals user2 = new UserOverrideEquals("Ivan", 2, calendar);
        System.out.println(user1.equals(user2));
        Map<UserOverrideEquals, String> map = new HashMap<>();
        map.put(user1, "user1");
        map.put(user2, "user2");
        System.out.println(map);
    }
}