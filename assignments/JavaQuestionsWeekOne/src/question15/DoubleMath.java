package question15;

public class DoubleMath implements Arithmetic<Double>{

	@Override
	public double Add(Double a, Double b) {
		return a + b;
	}

	@Override
	public double Subtract(Double a, Double b) {
		return a - b;
	}

	@Override
	public double Multiply(Double a, Double b) {
		return a*b;
	}

	@Override
	public double Divide(Double a, Double b) {
		return a/b;
	}

	

}
