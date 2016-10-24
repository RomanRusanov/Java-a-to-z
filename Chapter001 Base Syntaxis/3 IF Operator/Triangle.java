/**
 * * Class bild trianle by 3 point, calulate half perimetr, calculate area of triangle
 * @author Rusanov
 * @param Point a (x,y coordinates values for point a)
 * @param Point b (x,y coordinates values for point b)
 * @param Point c (x,y coordinates values for point c)
 * @param Area (calculate Area of triangle)
 * @param abDistance (Distance by Points A B)
 * @param bcDistance (Distance by Points B C)
 * @param caDistance (Distance by Points C A)
 * @param Triangle (disigner with aruments (Point a,b,c))
 * @param halfPerimetr (calculate half perimetr)
 * @since 02.06.2016
 * @version 0.1
 **/

//package rusanov
import java.lang.Math.*;

public class Triangle {
	
	public Point a;
	public Point b;
	public Point c;

	// disigner Triangle
	public Triangle (Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	// calculate area of triangle
	public double Area () {
		// 
		double abDistance = a.distanceTo(b);
		double bcDistance = b.distanceTo(c);
		double caDistance = c.distanceTo(a);
		double halfPerimetr;

		// check existing triangle by this value a,b,c
		if ( (abDistance < (bcDistance + caDistance)) & (bcDistance < (abDistance + caDistance)) & (caDistance < (abDistance + bcDistance))) {
			// calculate halfPerimetr
			halfPerimetr = (abDistance + bcDistance + caDistance) / 2;
			return Math.sqrt(halfPerimetr * ((halfPerimetr - abDistance) * (halfPerimetr - bcDistance) * (halfPerimetr - caDistance)));

		} else {
			// message wrong input data for Points
			System.out.println("by this vulue Point A,B,C triangle doesn't exist! ");
			return -1;
		}

	}

}
