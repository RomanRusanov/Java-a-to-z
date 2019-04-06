package ru.rrusanov.sqlruParser;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

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
        parser.init();
        System.out.println("");
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
}