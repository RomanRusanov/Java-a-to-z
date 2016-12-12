package ru.rrusanov;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/** Class test FindAndDelete.java.
 * @author Roman Rusanov
 * @since 7.12.2016
 * @version 0.1
**/
public class FindAndDeleteTest {
	/**
	 * Then Array{Hello,Hello,my,name,name,is,is,Nute,Hello,Hello}.
	 * When return Array{Hello,my,name,is,Nute}
	 **/
	@Test
	public void thenArrayHaveDuplicateElementsWhenReturnArrayWithoutDuplicate() {
		final String[] array = {"Hello", "Hello", "Hello", "my", "name", "name", "is", "is", "Nute", "is"};
		FindAndDelete findAndDelete = new FindAndDelete();
		final String[] expectArray = {"Hello", "my", "name", "is", "Nute"};
		final String[] resultArray = findAndDelete.stringArray(array);
		assertThat(resultArray, is(expectArray));
	}
}