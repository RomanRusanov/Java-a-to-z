package ru.rrusanov.listToMap;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 18.01.2018
 *
 * Class test UserConvert class.
 */
public class UserConvertTest {
    /**
     * Then pass List<User> collection return HashMap<Id, User> collection.
     */
    @Test
    public void thenPassListWhenReturnHashMap() {
        List<User> list = new ArrayList<>(Arrays.asList(new User("Ivan", "Tombov"),
                                                        new User("Fedor", "Omsk"),
                                                        new User("Andrei", "Voronez"))
        );
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> hashMap = userConvert.process(list);
        int expect = list.get(0).getId();
        User result = hashMap.get(expect);
        Assert.assertThat(result.getId(), is(expect));
        Assert.assertThat(new User("Ivan", "Tombov").getCity(), is("Tombov"));
    }
}