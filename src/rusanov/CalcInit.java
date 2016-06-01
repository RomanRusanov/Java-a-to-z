package rusanov;

public class CalcInit {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		//
		Integer first = 5;
		Integer second =5;
		calc.add(first, second);
		System.out.printf("%d + %d = %d", first, second, calc.getResult);
		//
		calc.subtract(first, second);
		System.out.printf("%d - %d = %d", first, second, calc.getResult);
		//
		calc.div(first, second);
		System.out.printf("%d / %d = %d", first, second, calc.getResult);
		//
		calc.multiple(first, second);
		System.out.printf("%d * %d = %d", first, second, calc.getResult);
	}
}
