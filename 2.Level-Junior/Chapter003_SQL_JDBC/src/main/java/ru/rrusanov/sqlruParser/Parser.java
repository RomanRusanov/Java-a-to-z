package ru.rrusanov.sqlruParser;

import com.sun.xml.internal.bind.v2.runtime.output.NamespaceContextImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
//        Element pageContainer = document.getElementById("page-container");
//        Element contentWrapperForum = pageContainer.getElementById("content-wrapper-forum");
//        Elements table = contentWrapperForum.getElementsByTag("table");
//        Elements forumTable = table.next(".forumTable");
        Elements t = document.getElementsByAttributeValue("class", "postslisttopic");
    }

}
