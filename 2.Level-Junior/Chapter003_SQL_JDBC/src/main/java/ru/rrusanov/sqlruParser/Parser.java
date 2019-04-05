package ru.rrusanov.sqlruParser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.03.2019
 */
public class Parser {

    private List<Article> currentPageListAllArticle;
    private String[] topicsNotMatch = {"javascript", "java script"};
    private String[] topicsMatch = {"java"};
    private final Date dToday = new Date();
    private final Date dYesterday = new Date(System.currentTimeMillis() - 86400000);
    private final SimpleDateFormat format = new SimpleDateFormat("dd MMM yy");
    private final String strToday = format.format(dToday);
    private final String strYesterday = this.format.format(dYesterday);
    /**
     * Logger.
     */
    private static final Logger LOG = LogManager.getLogger(Parser.class.getName());
    /**
     * Version for Logger.
     */
    private int version = 1;

    public Document getDocFromUrl(String url) {
        Document currentPage = null;
        try {
            currentPage = Jsoup.connect(url).get();
        } catch (IOException e) {
            LOG.error(String.format(
                    "Error connect to site(%s). Version:%d%n Exception:%s", url, version, e.toString())
            );
        }
        return currentPage;
    }

    public boolean findMatchCharSequence(String strProcess, String[] pattern) {
        boolean result = false;
        String currWord = "";
        for (int i = 0; i < strProcess.length() - 1; i++){
            for (int j = 0; j < pattern.length; j++) {
                if (currWord.equalsIgnoreCase(pattern[j])) {
                    result = true;
                    break;
                }
            }
            if (result) {
                if (pattern.length > 1) {
                    result = findMatchCharSequence(strProcess.substring(i+1), pattern);
                }
                break;
            }
            if (strProcess.charAt(i) == " ".charAt(0)) {
                currWord = "";
                i++;
            }
            currWord = currWord + strProcess.charAt(i);
        }
        return result;
    }

    public Elements getAllArticleOnPage(String site) {
        Document currentPage = this.getDocFromUrl(site);
        Element pageContainer = currentPage.getElementById("page-container");
        Element contentWrapperForum = pageContainer.getElementById("content-wrapper-forum");
        Elements table = contentWrapperForum.getElementsByTag("table");
        return table.next(".forumTable");
    }

    public String getTextArticle(String urlArticle) {
        Document currentPage = this.getDocFromUrl(urlArticle);
        Elements msgBody = currentPage.getElementsByAttributeValue("class", "msgBody");
        return msgBody.first().nextElementSibling().text();
    }

    public List<Article> parseCurrentPage(Elements forumTable) {
        ArrayList<Article> result = new ArrayList<>();
        Elements curr = forumTable.first().child(0).children();
        Iterator<Element> iterator = curr.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            Elements c = iterator.next().children();
            String topic = c.first().nextElementSibling().child(0).text();
//            if (topicsNotMatch.) {
//
//            }
            String url = c.first().nextElementSibling().child(0).attributes().get("href");
            String date = c.last().text();
            String text = this.getTextArticle(url);
            result.add(new Article(url, topic, text, this.convertDate(date)));
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
