package ru.rrusanov;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/** Class test Sum2ArrayTest.java.
 * @author Roman Rusanov
 * @since 16.12.2016
 * @version 0.1
**/
public class SumTwoArrayTest {
	/**
	 * Then firstArray{1,2,3,4,5}, secondArray{1,2,3,4,5}.
	 * When return Array{1,1,2,2,3,3,4,4,5,5}.
	 **/
	@Test
	public void thenFirstArrayAddToSecondThenReturnArraySum() {
		final int[] firstArray = {1, 2, 3, 4, 5};
		final int[] secondArray = {1, 2, 3, 4, 5};
		SumTwoArray sumTwoArray = new SumTwoArray();
		final int[] expectArray = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
		final int[] resultArray = sumTwoArray.sum(firstArray, secondArray);
		assertThat(resultArray, is(expectArray));
	}
}
