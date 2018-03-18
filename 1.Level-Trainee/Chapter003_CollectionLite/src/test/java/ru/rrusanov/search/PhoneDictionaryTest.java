package ru.rrusanov.search;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 02.03.2018
 *
 * Class test PhoneDictionary class.
 */
public class PhoneDictionaryTest {
    /**
     * Test for add method.
     */
    @Test
    public void thenAddedPersonWhenCollectionNotEmpty() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        Assert.assertFalse(phones.getPersons().isEmpty());
    }
    /**
     * Test for find method.
     */
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
}