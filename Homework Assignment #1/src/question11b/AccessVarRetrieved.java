package question11b;
import question11a.AccessVar;

public class AccessVarRetrieved {

	public static void main (String args[]) {
		
		AccessVar class1 = new AccessVar ();
		
		System.out.println("The Value of the public variable in the other class is " + class1.i);
		
	}
}
