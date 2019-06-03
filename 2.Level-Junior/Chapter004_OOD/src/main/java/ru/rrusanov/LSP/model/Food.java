package ru.rrusanov.LSP.model;

import java.util.Calendar;
import java.util.Objects;

public class Food {

    private String name;

    private Calendar expaireDate;

    private Calendar createDate;

    private double price;

    private byte discount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getExpaireDate() {
        return expaireDate;
    }

    public void setExpaireDate(Calendar expaireDate) {
        this.expaireDate = expaireDate;
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
                expaireDate.equals(food.expaireDate) &&
                createDate.equals(food.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expaireDate, createDate, price, discount);
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", expaireDate=" + expaireDate +
                ", createDate=" + createDate +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }

    public byte calculateDiscount() {
        long timeInMillSec = this.expaireDate.getTimeInMillis() - this.createDate.getTimeInMillis();
        long days = (timeInMillSec / (60*60*24*1000));
    }
}
