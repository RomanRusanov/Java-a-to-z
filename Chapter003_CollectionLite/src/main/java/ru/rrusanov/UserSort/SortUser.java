package ru.rrusanov.UserSort;

import ru.rrusanov.UserSort.model.User;

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
}
