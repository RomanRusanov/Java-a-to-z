package ru.rrusanov;
/**
 * Class calulate perimetr, calculate sides of triangle
 * and get max side.
 * @author Rusanov
 * @since 01.11.2016
 * @version 0.1
**/
class MaxSide {
	/**
	 * Calculate area of triangle.
	 * @param t (Triangle) get triangle
	 * @return aSide or bSide or cSide - (double) maximum side this triangle
	**/

	public double max(Triangle t) {

		double aSide = t.a.distanceTo(t.b);
		double bSide = t.b.distanceTo(t.c);
		double cSide = t.c.distanceTo(t.a);

		if (aSide > bSide && aSide > cSide) {
			return aSide;
		} else if (bSide > aSide && bSide > cSide) {
			return bSide;
		} else {
			return cSide;
		}
	}
}