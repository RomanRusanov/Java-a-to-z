package ru.rrusanov.LSP.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Milk extends Food {

    public Milk() {
        this.setName("Milk Prostokvashino");
        this.setExpaireDate(new GregorianCalendar(2019, Calendar.SEPTEMBER, 23));
        this.setCreateDate(new GregorianCalendar(2019, Calendar.JUNE, 6));
        this.setPrice(80.50);
        this.setDiscount((byte) 0);
    }
}
