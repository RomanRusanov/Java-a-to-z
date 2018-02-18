package ru.rrusanov.UserSort;

import org.junit.Assert;
import org.junit.Test;
import ru.rrusanov.UserSort.model.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
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
        ArrayList<User> sorted =
            new ArrayList<>(Arrays.asList(
                new User("Andrei", 33),
                new User("Nikolay", 12),
                new User("Vladimir", 20)
            )
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

    /**
     * Then pass unsorted List<User> when return sorted by name length ascending order.
     */
    @Test
    public void thenPassUnsortedWhenSortByNameLegth() {
        SortUser sortUser = new SortUser();
        ArrayList<User> unSorted =
            new ArrayList<>(Arrays.asList(
                new User("Иван", 30),
                new User("Ярослав", 20),
                new User("Максим", 25)
            )
        );
        List<User> sorted = sortUser.sortNameLength(unSorted);
        User expect = new User("Иван", 30);
        User result = sorted.get(0);
        Assert.assertThat(result, is(expect));
    }

    /**
     * Then pass unsorted List<User> when return sorted by name if name equals when sort by age.
     */
    @Test
    public void thenPassUnsortedWhenSortByNameAndAge() {
        SortUser sortUser = new SortUser();
        List<User> unSorted = Arrays.asList(
            new User("Сергей", 25),
            new User("Иван", 30),
            new User("Сергей", 20),
            new User("Иван", 25)
        );
        List<User> result = sortUser.sortByAllFields(unSorted);
        List<User> expect = Arrays.asList(
            new User("Иван", 25),
            new User("Иван", 30),
            new User("Сергей", 20),
            new User("Сергей", 25)
        );
        Assert.assertThat(result, is(expect));
    }
}