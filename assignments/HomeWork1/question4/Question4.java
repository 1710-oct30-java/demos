package question4;
import java.math.BigInteger;
/*
 * Write a program to compute N factorial
 */
public class Question4 {

public static void main(String[] args) {
	//I have no idea how big of a number is expected so i'll use a BigInt
	BigInteger sum = new BigInteger("1");
	if(args.length < 1)
	{	
		System.out.println("Not enough arguements");
		return;
	}
	//Get the number that you want to factor
	int factNum = Integer.parseInt(args[0]);
	//multiplying in ascending order is the excact same as multiplying in descending order
	for(int i = 1; i <= factNum; i++)
	{
		//BigInt's only take strings to instantiate and BigInt's can only multiply with other BigInts
		sum = sum.multiply(new BigInteger(Integer.toString(i)));
	}
	System.out.println(factNum + "! is " + sum.toString());
}
}
