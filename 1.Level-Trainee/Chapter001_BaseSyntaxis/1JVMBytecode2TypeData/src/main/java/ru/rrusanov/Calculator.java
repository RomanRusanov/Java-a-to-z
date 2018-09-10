package ru.rrusanov;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 08.06.2016
 *
 * Class simple calculator.
 */
public class Calculator {
	/**
	 * value result.
	 */
    private double result = 0;

	/**
	 * Addition operation.
 	 * @param first value for operation.
	 * @param second value for operation.
	 */
	public void add(double first, double second) {
		this.result = first + second;
	}
	/**
	 * Subtraction operation.
	 * @param first value for operation.
	 * @param second value for operation.
	 */
	public void subtract(double first, double second) {
		this.result = first - second;
	}
	/**
	 * Division operation.
	 * @param first value for operation.
	 * @param second value for operation.
	 */
	public void div(double first, double second) {
		this.result = first / second;
	}
	/**
	 * Multiple operation.
	 * @param first value for operation.
	 * @param second value for operation.
	 */
	public void multiple(double first, double second) {
		this.result = first * second;
	}
	/**
	 * Getter for result value.
	 * @return double result of operation.
	 */
	public double getResult() {
		return this.result;
	}
}