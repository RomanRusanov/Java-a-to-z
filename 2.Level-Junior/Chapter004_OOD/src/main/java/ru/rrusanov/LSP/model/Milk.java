package ru.rrusanov.LSP.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Milk extends Food {

    public Milk() {
        this.setName("Milk Prostokvashino");
        this.setExpireDate(new GregorianCalendar(2019, Calendar.SEPTEMBER, 23));
        this.setCreateDate(new GregorianCalendar(2019, Calendar.JUNE, 6));
        this.setPrice(80.50);
        this.setDiscount((byte) 0);
    }

    public Milk(String name, GregorianCalendar expire, GregorianCalendar create, Double price, Byte discount) {
        this.setName(name);
        this.setExpireDate(expire);
        this.setCreateDate(create);
        this.setPrice(price);
        this.setDiscount(discount);
    }
}
