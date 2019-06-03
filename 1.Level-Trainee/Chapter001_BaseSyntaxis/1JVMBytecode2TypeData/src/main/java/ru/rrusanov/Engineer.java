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
     * @return double result.
     */
    public double sin(double first) {
        this.result = Math.sin(first);
        return this.result;
    }
    /**
     * Calculate cos.
     * @param first value for operation.
     * @return double result.
     */
    public double cos(double first) {
        this.result = Math.cos(first);
        return this.result;
    }
    /**
     * Calculate tan.
     * @param first value for operation.
     * @return double result.
     */
    public double tan(double first) {
        this.result = Math.tan(first);
        return this.result;
    }
    /**
     * Calculate pow.
     * @param first value for operation.
     * @param second value for operation.
     * @return double result.
     */
    public double pow(double first, double second) {
        this.result = Math.pow(first, second);
        return this.result;
    }
    /**
     * Getter for result value.
     * @return double result of operation.
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Setter for result value.
     * @param result double.
     */
    public void setResult(double result) {
        this.result = result;
    }
}
