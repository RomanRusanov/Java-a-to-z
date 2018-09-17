package lambda.countFunction;
import org.junit.Test;
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

        List<Double> quad = this.function.diapason(1, 10, (x) -> 2D * Math.pow(x, 2) + 4D);

        List<Double> logarithm = this.function.diapason(1, 10, Math::log);

        System.out.println("Linear function " + linear);

        System.out.println("Quad function " + quad);

        System.out.println("Logarithm function " + logarithm);
    }
}