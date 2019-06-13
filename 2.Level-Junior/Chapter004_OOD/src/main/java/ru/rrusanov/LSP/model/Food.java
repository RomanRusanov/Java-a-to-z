package ru.rrusanov.LSP.model;

import java.util.Calendar;
import java.util.Objects;

public class Food {

    private String name;

    private Calendar expireDate;

    private Calendar createDate;

    private double price;

    private byte discount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Calendar expireDate) {
        this.expireDate = expireDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte getDiscount() {
        return discount;
    }

    public void setDiscount(byte disscount) {
        this.discount = disscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0 &&
                discount == food.discount &&
                name.equals(food.name) &&
                expireDate.equals(food.expireDate) &&
                createDate.equals(food.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expireDate, createDate, price, discount);
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", expireDate=" + expireDate +
                ", createDate=" + createDate +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
