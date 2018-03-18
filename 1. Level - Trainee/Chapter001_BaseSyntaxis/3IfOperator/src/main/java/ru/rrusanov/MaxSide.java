/**
 * Class calulate perimetr, calculate sides of triangle
 * and get max side.
 * @author Rusanov
 * @param Point a (x,y coordinates values for point a)
 * @param Point b (x,y coordinates values for point b)
 * @param Point c (x,y coordinates values for point c)
 * @param perimetr (perimetr of triangle)
 * @since 01.11.2016
 * @version 0.1
**/

package ru.rrusanov;
/**
 * Class Calculate MaxSide.
**/
class MaxSide {
	/**
	 * Calculate area of triangle.
	 * @param t - (Triangle) get triangle
	 * @{values} aSide - (double) a side between points A B
 	 * @{values} bSide - (double) b side between points B C
 	 * @{values} cSide - (double) c side between points C A
	 * @return aSide or bSide or cSide - (double) maximum side this triangle
	**/

	public double max(Triangle t) {

		double aSide = (double) (t.a.distanceTo(t.b));
		double bSide = (double) (t.b.distanceTo(t.c));
		double cSide = (double) (t.c.distanceTo(t.a));

		if (aSide > bSide && aSide > cSide) {
			return aSide;
		} else if (bSide > aSide && bSide > cSide) {
			return bSide;
		} else {
			return cSide;
		}
	}
}