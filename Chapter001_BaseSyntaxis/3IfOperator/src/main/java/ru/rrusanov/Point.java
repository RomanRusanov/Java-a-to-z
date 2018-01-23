/**
 * Class set point by coordinate system, calculate triangle side
 * @author Rusanov
 * @param x,y (point)
 * @param distanceTo (calculate distance point to point)
 * @since 02.06.2016
 * @version 0.1
 **/

package ru.rrusanov;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
/**
 * Class build point by two coordinates, and calculate distance between two points.
**/
public class Point {
	/**
	 * value for coordinates.
	 */
	public double x, y;
	/**
	 * Disigner for Point.
	 * @param x (int) x coordinate
	 * @param y (int) y coordinate
	**/
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * Calculation of triangle side.
	 * @param p2 (Point) x.y
	 * @return double (Distance of two point this - p2 )
	**/
    public double distanceTo(Point p2) {
		return sqrt(pow((this.x - p2.x), 2) + pow((this.y - p2.y), 2));
	}
}

