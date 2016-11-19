package ru.rrusanov;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/* Class test Factorial.java.
 * @author Roman Rusanov
 * @since 19.11.2016
 * @Version 0.1
 */
public class FactorialTest {
	/** Then n = 15 When function factorial return 1307674368000
	*/
	@Test
	public void thenN_15_WhenReturn1307674368000() {
		Factorial factorial = new Factorial();
		final long expect = 1307674368000L;
		final long result = factorial.calculate(15);
		assertThat(result, is(expect));
	}
	@Test
	public void thenN_NegotiveValueWhenReturn_Error() {
		Factorial factorial = new Factorial();
		final long expect = -1;
		final long result = factorial.calculate(-15);
		assertThat(result, is(expect));
	}

}