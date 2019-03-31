package ru.rrusanov.sqlruParser;

import java.util.Date;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 30.03.2019
 */
public class Article {

    private final String url;

    private final String subject;

    private final String text;

    private final Date date;

    public Article(String url, String subject, String text, Date date) {
        this.url = url;
        this.subject = subject;
        this.text = text;
        this.date = date;
    }
}
