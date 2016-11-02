package ru.rrusanov;
import org.junit.Test;
import static org.junit.Assert.*;
public class MaxSideTest {

	@Test 
	public void thenMaxSideCalculate() {
		Triangle t = new Triangle(new Point(3,2),new Point(6,6),new Point(11,1));
		MaxSide m = new MaxSide();
		
		assertEquals(8,m.max(t),0.1);
		//assertThat(m.max(t), is(8.062257d));
	}
}