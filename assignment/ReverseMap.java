package week3.assignment;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ReverseMap {

	public static void main(String[] args) {
		
		
		Map<Integer, String>studentInfo=new TreeMap<Integer,String>(Collections.reverseOrder());
		studentInfo.put(100, "Hari");
		studentInfo.put(101, "Naveen");
		studentInfo.put(102, "Sam");
		studentInfo.put(104, "Balaji");
		
		System.out.println(studentInfo);

	}

}
