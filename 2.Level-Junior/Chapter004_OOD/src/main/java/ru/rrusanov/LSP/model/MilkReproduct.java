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
     * The constructor take instance food, and add new functional (can food reproduct in future).
     * @param food instance.
     */
    public MilkReproduct(Food food) {
        this.wrappedFood = food;
        this.canReproduct = true;
        super.setName(food.getName());
        super.setExpireDate(food.getExpireDate());
        super.setCreateDate(food.getCreateDate());
        super.setPrice(food.getPrice());
        super.setDiscount(food.getDiscount());
    }
    /**
     * The getter for field.
     * @return name.
     */
    public String getName() {
        return super.getName();
    }

    /**
     * The setter for field.
     * @param name string.
     */
    public void setName(String name) {
        super.setName(name);
    }

    /**
     * The getter for field.
     * @return calendar instance.
     */
    public Calendar getExpireDate() {
        return super.getExpireDate();
    }

    /**
     * The setter for field.
     * @param expireDate Calendar instance.
     */
    public void setExpireDate(Calendar expireDate) {
        super.setExpireDate(expireDate);
    }

    /**
     * The getter fro field.
     * @return Calendar instance.
     */
    public Calendar getCreateDate() {
        return super.getCreateDate();
    }

    /**
     * The setter for field.
     * @param createDate Calendar instance.
     */
    public void setCreateDate(Calendar createDate) {
        super.setCreateDate(createDate);
    }

    /**
     * The getter for field.
     * @return double value.
     */
    public double getPrice() {
        return super.getPrice();
    }

    /**
     * The setter for field.
     * @param price double value.
     */
    public void setPrice(double price) {
        super.setPrice(price);
    }

    /**
     * The getter for field.
     * @return byte value.
     */
    public byte getDiscount() {
        return super.getDiscount();
    }

    /**
     * The setter for field.
     * @param discount byte value.
     */
    public void setDiscount(byte discount) {
        super.setDiscount(discount);
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
                && wrappedFood.equals(that.wrappedFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wrappedFood, canReproduct);
    }

    @Override
    public String toString() {
        return "MilkReproduct{"
                + "wrappedFood=" + wrappedFood
                + ", canReproduct=" + canReproduct
                + ", name='" + super.getName() + '\''
                + ", expireDate=" + super.getExpireDate()
                + ", createDate=" + super.getCreateDate()
                + ", price=" + super.getPrice()
                + ", discount=" + super.getDiscount()
                + '}';
    }
}