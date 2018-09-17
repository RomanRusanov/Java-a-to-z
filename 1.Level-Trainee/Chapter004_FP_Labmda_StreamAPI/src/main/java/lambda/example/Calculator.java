package lambda.example;
import java.util.function.BiFunction;
import java.util.function.Consumer;
/**
 * The Example.
 */
public class Calculator {
    /**
     * Functional interface.
     */
    public interface Operation {
        /**
         * The method describe method to do.
         * @param left first argument.
         * @param right second argument.
         * @return result.
         */
        double calc(int left, int right);
    }
    /**
     * The method use functional interface. Multiplication table.
     * @param start value.
     * @param finish value.
     * @param value to mulpiple
     * @param op BiFunction interface.
     * @param media Consumer interface.
     */
    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }
    /**
     * Main method.
     * @param args arguments.
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(
                0, 10, 2,
                (value, index) -> {
                    double result = value * index;
                    System.out.printf("Multiple %s * %s = %s %n", value, index, result);
                    return result;
                },
                result -> System.out.println(result)
        );
    }
}
