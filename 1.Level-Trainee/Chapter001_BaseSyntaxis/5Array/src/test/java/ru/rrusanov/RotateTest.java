package ru.rrusanov;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/** Class test Rotate.java.
 * @author Roman Rusanov
 * @since 5.12.2016
 * @version 0.1
**/
public class RotateTest {
	/**
	 * Then Array.
	 *			 {2,4,8,6}
	 *			 {5,7,0,3}
	 *			 {9,1,3,7}
	 *			 {4,0,8,2}
	 * When return Array
	 *			 {4,9,5,2}
	 *			 {0,1,7,4}
	 *			 {8,3,0,8}
	 *		 	 {2,7,3,6}
	 **/
	@Test
	public void thenArraySetWhenReturnArrayRotate90DegreesClockwise() {
		final int[][] array = {
			{2, 4, 8, 6},
			{5, 7, 0, 3},
		  	{9, 1, 3, 7},
		  	{4, 0, 8, 2}
	 	};
		Rotate rotate = new Rotate();
		final int[][] expectArray = {
			{4, 9, 5, 2},
			{0, 1, 7, 4},
			{8, 3, 0, 8},
			{2, 7, 3, 6}
		};
		final int[][] resultArray = rotate.clockwise(array);
		assertThat(resultArray, is(expectArray));
	}
}