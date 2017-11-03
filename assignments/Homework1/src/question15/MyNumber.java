package question15;

public class MyNumber implements MyMath {
	private int value;

	public MyNumber(int value) {
		super();
		this.value = value;
	}

	@Override
	public int addition(int a) {
		return this.value + a;
	}

	@Override
	public int subtraction(int b) {
		return this.value - b;
	}

	@Override
	public int multiplication(int c) {
		return this.value * c;
	}

	@Override
	public int division(int d) {
		return this.value / d;
	}
	
	
}
