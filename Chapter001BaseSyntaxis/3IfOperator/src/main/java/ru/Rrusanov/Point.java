/**
 * Class set point by coordinate system, calculate triangle side
 * @author Rusanov
 * @param x,y (point)
 * @param distanceTo (calculate distance point to point)
 * @since 02.06.2016
 * @version 0.1
 **/

package ru.rrusanov;
import java.lang.Math.*;
 

public class Point {

	public double x,y;
	
	// disigner Point	
	public Point (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Calculation of triangle side
	 * @param Point this(x.y)
	 * @param Point p2(x.y)
	 * @return double (Distance of two point this - p2 ) 
	**/
	public double distanceTo (Point p2) {
		return Math.sqrt(Math.pow((this.x - p2.x),2) + Math.pow((this.y - p2.y),2));
	}
}

