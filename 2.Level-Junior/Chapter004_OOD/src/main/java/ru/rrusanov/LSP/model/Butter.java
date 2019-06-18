package ru.rrusanov.LSP.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 04.06.2019
 *
 * The class describe food Butter.
 */
public class Butter extends Food {
    /**
     * The default constructor.
     */
    public Butter() {
        this.setName("Butter Valio");
        this.setExpireDate(new GregorianCalendar(2019, Calendar.JUNE, 15));
        this.setCreateDate(new GregorianCalendar(2019, Calendar.MAY, 23));
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
    public Butter(String name, GregorianCalendar expire, GregorianCalendar create, Double price, Byte discount) {
        this.setName(name);
        this.setExpireDate(expire);
        this.setCreateDate(create);
        this.setPrice(price);
        this.setDiscount(discount);
    }
}
