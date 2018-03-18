package ru.rrusanov;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/** Class test Paint.java.
 * @author Roman Rusanov
 * @since 22.11.2016
 * @version 0.1
 */
public class PaintTest {
	/**
	 * Then height of pyramid 1 return single string.
	 */
	@Test
	public void thenHeghtPiramid1ReturnSingleString() {
		Paint paint = new Paint();
		final String expect = " ^\n";
		final String result = paint.piramid(1);
		assertThat(result, is(expect));
	}
}