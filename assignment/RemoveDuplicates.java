package week3.assignment;

import java.util.HashSet;

public class RemoveDuplicates {

	

	public static void main(String[] args) {
		
		String str = "PayPal India";
		char[] charArray = str.toCharArray();
		
		HashSet<Character>charSet= new HashSet<Character>();
		HashSet<Character>dupCharSet= new HashSet<Character>();
		
		for (int i = 0; i < charArray.length; i++) {
			if (charSet.contains(charArray[i])) {
				dupCharSet.add(charArray[i]);}
				else {
					charSet.add(charArray[i]);
			}
				System.out.println(charSet);
				//System.out.println(dupCharSet);
			
				
			}
		
		for (Character character : charSet) {
			if(character!=' ') {
				System.out.print(character);
			}
		}
		

	}

}
