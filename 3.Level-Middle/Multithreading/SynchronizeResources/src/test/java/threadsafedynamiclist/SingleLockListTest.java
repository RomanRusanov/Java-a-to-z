package threadsafedynamiclist;

import org.junit.jupiter.api.Test;
import userstorage.User;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The class test behavior SingleLockList.java.
 */
public class SingleLockListTest {
    /**
     * Test.
     * @throws InterruptedException Join may throw.
     */
    @Test
    public void add() throws InterruptedException {
        SingleLockList<Integer> list = new SingleLockList<>();
        Thread first = new Thread(() -> list.add(1));
        Thread second = new Thread(() -> list.add(2));
        first.start();
        second.start();
        first.join();
        second.join();
        Set<Integer> rsl = new TreeSet<>();
        list.iterator().forEachRemaining(rsl::add);
        assertEquals(rsl, Set.of(1, 2));
    }

    /**
     *
     */
    @Test
    public void iteratorMustReturnImmutableList() {
        SingleLockList<User> list = new SingleLockList<>();
        User user1 = new User(1, 10);
        User user2 = new User(2, 10);
        list.add(user1);
        list.add(user2);
        Iterator<User> iterator = list.iterator();
        iterator.next().setAmount(20);
        iterator.next().setAmount(20);

        System.out.println(user1.getAmount());
        System.out.println(user2.getAmount());
    }
}