package question20;

/*
 * Class used to represent the people in the data file, slightly modified the toString function to display properly
 * Kyle Settles
 */
public class Person {

	private String fName;
	private String lName;
	private int age;
	private String state;

	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Person(String fName, String lName, int age, String state) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.state = state;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "Name: " + fName + " " + lName + "\n" + "Age: " + age +"\n" + "State: " + state;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
