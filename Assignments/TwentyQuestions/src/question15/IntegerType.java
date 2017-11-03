package question15;

/**
 * Question 15: Write a program that defines an interface having the following methods: 
 * addition, subtraction, multiplication, and division. Create a class 
 * that implements this interface and provides appropriate functionality
 * to carry out the required operations
 * @author Mitch Goshorn
 *
 */
public class IntegerType implements ArithmeticInterface<IntegerType> {
	int value;
	
	public IntegerType() {
		super();
		value = 0;
	}
	
	public IntegerType(int value) {
		super();
		this.value = value;
	}

	@Override
	public void addition(IntegerType y) {
		this.value += y.value;
	}

	@Override
	public void subtraction(IntegerType y) {
		this.value -= y.value;
	}

	@Override
	public void multiplication(IntegerType y) {
		this.value *= y.value;
	}

	@Override
	public void division(IntegerType y) {
		this.value /= y.value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
	public static void main(String[] args) {
		IntegerType a = new IntegerType(10);
		IntegerType b = new IntegerType(20);
		IntegerType c = new IntegerType(2);
		IntegerType d = new IntegerType(100);
		
		a.addition(b);   		//a =  10 +  20
		b.subtraction(a);		//b =  20 -  30
		c.multiplication(b);    //c =   2 * -10
		d.division(a);		 	//d = 100 /  30
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		
	}

	public int getValue() {
		return value;
	}
	
}
