/**
 * Class bild trianle by 3 point, calulate half perimetr, calculate area of triangle
 * @author Rusanov
 * @param Point a (x,y coordinates values for point a)
 * @param Point b (x,y coordinates values for point b)
 * @param Point c (x,y coordinates values for point c)
 * @param Area (calculate Area of triangle)
 * @param Triangle (disigner with aruments (Point a,b,c))
 * @since 02.06.2016
 * @version 0.1
**/

package ru.rrusanov;
import java.lang.Math.*;

public class Triangle {
	
	public Point a;
	public Point b;
	public Point c;


	// disigner Triangle
	public Triangle (Point a,Point b,Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	/** 
	 * Calculate area of triangle
	 * @param ab ( distance by Points A B)
 	 * @param bc ( distance by Points B C)
 	 * @param ca ( distance by Points C A)
 	 * @param halfPerimetr (calculate half perimetr)
	 * @return double AreaTriangle
	**/  
	public double area () {
		
		double ab = a.distanceTo(b);
		double bc = b.distanceTo(c);
		double ca = c.distanceTo(a);
		double halfP;

		// check existing triangle by this value a,b,c
		if ( (ab < (bc + ca)) & (bc < (ab + ca)) & (ca < (ab + bc))) {
			
			halfP = (ab + bc + ca) / 2;
			// calculate triangle area
			return Math.sqrt(halfP * ((halfP - ab) * (halfP - bc) * (halfP - ca)));

		} else {
			// message wrong input data for Points
			System.out.println("by this values Point A,B,C triangle doesn't exist! ");
			return -1;
		}
	}
}
