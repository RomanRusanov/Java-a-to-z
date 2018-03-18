package ru.rrusanov;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Class test for MaxSide.
**/
public class MaxSideTest {
	/**
	 * Check MaxSide Calculate.
	**/
	@Test
	public void thenMaxSideCalculate() {
		final int p1ax = 3;
		final int p1ay = 2;
		final int p2ax = 6;
		final int p2ay = 6;
		final int p3ax = 11;
		final int p3ay = 1;
		final int expect = 8;
		final double deviation = 0.1;
		Triangle t = new Triangle(new Point(p1ax, p1ay), new Point(p2ax, p2ay), new Point(p3ax, p3ay));
		MaxSide m = new MaxSide();
		assertEquals(expect, m.max(t), deviation);
		//assertThat(m.max(t), is(8.062257d));
	}
}