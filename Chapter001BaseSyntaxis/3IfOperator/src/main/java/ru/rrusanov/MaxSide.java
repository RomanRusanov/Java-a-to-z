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

class MaxSide {

	//public Triangle t;

	/** 
	 * Calculate area of triangle
	 * @param double a ( side between points A B)
 	 * @param double b ( side between points B C)
 	 * @param double c ( side between points C A)
 	 * @param double perimetr (perimetr of triangle)
	 * @return double (maximum side this triangle)
	**/

	public double max(Triangle t) {

		double aSide = (double) (t.a.distanceTo(t.b));
		double bSide = (double) (t.b.distanceTo(t.c));
		double cSide = (double) (t.c.distanceTo(t.a));

		if (aSide > bSide & aSide > cSide) {
			return aSide;
		} else if (bSide > aSide & bSide > cSide){
			return bSide;
		} else {
			return cSide;
		}
	}
}