package ru.rrusanov.userSort.model;

import java.util.Objects;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.01.2018
 *
 * User class describes user.
 */
public class User implements Comparable<User> {
    /**
     * @{value} User name.
     */
    private String name;
    /**
     * @{value} User age.
     */
    private Integer age;
    /**
     * Default constructor with fields initial.
     * @param name User name.
     * @param age User age.
     */
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p>
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     * <p>
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     * <p>
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     * <p>
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     * <p>
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }

    /**
     * Getter for age value.
     * @return Integer age;
     */
    public Integer getAge() {
        return this.age;
    }
    /**
     * Getter for name value.
     * @return String name;
     */
    public String getName() {
        return this.name;
    }

    /**
     * Compare users.
     * @param o Other user.
     * @return if equals return true.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(age, user.age);
    }

    /**
     * Generate hashcode of user.
     * @return int hashcode.
     */
    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}
