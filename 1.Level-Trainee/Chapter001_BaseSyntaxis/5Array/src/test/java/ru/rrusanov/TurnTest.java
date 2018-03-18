package ru.rrusanov;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/** Class test Turn.java.
 * @author Roman Rusanov
 * @since 29.11.2016
 * @version 0.1
**/
public class TurnTest {
	/**
	 * Then Array{1,2,3} When return Array{3,2,1}.
	**/
	@Test
	public void thenArray123WhenReturnArray321() {
		final int[] array = {1, 2, 3};
		Turn turn = new Turn();
		final int[] expectArray = {3, 2, 1};
		final int[] resultArray = turn.back(array);
		assertThat(resultArray, is(expectArray));
	}
	/**
	 * Then Array{1, 2, 3, 4} When return Array{4, 3, 2, 1}.
	**/
	@Test
	public void thenArray1234WhenReturnArray4m321() {
		final int[] array = {1, 2, 3, 4};
		Turn turn = new Turn();
		final int[] expectArray = {4, 3, 2, 1};
		final int[] resultArray = turn.back(array);
		assertThat(resultArray, is(expectArray));
	}
}