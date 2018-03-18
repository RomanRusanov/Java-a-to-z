package ru.rrusanov.search;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 02.03.2018
 *
 * Class define Person.
 */
public class Person {
    /**
     * Field name.
     */
    private String name;
    /**
     * Field surname.
     */
    private String surname;
    /**
     * Field phone.
     */
    private String phone;
    /**
     * Field address.
     */
    private String address;
    /**
     * Default constructor.
     * @param name Person name.
     * @param surname Person surname.
     * @param phone Person phone.
     * @param address Person address.
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }
    /**
     * Getter for field name.
     * @return String.
     */
    public String getName() {
        return name;
    }
    /**
     * Getter for field surname.
     * @return String.
     */
    public String getSurname() {
        return surname;
    }
    /**
     * Getter for field phone.
     * @return String.
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Getter for field address.
     * @return String.
     */
    public String getAddress() {
        return address;
    }
}
