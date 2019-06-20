package ru.rrusanov.LSP.model;

import java.util.Calendar;
import java.util.Objects;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 20.06.2019
 * <p>
 * The class .
 */
public class MilkReproduct extends FoodWrapper {
    /**
     * The field contain instance food to be wrapped.
     */
    private Food wrappedFood;
    /**
     * The field conatin value may this food reproduct in future.
     */
    private boolean canReproduct;
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
     * The constructor take instance food, and add new functional (can food reproduct in future).
     * @param food instance.
     */
    public MilkReproduct(Food food) {
        this.wrappedFood = food;
        this.canReproduct = true;
        this.name = food.getName();
        this.expireDate = food.getExpireDate();
        this.createDate = food.getCreateDate();
        this.price = food.getPrice();
        this.discount = food.getDiscount();
    }
    /**
     * The getter for field.
     * @return name.
     */
    public String getName() {
        return this.wrappedFood.getName();
    }

    /**
     * The setter for field.
     * @param name string.
     */
    public void setName(String name) {
        this.wrappedFood.setName(name);
    }

    /**
     * The getter for field.
     * @return calendar instance.
     */
    public Calendar getExpireDate() {
        return this.wrappedFood.getExpireDate();
    }

    /**
     * The setter for field.
     * @param expireDate Calendar instance.
     */
    public void setExpireDate(Calendar expireDate) {
        this.wrappedFood.setExpireDate(expireDate);
    }

    /**
     * The getter fro field.
     * @return Calendar instance.
     */
    public Calendar getCreateDate() {
        return this.wrappedFood.getCreateDate();
    }

    /**
     * The setter for field.
     * @param createDate Calendar instance.
     */
    public void setCreateDate(Calendar createDate) {
        this.wrappedFood.setCreateDate(createDate);
    }

    /**
     * The getter for field.
     * @return double value.
     */
    public double getPrice() {
        return this.wrappedFood.getPrice();
    }

    /**
     * The setter for field.
     * @param price double value.
     */
    public void setPrice(double price) {
        this.wrappedFood.setPrice(price);
    }

    /**
     * The getter for field.
     * @return byte value.
     */
    public byte getDiscount() {
        return this.wrappedFood.getDiscount();
    }

    /**
     * The setter for field.
     * @param discount byte value.
     */
    public void setDiscount(byte discount) {
        this.wrappedFood.setDiscount(discount);
    }

    /**
     * The getter for field.
     * @return boolean.
     */
    public boolean isCanReproduct() {
        return this.canReproduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        MilkReproduct that = (MilkReproduct) o;
        return canReproduct == that.canReproduct
                && Double.compare(that.price, price) == 0
                && discount == that.discount
                && wrappedFood.equals(that.wrappedFood)
                && name.equals(that.name)
                && expireDate.equals(that.expireDate)
                && createDate.equals(that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wrappedFood, canReproduct, name, expireDate, createDate, price, discount);
    }

    @Override
    public String toString() {
        return "MilkReproduct{"
                + "wrappedFood=" + wrappedFood
                + ", canReproduct=" + canReproduct
                + ", name='" + name + '\''
                + ", expireDate=" + expireDate
                + ", createDate=" + createDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}