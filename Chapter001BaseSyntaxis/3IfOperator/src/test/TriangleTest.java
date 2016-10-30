package ru.rrusanov;
import org.junit.Test;
import static org.junit.Assert.*;
public class TriangleTest {

	@Test
	public void thenTriangleNotExist() {

		Triangle t = new Triangle(new Point(0,0),new Point(1,1),new Point(1,1));

		assertEquals(-1,t.area(),0);
	}

	@Test
	public void thenTriangleCalculateArea() {

		Triangle t = new Triangle(new Point(2,2),new Point(4,4),new Point(6,2));

		assertEquals(4,t.area(),0.1);
	}
}