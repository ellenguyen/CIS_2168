// Exercise 8.3
import java.util.*;

public class RemoveDups {
	
	// This is an input class. Do not edit.
	public static class LinkedList {
		public int value;
		public LinkedList next;
		
	
		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public static LinkedList deDup(LinkedList first) {
		LinkedList cur = first;
		while (cur.next != null) {
			if (cur.value == cur.next.value) {  // if this node's value equals to the next node's value
				cur.next = cur.next.next;       // then we move to the node after the next node
			} else {
				cur = cur.next;
			}
		}
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
	
	public static LinkedList add(LinkedList first, int value) {
		LinkedList cur = first;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = new LinkedList(value);
		return first;
		
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList(1);
		add(list, 1);
		add(list, 3);
		add(list, 4);
		add(list, 4);
		add(list, 4);
		add(list, 4);
		System.out.print("Original list is: ");
		toString(list);
		deDup(list);
		System.out.print("\nList after removing duplicates is: ");
		toString(list);
	}
}