package rusanov;

public class Calculator {

    private int first, second;	

    private double result = 0;
		
	public void add(double first, double second) {
		this.result = first + second;		
	}
	
	public void subtract(double first, double second) {
		this.result = first - second;
	}
	
	public void div(double first, double second) {
		this.result = first / second;
	}
	
	public void multiple(double first, double second) {
		this.result = first * second;
	}
	double getResult();
}