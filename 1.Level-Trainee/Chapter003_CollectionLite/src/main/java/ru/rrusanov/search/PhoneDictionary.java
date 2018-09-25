package ru.rrusanov.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 02.03.2018
 *
 * Class define PhoneDictionary.
 */
public class PhoneDictionary {
    /**
     * Getter fot dictionary collection.
     * @return collection.
     */
    public List<Person> getPersons() {
        return persons;
    }
    /**
     * Dictionary collection.
     */
    private List<Person> persons = new ArrayList<>();
    /**
     * Add person to dictionary.
     * @param person to add.
     */
    public void add(Person person) {
        this.persons.add(person);
    }
    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        this.persons.stream()
                .filter(current -> current.getName().contains(key)
                    | current.getSurname().contains(key)
                    | current.getPhone().contains(key)
                    | current.getAddress().contains(key))
                .forEach(result::add);
        return result;
    }
}
