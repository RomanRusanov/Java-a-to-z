package rusanov;
import org.junit.Test;
import static org.junit.Assert.*;
public class PointTest {
	@Test
	public void coordinatsPointZero() {
		Point p = new Point(0,0);
		assertEquals(0.0,p.x,0);
		assertEquals(0.0,p.y,0);
	}
	@Test
	public void distancePointToPoint() {
		Point a = new Point(1,1);
		Point b = new Point(2,2);
		assertEquals(1.4,a.distanceTo(b),0.1);
	}
}