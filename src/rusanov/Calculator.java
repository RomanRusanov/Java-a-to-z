package rusanov;

public class Calculator {

    private double result = 0;
	
	public void add(double first, double second) {
		this.result = first + second;
		System.out.println(first+" + "+second+" = "+result);		
	}
	
	public void subtract(double first, double second) {
		this.result = first - second;
		System.out.println(first+" - "+second+" = "+result);
	}
	
	public void div(double first, double second) {
		this.result = first / second;
		System.out.println(first+" / "+second+" = "+result);
	}
	
	public void multiple(double first, double second) {
		this.result = first * second;
		System.out.println(first+" * "+second+" = "+result);
	}
}