package ru.rrusanov;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Class test Triangle.
**/
public class TriangleTest {
	/**
	 * Test check existing of triangle.
	**/
	@Test
	public void thenTriangleNotExist() {
		Triangle t = new Triangle(new Point(0, 0), new Point(1, 1), new Point(1, 1));
		assertEquals(-1, t.area(), 0);
	}
	/**
	 * Test check calculate area of triangle.
	**/
	@Test
	public void thenTriangleCalculateArea() {
		final int p2ax = 4, p2ay = 4;
		final int p3ax = 6;
		final int expect = 4;
		final double deviation = 0.1;
		Triangle t = new Triangle(new Point(2, 2), new Point(p2ax, p2ay), new Point(p3ax, 2));
		assertEquals(expect, t.area(), deviation);
	}
}