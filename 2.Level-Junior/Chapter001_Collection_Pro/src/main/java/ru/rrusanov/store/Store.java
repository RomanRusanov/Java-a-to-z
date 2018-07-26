package ru.rrusanov.store;
import java.util.List;
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
        addedUser(previous, current, result);
        changedUser(previous, current, result);
        removedUser(previous, current, result);
        return result;
    }
    /**
     * The method check what users be added.
     * @param previous previous list state.
     * @param current current list state.
     * @param info instance collected difference.
     */
    public void addedUser(List<User> previous, List<User> current, Info info) {
        for (User item: current) {
            if (!previous.contains(item)) {
                info.addedAdd(item);
            }
        }
    }
    /**
     * The method check what users be changed. Changed user must have same id but different name filed.
     * @param previous previous list state.
     * @param current current list state.
     * @param info instance collected difference.
     */
    public void changedUser(List<User> previous, List<User> current, Info info) {
        for (User itemCurrent:current) {
            for (User itemPrevious:previous) {
                if (itemCurrent.id == itemPrevious.id && (!itemCurrent.name.equals(itemPrevious.name))) {
                    info.changedAdd(itemCurrent);
                }
            }
        }
    }
    /**
     * The method check what users be removed.
     * @param previous previous list state.
     * @param current current list state.
     * @param info instance collected difference.
     */
    public void removedUser(List<User> previous, List<User> current, Info info) {
        for (User item: previous) {
            if (!current.contains(item)) {
                info.removedAdd(item);
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
    class User {
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
         * The method get name.
         * @return int id.
         */
        public String getName() {
            return name;
        }
        /**
         * The method set id.
         * @param id unique id.
         */
        public void setId(int id) {
            this.id = id;
        }
        /**
         * The method set id.
         * @param name User name.
         */
        public void setName(String name) {
            this.name = name;
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
