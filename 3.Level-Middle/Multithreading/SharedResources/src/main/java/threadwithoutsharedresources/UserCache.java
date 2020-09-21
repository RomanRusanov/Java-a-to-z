package threadwithoutsharedresources;
import net.jcip.annotations.ThreadSafe;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.09.2020
 * email roman9628@gmail.com
 * Кэш сохраняет новый экземпляр но с тем же именем поля.
 */
@ThreadSafe
public class UserCache {
    /**
     * The field contain thread safe collection.
     */
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();
    /**
     * The field contain id thread safe instance.
     */
    private final AtomicInteger id = new AtomicInteger();

    /**
     * The method put in collection new instance.
     * @param user User instance for copy.
     */
    public void add(User user) {
        users.put(id.incrementAndGet(), User.of(user.getName()));
    }

    /**
     * The method get from collection new instance of users,
     * if that user with this id exist in collection.
     * @param id int value to find.
     * @return new instance User.
     */
    public User findById(int id) {
        return User.of(users.get(id).getName());
    }

    /**
     * The method return all users in cache.
     * @return List with users.
     */
    public List<User> findAll() {
        return this.users.values().stream()
                .map((s) -> User.of(s.getName()))
                .collect(Collectors.toList());
    }
}