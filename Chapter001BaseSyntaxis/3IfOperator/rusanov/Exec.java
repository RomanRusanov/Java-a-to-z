/**
 * Class calculate tringle area by three points
 * @author Rusanov
 * @param a,b,c (coordinates of points)
 * @param t (triangle with points a,b,c)
 * @param distanceTo (calculate distance point to point)
 * @param Area (Calculate triangle area)
 * @since 02.06.2016
 * @version 0.1
 **/
package rusanov;


public class Exec {
	public static void main(String[] args) {

		Point a = new Point(3,2);
		Point b = new Point(6,6);
		Point c = new Point(11,1);


		Triangle t = new Triangle (a,b,c);

		System.out.println("Area triangle = " + t.area());
		//System.out.println("HalfPerimetr = " + t.area.halfP);
	}
}