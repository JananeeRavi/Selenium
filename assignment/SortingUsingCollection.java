package week3.assignment;

import java.util.Arrays;

public class SortingUsingCollection {

	public static void main(String[] args) {
		
		//Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)
		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};

		//get the length of the array
		int arrayLength=input.length;
		System.out.println("The size of the array :" +arrayLength);
		
		//sort the array
		Arrays.sort(input);
		for (int i = input.length-1;i>=0;i--) {
			
		System.out.println(input[i]);
			
		}
	}

}
