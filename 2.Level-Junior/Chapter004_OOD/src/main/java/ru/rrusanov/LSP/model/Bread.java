package ru.rrusanov.LSP.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 04.06.2019
 *
 * The class describe food Bead.
 */
public class Bread extends Food {
    /**
     * The default constructor.
     */
    public Bread() {
        this.setName("Bread Darnicki");
        this.setExpireDate(new GregorianCalendar(2019, Calendar.JUNE, 15));
        this.setCreateDate(new GregorianCalendar(2019, Calendar.JUNE, 6));
        this.setPrice(30.0);
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
    public Bread(String name, GregorianCalendar expire, GregorianCalendar create, Double price, Byte discount) {
        this.setName(name);
        this.setExpireDate(expire);
        this.setCreateDate(create);
        this.setPrice(price);
        this.setDiscount(discount);
    }
}