package lambda.countFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.09.2018
 *
 * The CountFunction class implements function count linear, square, logarithm ranges.
 */
public class CountFunction {
    /**
     * The method count function in range.
     * @param start range
     * @param end range
     * @param func function.
     * @return List with value functions in each step.
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i != end; i++) {
            result.add(func.apply((double) i));
        }
        return result;
    }
}
