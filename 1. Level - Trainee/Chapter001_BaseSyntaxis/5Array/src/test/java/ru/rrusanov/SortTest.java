package ru.rrusanov;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/** Class test Sort.java.
 * @author Roman Rusanov
 * @since 1.12.2016
 * @version 0.1
**/
public class SortTest {
	/**
	 * Then Array{3,2,1} When return Array{1,2,3}.
	 **/
	@Test
	public void thenArray321WhenReturnArray321() {
		final int[] array = {3, 2, 1};
		Sort sort = new Sort();
		final int[] expectArray = {1, 2, 3};
		final int[] resultArray = sort.bubble(array);
		assertThat(resultArray, is(expectArray));
	}
	/**
	 * Then Array{1, 4, 3, 2} When return Array{1, 2, 3, 4}.
	 **/
	@Test
	public void thenArray1432WhenReturnArray1234() {
		final int[] array = {1, 4, 3, 2};
		Sort sort = new Sort();
		final int[] expectArray = {1, 2, 3, 4};
		final int[] resultArray = sort.bubble(array);
		assertThat(resultArray, is(expectArray));
	}
}