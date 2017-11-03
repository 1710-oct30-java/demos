package question19;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListManipulation {
	public static void main(String[] args) {
		ArrayList<Integer> myArrayList = new ArrayList<>();
		Collections.addAll(myArrayList, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(myArrayList);
		
		
		int sumEvens = 0;
		for(int n : myArrayList) {
			if(n % 2 == 0) {
				sumEvens = sumEvens + n;;
			}
		}
		System.out.println(sumEvens);
		
		int sumOdds = 0;
		for(int n : myArrayList) {
			if(n % 2 != 0) {
				sumOdds = sumOdds + n;;
			}
		}
		System.out.println(sumOdds);
		
	}
}
