package rusanov;

public class Calculator {

    private Integer first, second;	

    private double result = 0;
		
	public void add(double first, double second) {
		this.result = this.first + this.second;		
	}
	
	public void subtract(double first, double second) {
		this.result = this.first - this.second;
	}
	
	public void div(double first, double second) {
		this.result = this.first / this.second;
	}
	
	public void multiple(double first, double second) {
		this.result = this.first * this.second;
	}
}