package ru.rrusanov;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 30.05.2019
 *
 * Class engineer calculator.
 */
public class Engineer {
    /**
     * value result.
     */
    private double result = 0;

    /**
     * Calculate sin.
     * @param first value for operation.
     */
    public void sin(double first) {
        this.result = Math.sin(first);
    }
    /**
     * Calculate cos.
     * @param first value for operation.
     */
    public void cos(double first) {
        this.result = Math.cos(first);
    }
    /**
     * Calculate tan.
     * @param first value for operation.
     */
    public void tan(double first) {
        this.result = Math.tan(first);
    }
    /**
     * Calculate pow.
     * @param first value for operation.
     * @param second value for operation.
     */
    public void pow(double first, double second) {
        this.result = Math.pow(first, second);
    }
    /**
     * Getter for result value.
     * @return double result of operation.
     */
    public double getResult() {
        return this.result;
    }
}
