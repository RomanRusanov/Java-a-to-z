package ru.rrusanov.sqlruParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.03.2019
 *
 *
 */
public class Parser {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("http://www.sql.ru/forum/job").get();
        System.out.println(document);
    }

}
