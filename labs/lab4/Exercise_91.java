// Exercise 9.1

import java.util.*;

public class Exercise_91 {
	
	public static class LinkedList {
		public int value;
		public String data;
		public LinkedList next;
		
	
		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
		
		public LinkedList(String data) {
			this.data = data;
			this.next = null;
		}
	}
	
	// Part b - Remove the last node
	public static LinkedList removeLast(LinkedList first) {
		if (first == null || first.next == null) {		// if there is nothing in the list
			return null;								// return nothing
		} else {
			LinkedList temp = first;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;							// point the current node to null
			return first;
		}
	}
	
	// Part d - Delete the k-th element
	public static LinkedList delete(LinkedList first, int k) {
		int index = 0;
		LinkedList temp = first;
		if (k <= 0 || first == null || k > size(first)) { // if the position is negative or the first node is null
			return null;
		} else if (k == size(first)) {          		  // if k is the last position
			return removeLast(first);					  // then use removeLast method to remove the last node
		} else if (k == 1) {							  // if there is only 1 node
			return first.next;							  // then return null
		} else {
			while (temp != null) {
				index++;
				if (index == k - 1) { 					  // if the pointer is at the position k - 1 then we skip the next node
					break;
				}
				temp = temp.next;
			}
			temp.next = temp.next.next;
			return first;
		}
	}
	
	// Part f - Check if a String key is in the node's value
	public static boolean find(LinkedList first, String key) {
		LinkedList temp = first;
		while (temp != null) {
			if (temp.data.equals(key)) {				  // return true if the data in the current node matches the key
				return true;
			}
			temp = temp.next;							  // keep pointing to the next node
		}
		return false;									  // return false if no node's value matches
	}
	
	// Keep track of the number of nodes in the list
	public static int size(LinkedList first) {
		LinkedList temp = first;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}
	
	public static LinkedList add(LinkedList first, int value) {
		LinkedList cur = first;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = new LinkedList(value);
		return first;
		
	}
	
	// Same add method but the element is a String type
	public static LinkedList add(LinkedList first, String data) {
		LinkedList cur = first;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = new LinkedList(data);
		return first;
		
	}
	
	public static void toString(LinkedList first) {
		LinkedList cur = first;
		while (cur != null) {
			System.out.print(cur.value + " -> ");
			cur = cur.next;
		}
		System.out.print("null");
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList(1);
		add(list, 2);
		add(list, 3);
		add(list, 4);
		add(list, 5);
		removeLast(list);
		list = delete(list, 3);
		toString(list);
		
		LinkedList list2 = new LinkedList("Five");
		add(list2, "Grass");
		add(list2, "Light");
		add(list2, "Fish");
		add(list2, "Gold");
		Boolean result = find(list2, "five");
		System.out.println(result);
		
	}
}
