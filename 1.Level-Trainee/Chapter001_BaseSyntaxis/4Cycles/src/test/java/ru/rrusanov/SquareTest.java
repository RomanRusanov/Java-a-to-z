package ru.rrusanov;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/** Class test Square.java.
* @author Roman Rusanov
* @since 13.11.2016
* @version 0.1
*/
public class SquareTest {
    /**
     * The instance the tested class.
     */
    private Square square = new Square();
    /**
     * The constant new line.
     */
    private static final String NEW_LINE = System.getProperty("line.separator");
	/**
     * Then x=0 When calculate return 4.
	*/
	@Test
	public void thenX0WhenReturn4() {
		final float expect = 4f;
		final float result = square.calculate(0);
		assertThat(result, is(expect));
	}
	/**
     * Then x=2 calculate return 18.
	*/
	@Test
	public void thenX2WhenReturn18() {
		final float expect = 18f;
		final float result = square.calculate(2);
		assertThat(result, is(expect));
	}
    /**
     * Test show method.
     */
	@Test
	public void whenShowStringThenString() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        square.show(1, 3, 1);
        System.setOut(old);
        assertThat(baos.toString(), is("y = 9,000000  x value = 1" + NEW_LINE + "y = 18,000000  x value = 2" + NEW_LINE));
    }
}