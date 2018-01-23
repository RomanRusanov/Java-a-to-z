package ru.rrusanov;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 08.06.2016
 *
 * Class test Calculator class..
 */
public class CalculatorTest {
    /**
     * Then pass two double return sum.
     */
    @Test
    public void thenAddWhenReturnSum() {
        double result;
        Calculator calculator = new Calculator();
        calculator.add(5.0, 5.0);
        result = calculator.getResult();
        Assert.assertThat(10.0, is(result));
    }
    /**
     * Then pass two double return subtraction.
     */
    @Test
    public void thenSubtractReturnDifferenceBetweenFirstSecond() {
        double result;
        Calculator calculator = new Calculator();
        calculator.subtract(10.0, 5.0);
        result = calculator.getResult();
        Assert.assertThat(5.0, is(result));
    }
    /**
     * Then pass two double return division.
     */
    @Test
    public void thenPassTwoDoubleReturnResultDivision() {
        double result;
        Calculator calculator = new Calculator();
        calculator.div(10.0, 2.0);
        result = calculator.getResult();
        Assert.assertThat(5.0, is(result));
    }
    /**
     * Then pass two double return multiplication.
     */
    @Test
    public void thenPassTwoDoubleReturnResultMultiplication() {
        double result;
        Calculator calculator = new Calculator();
        calculator.multiple(10.0, 2.0);
        result = calculator.getResult();
        Assert.assertThat(20.0, is(result));
    }
}