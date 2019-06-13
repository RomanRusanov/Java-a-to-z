package ru.rrusanov.LSP.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Bread extends Food{
    public Bread() {
        this.setName("Bread Darnicki");
        this.setExpireDate(new GregorianCalendar(2019, Calendar.JUNE, 15));
        this.setCreateDate(new GregorianCalendar(2019, Calendar.JUNE, 6));
        this.setPrice(30.0);
        this.setDiscount((byte) 0);
    }
}
