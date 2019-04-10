package ru.rrusanov.sqlruParser;

import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;

public class ParserTest {


    @Test
    public void getAllArticleOnPage() {

    }

    @Test
    public void getTextArticle() {
        Parser parser = new Parser();
        String expect = "Здесь будут писаться все описания действий модераторов по исправлению и удалению топиков, "
                + "а так же замечания участникам форума, согласно правилам форума \"Работа\".";
        String result = parser.getTextArticle("https://www.sql.ru/forum/269098/"
                + "soobshheniya-ot-moderatorov-zdes-vy-mozhete-uznat-prichiny-udaleniya-topikov");
        Assert.assertThat(result, is(expect));
    }

    @Test
    public void parseCurrentPage() {
        Parser parser = new Parser();
        Elements allArticle = parser.getAllArticleOnPage("https://www.sql.ru/forum/job/2");
        List<Article> listArticle = parser.parseCurrentPage(allArticle);
        System.out.println(listArticle);
    }

    @Test
    public void convertDate() {
    }

    @Test
    public void getDocFromUrl() {
    }

    @Test(expected = IllegalStateException.class)
    public void findMatchCharSequence() {
        String[] topicsNotMatch = {"java script", "javascript"};
        Parser parser = new Parser();
        Assert.assertThat(parser.findMatchCharSequence("The javascript lang", topicsNotMatch),
                is(true)
        );
        Assert.assertThat(parser.findMatchCharSequence("The java script lang", topicsNotMatch),
                is(true)
        );
        Assert.assertThat(parser.findMatchCharSequence("The java lang", topicsNotMatch),
                is(false)
        );
        // That method call generate IllegalStateException.
        parser.findMatchCharSequence("shortStr", topicsNotMatch);
    }

    @Test
    public void getMaxPageNumber() {
        Parser parser = new Parser();
        System.out.println(parser.getMaxPageNumber("https://www.sql.ru/forum/job/"));
    }

    @Test
    public void processFirstStart() {
        Parser parser = new Parser();
        parser.processFirstStart();
        System.out.println("");
    }

    @Test
    public void parsePage5() {
        Parser parser = new Parser();
        Elements allArticle = parser.getAllArticleOnPage("https://www.sql.ru/forum/job/5");
        List<Article> listArticle = parser.parseCurrentPage(allArticle);
        System.out.println(listArticle);
    }

    @Test
    public void compareStringDate() {
        Parser parser = new Parser();
        String date1 = "01 янв 99, 12:00";
        String date2 = "01 янв 99, 12:01";
        boolean result = parser.compareStringDate(date1, date2);
        Assert.assertThat(result, is(false));
    }
}