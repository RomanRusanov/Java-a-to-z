package ru.rrusanov.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 02.03.2018
 *
 * Class test Person.
 */
public class PersonTest {
    /**
     * Test for method getName.
     */
    @Test
    public void thenNewPersonCreatedWhenNameNotNull() {
        Person person = new Person("Ivan", "Ivanov", "+12345678", "Ivanovskay str");
        Assert.assertNotNull(person.getName());
    }
    /**
     * Test for method getSurname.
     */
    @Test
    public void thenNewPersonCreatedWhenSurnameNotNull() {
        Person person = new Person("Ivan", "Ivanov", "+12345678", "Ivanovskay str");
        Assert.assertNotNull(person.getSurname());
    }
    /**
     * Test for method getPhone.
     */
    @Test
    public void thenNewPersonCreatedWhenPhoneNotNull() {
        Person person = new Person("Ivan", "Ivanov", "+12345678", "Ivanovskay str");
        Assert.assertNotNull(person.getPhone());
    }
    /**
     * Test for method getAddress.
     */
    @Test
    public void thenNewPersonCreatedWhenAddressNotNull() {
        Person person = new Person("Ivan", "Ivanov", "+12345678", "Ivanovskay str");
        Assert.assertNotNull(person.getAddress());
    }
}