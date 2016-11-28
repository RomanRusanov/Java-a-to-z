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
		public final int p1ax = 3;
		public final int p1ay = 2;
		public final int p2ax, p2ay = 6;
		public final int p3ax = 11;
		public final int p3ay = 1;
		public final int expect = 8;
		public final int deviation = 0.1;
		Triangle t = new Triangle(new Point(p1ax, p2ay), new Point(p2ax, p2ay), new Point(p3ax, p3ay));
		MaxSide m = new MaxSide();
		assertEquals(expect, m.max(t), deviation);
		//assertThat(m.max(t), is(8.062257d));
	}
}