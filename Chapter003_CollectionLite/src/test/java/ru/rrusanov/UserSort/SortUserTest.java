package ru.rrusanov.UserSort;

import org.junit.Assert;
import org.junit.Test;
import ru.rrusanov.UserSort.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;


import static org.hamcrest.core.Is.is;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.01.2018
 *
 * SortUserTest class test SortUser.
 */
public class SortUserTest {
    /**
     * Then pass List with some users items, when return set where first user in collection younger.
     */
    @Test
    public void thenPassSomeUsersWhenReturnSetFirstUserYounger() {
        SortUser sortUser = new SortUser();
        ArrayList<User> sorted = new ArrayList<>(Arrays.asList(
                new User("Andrei", 33),
                new User("Nikolay", 12),
                new User("Vladimir", 20))
        );
        Set<User> sortedSet = sortUser.sort(sorted);
        Iterator<User> iterator = sortedSet.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result = iterator.next().getAge();
            break;
        }
        Assert.assertThat(result, is(12));
    }
}