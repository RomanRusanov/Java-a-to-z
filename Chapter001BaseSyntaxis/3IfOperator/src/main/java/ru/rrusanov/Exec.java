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


public class Exec {
	public static void main(String[] args) {

		Point a = new Point(3,2);
		Point b = new Point(6,6);
		Point c = new Point(11,1);
		Point d = new Point(4,0);
		Point e = new Point(3,2);

		Triangle t = new Triangle (a,b,c);
		MaxSide m = new MaxSide();

		System.out.println("Area triangle = " + t.area());
		System.out.print("Max Side = ");
		System.out.printf("%.1f\n",m.max(t));
		System.out.println("Point c coordinates (" + t.c.x + "," + t.c.y + ")");

		//System.out.println("SideAB = " + t.a.distanceTo(b));
		//System.out.println("SideBA = " + t.b.distanceTo(c));	
		//System.out.println("SideCA = " + t.c.distanceTo(a));
	}
}