package ru.rrusanov.collection.store;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 26.07.2018
 *
 * The class compare two lists and check what users be added, removed or changed.
 */
public class Store {
    /**
     * The method check three different state two instance of list what contain Users(described in inner class).
     * @param previous previous list state.
     * @param current current list state.
     * @return return instance of info.
     */
    Info diff(List<User> previous, List<User> current) {
        Info result = new Info();
        HashMap<Integer, User> prevMap = this.listToMap(previous);
        HashMap<Integer, User> currMap = this.listToMap(current);
        this.addedUser(prevMap, currMap, result);
        this.changedUser(prevMap, currMap, result);
        this.removedUser(prevMap, currMap, result);
        return result;
    }
    /**
     * The method convert collection from list to hasMap.
     * @param list list to convert.
     * @return new hashMap instance
     */
    HashMap<Integer, User> listToMap(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User item : list) {
            result.put(item.getId(), item);
        }
        return result;
    }
    /**
     * The method check what users be added.
     * @param prevMap previous Map converted from list state.
     * @param currMap current Map converted from  list state.
     * @param info instance collected difference.
     */
    public void addedUser(Map<Integer, User> prevMap, Map<Integer, User> currMap, Info info) {
        for (Integer item: currMap.keySet()) {
            if (!prevMap.containsKey(item)) {
                info.addedAdd(currMap.get(item));
            }
        }
    }
    /**
     * The method check what users be changed. Changed user must have same id but different name filed.
     * @param prevMap previous Map converted from list state.
     * @param currMap current Map converted from  list state.
     * @param info instance collected difference.
     */
    public void changedUser(Map<Integer, User> prevMap, Map<Integer, User> currMap, Info info) {
        for (Integer itemCurr: currMap.keySet()) {
            if (prevMap.containsKey(itemCurr) && (!prevMap.get(itemCurr).name.equals(currMap.get(itemCurr).name))) {
               info.changedAdd(currMap.get(itemCurr));
            }
        }
    }
    /**
     * The method check what users be removed.
     * @param prevMap previous Map converted from list state.
     * @param currMap current Map converted from  list state.
     * @param info instance collected difference.
     */
    public void removedUser(Map<Integer, User> prevMap, Map<Integer, User> currMap, Info info) {
        for (Integer item: prevMap.keySet()) {
            if (!currMap.containsKey(item)) {
                info.removedAdd(prevMap.get(item));
            }
        }
    }
    /**
     * @author Roman Rusanov
     * @version 0.1
     * @since 26.07.2018
     *
     * The inner class describes instance User.
     */
    static class User {
        /**
         * The field contain unique id.
         */
        private int id;
        /**
         * The field contain name of user.
         */
        private String name;
        /**
         * The default constructor.
         * @param name User name.
         */
        User(String name) {
            this.id = (int) System.currentTimeMillis() / name.hashCode() + name.length();
            this.name = name;
        }
        /**
         * The method get id.
         * @return int id.
         */
        public int getId() {
            return id;
        }
        /**
         * The method set id.
         * @param id unique id.
         */
        public void setId(int id) {
            this.id = id;
        }
        /**
         * The method override method from Object class.
         * @param obj to compare.
         * @return if equals by field id and name return true, otherwise false.
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }
            User userObj = (User) obj;
            return this.id == userObj.id && this.name.equals(userObj.name);
        }
        /**
         * The method override method from Object class.
         * @return int hash value of user instance.
         */
        @Override
        public int hashCode() {
            return 31 * (id + (name.hashCode()));
        }
    }
}
