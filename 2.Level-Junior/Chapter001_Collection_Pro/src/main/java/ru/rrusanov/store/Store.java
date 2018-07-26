package ru.rrusanov.store;
import java.util.List;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 26.07.2018
 *
 *
 */
public class Store {

    Info diff(List<User> previous, List<User> current) {
        Info result = new Info();
        addedUser(previous, current, result);
        changedUser(previous, current, result);
        removedUser(previous,current, result);
        return result;
    }

    public void addedUser(List<User> previous, List<User> current, Info info) {
        for (User item: current) {
            if (!previous.contains(item)) {
                info.addedAdd(item);
            }
        }
    }

    public void changedUser(List<User> previous, List<User> current, Info info) {
        for (User itemCurrent:current) {
            for (User itemPrevious:previous) {
                if (itemCurrent.id == itemPrevious.id && (!itemCurrent.name.equals(itemPrevious.name))) {
                    info.changedAdd(itemCurrent);
                }
            }
        }
    }

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
     *
     */
    class User {

        private int id;

        private String name;

        public User(String name) {
            this.id = (int) System.currentTimeMillis() / name.hashCode() + name.length();
            this.name = name;
        }



        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

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

        @Override
        public int hashCode() {
            return 31 * (id + (name.hashCode()));
        }
    }
}
