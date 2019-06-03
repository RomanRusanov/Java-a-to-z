package ru.rrusanov.LSP.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Butter extends Food {
    public Butter() {
        this.setName("Milk Prostokvashino");
        this.setExpaireDate(new GregorianCalendar(2019, Calendar.JUNE, 15));
        this.setCreateDate(new GregorianCalendar(2019, Calendar.MAY, 23));
        this.setPrice(80.50);
        this.setDiscount((byte) 0);
    }
}
