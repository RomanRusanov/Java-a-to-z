package ru.rrusanov;
import org.junit.Test;
import static org.junit.Assert.*;
public class SquareTest {

	@Test
	public void thenX0WhenReturnC () {
		Square square = new Square();
		assertEquals(4,square.calculate(0),0.0);
	}

	@Test
	public void thenX2WhenReturn26 () {
		Square square = new Square();
		assertEquals(18,square.calculate(2),0.0);
	}
}