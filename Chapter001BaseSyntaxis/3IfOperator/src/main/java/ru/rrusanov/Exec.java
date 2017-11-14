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
package ru.rrusanov;

/**
 * Run Program.
 **/
public class Exec {
	/**
	 * Main method.
	 * @param args - array of string.
	 */
	public static void main(String[] args) {

		final int ax = 3, dy =3, ex = 3;
		final int ay = 2, ey = 2;
		final int bx = 6, by = 6;
		final int cx = 11;
		final int cy = 1;
		final int dx = 4;

		Point a = new Point(ax, ay);
		Point b = new Point(bx, by);
		Point c = new Point(cx, cy);
		Point d = new Point(dx, dy);
		Point e = new Point(ex, ey);

		Triangle t = new Triangle(a, b, c);
		MaxSide m = new MaxSide();

		System.out.println("Area triangle = " + t.area());
		System.out.printf("Max Side = %.1f\n", m.max(t));
		System.out.println("Point c coordinates (" + t.c.x + "," + t.c.y + ")");
	}
}