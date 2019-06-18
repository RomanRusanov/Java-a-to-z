package ru.rrusanov.LSP.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 04.06.2019
 *
 * The class describe food Milk.
 */
public class Milk extends Food {
    /**
     * The default constructor.
     */
    public Milk() {
        this.setName("Milk Prostokvashino");
        this.setExpireDate(new GregorianCalendar(2019, Calendar.SEPTEMBER, 23));
        this.setCreateDate(new GregorianCalendar(2019, Calendar.JUNE, 6));
        this.setPrice(80.50);
        this.setDiscount((byte) 0);
    }

    /**
     * The constructor that set all fields instance.
     * @param name Title.
     * @param expire ExpireDate.
     * @param create CreateDate.
     * @param price Price.
     * @param discount Discount.
     */
    public Milk(String name, GregorianCalendar expire, GregorianCalendar create, Double price, Byte discount) {
        this.setName(name);
        this.setExpireDate(expire);
        this.setCreateDate(create);
        this.setPrice(price);
        this.setDiscount(discount);
    }
}