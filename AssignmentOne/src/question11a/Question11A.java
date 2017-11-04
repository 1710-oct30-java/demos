package question11a;
/*
 * Write a program that would access two float-variables from a class that 
 * exists in another package. Note, you will need to create two packages
 * to demonstrate the solution
 */
public class Question11A 
{
    float a = 2.3f;
	float b = 4.5f;
	public float getA() {
		return a;
	}
	public void setA(float a) {
		this.a = a;
	}
	public float getB() {
		return b;
	}
	public void setB(float b) {
		this.b = b;
	}
	public Question11A() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
