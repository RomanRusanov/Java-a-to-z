package ru.rrusanov;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Class test Point.
**/
public class PointTest {
	/**
	 * Test Point if all coordinates zero.
	**/
	@Test
	public void thenCoordinatsPointZeroWhenResultZero() {
		Point p = new Point(0, 0);
		assertEquals(0.0, p.x, 0);
		assertEquals(0.0, p.y, 0);
	}
	/**
	 * Test distance Point to Point.
	**/
	@Test
	public void thenDistancePointToPoint() {
		Point a = new Point(1, 1);
		Point b = new Point(2, 2);
		public final int expect = 1.4;
		public final int deviation = 0.1;
		assertEquals(expect, a.distanceTo(b), deviation);
	}
}