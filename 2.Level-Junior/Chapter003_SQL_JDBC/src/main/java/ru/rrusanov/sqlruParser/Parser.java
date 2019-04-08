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

    private final List<Article> allMatchedArticle = new ArrayList<>();
    private String[] topicsNotMatch = {"javascript", "java script", "Java Script", "JavaScript"};
    private String[] topicsMatch = {"java", "Java", "JAVA"};
    private final Date dToday = new Date();
    private final Date dYesterday = new Date(System.currentTimeMillis() - 86400000);
    private final SimpleDateFormat format = new SimpleDateFormat("dd MMM yy");
    private final String strToday = format.format(dToday);
    private final String strYesterday = this.format.format(dYesterday);
    private Integer maxPageNumber;
    private boolean noMoreMatchedArticle;
    /**
     * Logger.
     */
    private static final Logger LOG = LogManager.getLogger(Parser.class.getName());
    /**
     * Version for Logger.
     */
    private int version = 1;

    /**
     * Default constructor.
     */
    public Parser() {
        this.maxPageNumber = getMaxPageNumber("http://www.sql.ru/forum/job/");
        this.noMoreMatchedArticle = false;
    }

    public void processFirstStart() {
        List<Article> listArticleOnCurrentPage;
        for (int i = 0; i <= this.maxPageNumber && !noMoreMatchedArticle; i++) { //iterate by pages
            Elements allArticleOnPage = this.getAllArticleOnPage("http://www.sql.ru/forum/job/" + (i + 1));
            listArticleOnCurrentPage = this.parseCurrentPage(allArticleOnPage);
            this.allMatchedArticle.addAll(listArticleOnCurrentPage);
        }
    }

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

    public int getMaxPageNumber(String site) {
        Document currentPage = this.getDocFromUrl(site);
        Elements sort_options = currentPage.getElementsByAttributeValue("style", "text-align:left");
        return Integer.parseInt(sort_options.first().child(10).text());
    }


    public boolean findMatchCharSequence(String strProcess, String[] pattern) {
        // check length strProcess and pattern String length
        for (int k = 0; k < pattern.length; k++) {
            if (pattern[k].length() > strProcess.length()) {
                return false;
            }
        }
        // find match char sequence
        boolean result = false;
        boolean flag; //by default chars not equals.
        for (int i = 0; i < pattern.length; i++) { // array pattern
            int counter = 0; // how many fined equals char
            int strCursor = 0;
            for (int j = 0; j < strProcess.length(); j++) { // array strProcess
                flag = false;
                if (pattern[i].charAt(strCursor) == strProcess.charAt(j)) {
                    flag = true; // find equal char in strProcess and pattern.
                    counter++;
                    strCursor++;
                    if (counter == pattern[i].length()) {
                        result = true;
                        break;
                    }
                }
                if (!flag) { // if sequence not math, reset counter and cursor at start position pattern word.
                    strCursor = 0;
                    counter = 0;
                }
            }
            if (result) { // if find when break and return true.
                break;
            }
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
        List<Article> result = new ArrayList<>();
        int counter = 0; // how many article sequent not matched by date.
        String currYear = this.strToday.substring(this.strToday.length() - 2); // Current year
        String stringToCompare = String.format(" %s, ", currYear);
        Elements curr = forumTable.first().child(0).children();
        Iterator<Element> iterator = curr.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            Elements c = iterator.next().children();
            String date = this.convertDate(c.last().text());
            if (!date.contains(stringToCompare) && counter <= 4) {
                counter++;
                continue;
            }
            if (counter > 4) {
                this.noMoreMatchedArticle = true;
                break;
            }
            counter = 0;
            String topic = c.first().nextElementSibling().child(0).text();
            if (this.findMatchCharSequence(topic, this.topicsNotMatch) ||
                !this.findMatchCharSequence(topic, this.topicsMatch)) {
                continue;
            }
            String url = c.first().nextElementSibling().child(0).attributes().get("href");
            String text = this.getTextArticle(url);
            result.add(new Article(url, topic, text, date));
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
