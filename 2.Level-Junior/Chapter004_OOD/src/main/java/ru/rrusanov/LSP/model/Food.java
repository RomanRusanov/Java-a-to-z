package ru.rrusanov.LSP.model;

import java.util.Calendar;
import java.util.Objects;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 04.06.2019
 *
 * The class describe model food instance.
 */
public class Food {
    /**
     * The field contain name food.
     */
    private String name;
    /**
     * The field contain expire date.
     */
    private Calendar expireDate;
    /**
     * The field contain create date.
     */
    private Calendar createDate;
    /**
     * The field price food.
     */
    private double price;
    /**
     * The field contain discount percent.
     */
    private byte discount;

    /**
     * The getter for field.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * The setter for field.
     * @param name string.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The getter for field.
     * @return calendar instance.
     */
    public Calendar getExpireDate() {
        return expireDate;
    }

    /**
     * The setter for field.
     * @param expireDate Calendar instance.
     */
    public void setExpireDate(Calendar expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * The getter fro field.
     * @return Calendar instance.
     */
    public Calendar getCreateDate() {
        return createDate;
    }

    /**
     * The setter for field.
     * @param createDate Calendar instance.
     */
    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    /**
     * The getter for field.
     * @return double value.
     */
    public double getPrice() {
        return price;
    }

    /**
     * The setter for field.
     * @param price double value.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * The getter for field.
     * @return byte value.
     */
    public byte getDiscount() {
        return discount;
    }

    /**
     * The setter for field.
     * @param discount byte value.
     */
    public void setDiscount(byte discount) {
        this.discount = discount;
    }

    /**
     * The method compare food instance between.
     * @param o another instance to compare.
     * @return if equals return true, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0
                && discount == food.discount
                && name.equals(food.name)
                && expireDate.equals(food.expireDate)
                && createDate.equals(food.createDate);
    }

    /**
     * The method return hash value for instance food.
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, expireDate, createDate, price, discount);
    }

    /**
     * The method override toString method from object.
     * @return fields values.
     */
    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", expireDate=" + expireDate
                + ", createDate=" + createDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}