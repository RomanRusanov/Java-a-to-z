package ru.rrusanov;
import org.junit.Test;
import static org.junit.Assert.assertThat;
/** Class test Square.java.
* @author Roman Rusanov
* @since 13.11.2016
* @version 0.1
*/
public class SquareTest {
	/**Then x=0 When calculate return 4.
	*/
	@Test
	public void thenX0WhenReturn4() {
		Square square = new Square();
		final float expect = 4.0;
		final float result = square.calculator(0);
		assertThat(result, is(expect));
	}
	/**Then x=2 calculate return 18.
	*/
	@Test
	public void thenX2WhenReturn18() {
		Square square = new Square();
		final float expect = 18.0;
		final float result = square.calculator(2);
		assertThat(result, is(expect));
	}
}