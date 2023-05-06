// Exercise 9.2 

import java.util.*;

public class CircularQueue<E> {
	private Node<E> first; //
	private Node<E> last;
	private int n;
	
	private class Node<E> {
		E data;
		Node<E> next;
	}
	
	// Insert element as last element of the queue
	public void enqueue(E element) {
		Node oldLast = last;
		last = new Node();
		last.data = element;
		if (isEmpty()) { 			// if the list is empty and we want to add 1 element 
			first = last;			// then point to itself
		} else {
			oldLast.next = last;
		}
		last.next = first;
		n++;
	}
	
	// Remove the first element of the queue
	public E dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("This list is empty."); 
		}
		E removed = (E) last.data;
		if (first == last) { 		// if there is 1 element
			first = last = null;
		} else {
			first = first.next;
			last.next = first;		// point last to first to create a queue
		}
		n--;
		return removed;
	}
	
	private boolean isEmpty() {
		return n == 0;
	}
	
	private int size() {
		return n;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (isEmpty()) 
			return "This list is empty ";
		
		Node current = first;
		while (current.next != first) {
			s.append(current.data + " -> ");
			current = current.next;
		}
		s.append(current.data + " -> ");
		return s.toString();
	}
	
	public static void main(String[] args) {
		CircularQueue<Integer> list = new CircularQueue<Integer>();
		list.enqueue(1);
		list.enqueue(2);
		list.enqueue(3);
		list.enqueue(4);
		list.enqueue(5);
		System.out.println(list);
		
		list.dequeue();
		System.out.println(list);
	}
}