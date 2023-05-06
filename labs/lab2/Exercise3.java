import java.util.*;
import java.io.*;

public class Exercise3 {
	public static void main(String[] args) {
		// test intersect
		ArrayList<Integer> list1 = new ArrayList<Integer>(List.of(1, 4, 8, 9, 11, 15, 17, 28, 41, 59));
		ArrayList<Integer> list2 = new ArrayList<Integer>(List.of(4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81));
		System.out.println("Intersect: " + intersect(list1, list2));
		
		// test reverse
		ArrayList<String> str1 = new ArrayList<String>(List.of("Alabama", "New York", "Hanoi", "New Jersey", "Philadelphia"));
		System.out.println("Not reversed: " + str1);
		reverse(str1);
		System.out.println("Reversed: " + str1);
	}
	
	// return a new list that contains only the elements that are found in both lists
	public static List<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		List<Integer> intersectList = new ArrayList<Integer>();
		for (int i = 0; i < list1.size(); i++) {
			if (list2.contains(list1.get(i))) { 
				intersectList.add((Integer) list1.get(i));
			}
		}
		return intersectList;
	}
	
	// reverses the order of the elements in an ArrayList of Strings
	public static void reverse(ArrayList<String> str1) {
		for (int i = 0; i < str1.size() / 2; i++) {
			String temp = str1.get(i);
			str1.set(i, str1.get(str1.size() - 1 - i));
			str1.set(str1.size() - 1 - i, temp);		
		}
	}
}