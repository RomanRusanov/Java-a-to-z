package ru.rrusanov.listToMap;

import java.util.HashMap;
import java.util.List;

/**
 * Class make the conversion List to Map collection.
 */
public class UserConvert {
    /**
     * Take list of user and convert into map with key Integer for user with that key.
     * @param list List to be converted in to map.
     * @return Hashmap key - id, value - User.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User item:list) {
            result.put(item.getId(), item);
        }
        return result;
    }
}
