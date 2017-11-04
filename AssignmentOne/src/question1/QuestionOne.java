package question1;
/*
 * Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
 */
public class QuestionOne 
{
	public static void main(String[] args)
	{
	int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
	
	// bubble sort
	for(int j=0; j < arr.length - 1; j++)
	{
		for(int i=0; i<arr.length - j - 1; i++)
		{
			if(arr[i]>arr[i+1])
			{
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
	}
	//print array
	for (int k=0; k<arr.length; k++)
	{
		System.out.println(arr[k] + " ");
	}
	
	
	}
}
