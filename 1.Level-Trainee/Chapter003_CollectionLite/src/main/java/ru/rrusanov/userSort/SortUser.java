package ru.rrusanov.userSort;
import ru.rrusanov.userSort.model.User;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.01.2018
 *
 * SortUser class sort collection by ascending order.
 */
public class SortUser {
    /**
     * Sort users by age ascending order.
     * @param list List with users to sorting;
     * @return Set sorted users.
     */
    public Set<User> sort(List<User> list) {
        TreeSet<User> result = new TreeSet<>();
        for (User item:list) {
            result.add(item);
        }
        return result;
    }
    /**
     * Sort collection by length name.
     * @param list Collection to sort.
     * @return Sorted collection.
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                Integer o1Length = o1.getName().length();
                Integer o2Length = o2.getName().length();
                return o1Length.compareTo(o2Length);
            }
        });
        return list;
    }
    /**
     * Sort collection by name if name equal then sort by age.
     * @param list Collection to sort.
     * @return Sorted collection.
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                final int result = o1.getName().compareTo(o2.getName());
                return result != 0 ? result : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
    }
}
