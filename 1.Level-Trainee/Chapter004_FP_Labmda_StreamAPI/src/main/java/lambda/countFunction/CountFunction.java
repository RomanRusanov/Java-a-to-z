package lambda.countFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.09.2018
 *
 * The CountFunction class implements function count linear, square, logarithm ranges.
 */
public class CountFunction {
    List<Double> diapason(int start, int end, BiFunction<Double, Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i != end; i++) {
            result.add(func.apply(firstDouble, secondDouble));
        }
        return result;
    }
}
