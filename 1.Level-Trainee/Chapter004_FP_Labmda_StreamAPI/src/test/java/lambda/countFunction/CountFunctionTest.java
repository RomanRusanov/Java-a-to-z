package lambda.countFunction;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.09.2018
 *
 * The CountFunctionTest.java test behavior CountFunction class.
 */
public class CountFunctionTest {
    /**
     * The field contain instance of tested class.
     */
    private CountFunction function = new CountFunction();
    /**
     * The method test diapason().
     */
    @Test
    public void diapason() {
        List<Double> linear = this.function.diapason(1, 10, (x) -> 2D * x + 4D);
        Assert.assertEquals(Arrays.asList(6.0, 8.0, 10.0, 12.0, 14.0, 16.0, 18.0, 20.0, 22.0), linear);

        List<Double> quad = this.function.diapason(1, 10, (x) -> 2D * Math.pow(x, 2) + 4D);
        Assert.assertEquals(Arrays.asList(6.0, 12.0, 22.0, 36.0, 54.0, 76.0, 102.0, 132.0, 166.0), quad);

        List<Double> logarithm = this.function.diapason(1, 10, Math::log);
        Assert.assertEquals(Arrays.asList(0.0, 0.6931471805599453, 1.0986122886681098, 1.3862943611198906, 1.6094379124341003, 1.791759469228055, 1.9459101490553132, 2.0794415416798357, 2.1972245773362196), logarithm);
    }
}