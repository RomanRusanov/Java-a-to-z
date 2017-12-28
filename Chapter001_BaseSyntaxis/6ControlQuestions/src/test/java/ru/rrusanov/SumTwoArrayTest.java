package ru.rrusanov;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/** Class test Sum2ArrayTest.java.
 * @author Roman Rusanov
 * @since 16.12.2016
 * @version 0.2
**/
public class SumTwoArrayTest {
	/**
	 * Then firstArray{1, 3, 5}, secondArray{2, 4, 6, 7}.
	 * When return Array{1, 2, 3, 4, 5, 6, 7}.
	 **/
	@Test
	public void thenFirstArrayAddToSecondThenReturnArraySum() {
		final int[] firstArray = {1, 3, 5};
		final int[] secondArray = {2, 4, 6, 7};
		SumTwoArray sumTwoArray = new SumTwoArray();
		final int[] expectArray = {1, 2, 3, 4, 5, 6, 7};
		final int[] resultArray = sumTwoArray.merge(firstArray, secondArray);
		assertThat(resultArray, is(expectArray));
	}
}
