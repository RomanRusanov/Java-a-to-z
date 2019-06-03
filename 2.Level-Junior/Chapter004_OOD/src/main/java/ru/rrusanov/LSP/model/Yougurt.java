package ru.rrusanov.LSP.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Yougurt extends Food {
    public Yougurt() {
        this.setName("Yogurt Kolomenski");
        this.setExpaireDate(new GregorianCalendar(2019, Calendar.JUNE, 19));
        this.setCreateDate(new GregorianCalendar(2019, Calendar.JUNE, 6));
        this.setPrice(80.50);
        this.setDiscount((byte) 0);
    }
}
