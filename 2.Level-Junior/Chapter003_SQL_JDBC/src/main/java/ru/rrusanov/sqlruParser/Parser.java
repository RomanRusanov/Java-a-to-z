package ru.rrusanov.sqlruParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.03.2019
 */
public class Parser {
    public static void main(String[] args) throws IOException {
        Document currentPage = Jsoup.connect("http://www.sql.ru/forum/job").get();
//        Element pageContainer = document.getElementById("page-container");
//        Element contentWrapperForum = pageContainer.getElementById("content-wrapper-forum");
//        Elements table = contentWrapperForum.getElementsByTag("table");
//        Elements forumTable = table.next(".forumTable");
        Elements postslisttopics = currentPage.getElementsByAttributeValue("class", "postslisttopic");
    }

}
