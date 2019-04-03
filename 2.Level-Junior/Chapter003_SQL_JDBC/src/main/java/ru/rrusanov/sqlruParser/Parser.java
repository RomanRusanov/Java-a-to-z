package ru.rrusanov.sqlruParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.03.2019
 */
public class Parser {

    private List<Article> currentPageListArticle;

    private final Date dToday = new Date();
    private final Date dYesterday = new Date(System.currentTimeMillis() - 86400000);
    private final SimpleDateFormat format = new SimpleDateFormat("dd MMM yy");
    private final String strToday = format.format(dToday);
    private final String strYesterday = this.format.format(dYesterday);

    public static void main(String[] args) throws IOException {
        Document currentPage = Jsoup.connect("http://www.sql.ru/forum/job").get();
        Element pageContainer = currentPage.getElementById("page-container");
        Element contentWrapperForum = pageContainer.getElementById("content-wrapper-forum");
        Elements table = contentWrapperForum.getElementsByTag("table");
        Elements forumTable = table.next(".forumTable");
        Parser parser = new Parser();
        parser.parseCurrentPage(forumTable);


    }

    public List<Article> parseCurrentPage(Elements forumTable) {
        ArrayList<Article> result = new ArrayList<>();
        Elements curr = forumTable.first().child(0).children();
        Iterator<Element> iterator = curr.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            Elements c = iterator.next().children();
            String subj = c.first().nextElementSibling().child(0).text();
            String url = c.first().nextElementSibling().child(0).attributes().get("href");
            String date = c.last().text();
            result.add(new Article(url, subj, "text", this.convertDate(date)));
        }
        return result;
    }

    public String convertDate(String date) {
        String result = date;
        if (result.contains("сегодня")) {
            result = date.replace("сегодня", this.strToday);
        }
        if (result.contains("вчера")) {
            result = date.replace("вчера", this.strYesterday);
        }
        return result;
    }

}
