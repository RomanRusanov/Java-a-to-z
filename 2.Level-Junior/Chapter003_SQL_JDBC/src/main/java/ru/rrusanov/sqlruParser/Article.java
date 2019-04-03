package ru.rrusanov.sqlruParser;

import java.util.Date;
import java.util.Objects;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 30.03.2019
 */
public class Article {

    private String url;

    private String subject;

    private String text;

    private String date;

    public Article(String url, String subject, String text, String date) {
        this.url = url;
        this.subject = subject;
        this.text = text;
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return url.equals(article.url) &&
                subject.equals(article.subject) &&
                text.equals(article.text) &&
                date.equals(article.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, subject, text, date);
    }

    @Override
    public String toString() {
        return "Article{" +
                "url='" + url + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
