package ru.rrusanov.ISP;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 18.07.2019
 *
 * Test MenuInteraction.java.
 */
public class MenuInteractionTest {
    /**
     * The field contain instance menu.
     */
    private BaseItem item1 = new BaseItem("item1", "1");
    /**
     * The field contain instance menu.
     */
    private BaseItem item11 = new BaseItem("item11", "2");
    /**
     * The field contain instance menu.
     */
    private BaseItem item111 = new BaseItem("item111", "3");
    /**
     * The field contain instance menu.
     */
    private BaseItem item112 = new BaseItem("item112", "4");
    /**
     * The field contain instance menu.
     */
    private BaseItem item12 = new BaseItem("item12", "5");
    /**
     * The field contain instance menu.
     */
    private MenuInteraction menuInteraction = new MenuInteraction();

    /**
     * The method executes before each test.
     */
    @Before
    public void setUp() {
        item1.addSubMenuItem(item11);
        item11.addSubMenuItem(item111);
        item11.addSubMenuItem(item112);
        item1.addSubMenuItem(item12);
    }

    /**
     * Test Main menu.
     */
    @Test
    public void thenPrintAllItemsWhenMenuPrintToConsole() {
        final String ENDLINE = System.getProperty("line.separator");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        menuInteraction.printAllItems(item1, "");

        final String result = byteArrayOutputStream.toString();
        final String expect = "item1 (1)" + ENDLINE
                + "--item11 (2)" + ENDLINE
                + "----item111 (3)" + ENDLINE
                + "----item112 (4)" + ENDLINE
                + "--item12 (5)" + ENDLINE;
        assertThat(result, is(expect));
    }

    /**
     * Test method findHotKey.
     */
    @Test
    public void whenInMenuExistActionThenReturnItemInstanceOtherwiseReturnNull() {
        BaseItem result = menuInteraction.findHotKey(item1, "1");
        Assert.assertThat(result, is(item1));
        result = menuInteraction.findHotKey(item1, "2");
        Assert.assertThat(result, is(item11));
        result = menuInteraction.findHotKey(item1, "3");
        Assert.assertThat(result, is(item111));
        result = menuInteraction.findHotKey(item1, "4");
        Assert.assertThat(result, is(item112));
        result = menuInteraction.findHotKey(item1, "5");
        Assert.assertThat(result, is(item12));
        result = menuInteraction.findHotKey(item1, "999");
        Assert.assertNull(result);
    }
}