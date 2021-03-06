package ru.rrusanov;
import static java.lang.Math.sqrt;
/**
 * Class bild trianle by 3 point, calulate half perimetr, calculate area of triangle.
 * @author Rusanov
 * Point a (x,y coordinates values for point a)
 * Area (calculate Area of triangle)
 * Triangle (disigner with aruments (Point a,b,c))
 * @since 02.06.2016
 * @version 0.1
**/
public class Triangle {
	/**
	 * Point a, b, c.
	**/
	public Point a, b, c;
/**
 * Disgner Triangle.
 * @param a - (Point) x,y coordinates values for point a
 * @param b - (Point) x,y coordinates values for point b
 * @param c - (Point) x,y coordinates values for point c
**/
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	/**
	 * Calculate area of triangle.
	 *  ab ( distance by Points A B)
 	 *  bc ( distance by Points B C)
 	 *  ca ( distance by Points C A)
 	 *  halfPerimeter (calculate half perimeter)
	 * @return double AreaTriangle or -1 if triangle doesn't exist
	**/
	public double area() {
		double ab = a.distanceTo(b);
		double bc = b.distanceTo(c);
		double ca = c.distanceTo(a);
		double halfP;
		// check existing triangle by this value a,b,c
		if ((ab < (bc + ca)) & (bc < (ab + ca)) & (ca < (ab + bc))) {
			halfP = (ab + bc + ca) / 2;
			// calculate triangle area
			return sqrt(halfP * ((halfP - ab) * (halfP - bc) * (halfP - ca)));
		} else {
			// message wrong input data for Points
			System.out.println("by this values Point A,B,C triangle doesn't exist! ");
			return -1;
		}
	}
}
