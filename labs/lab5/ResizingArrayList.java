// Include Exercise 10.1, 10.2, 10.3

import java.util.*;

public class ResizingArrayList<E> implements Iterable<E> {
   // the initial capacity of the underlying resizing array
   private static final int INIT_CAPACITY = 10;

   private E[] elements;   // the underlying array of generic elements
   private int n;          // the number of elements in the list

   /* Constructor: Initializes an empty list. */
   public ResizingArrayList() {
      elements = (E[]) new Object[INIT_CAPACITY];
      n = 0;
   }

   // Returns the number of elements in the list.
   public int size() { return n; }

   // Is this list empty?
   public boolean isEmpty() { return n == 0;}

   // Resizes the underlying array holding the elements
   private void resize(int capacity) {
      assert capacity >= n;
      elements = Arrays.copyOf(elements, capacity);
   }

   // Adds the item to the end of this list.
   public void add(E element) {
      if (n == elements.length)
         resize(2*elements.length); // double array size if necessary
      elements[n++] = element;              // append the new item
   }

   // Adds the element at index.
   public void add(int index, E element) {
      if (index < 0 || index >= n) throw new ArrayIndexOutOfBoundsException();
      if (n == elements.length)
         resize(2*elements.length); // double array size if necessary
      // Shift data from index to n-1
      for (int i = n; i > index; i--)
         elements[i] = elements[i-1];
      elements[index] = element;  // insert the new element
      n++;
   }

   // Replaces the element at index with the given element
   public void set(int index, E element) {
      if (index < 0 || index >= n) throw new ArrayIndexOutOfBoundsException();
      elements[index] = element;
   }

   // Returns the item at index without removing it
   public E get(int index) {
      if (index < 0 || index >= n) throw new ArrayIndexOutOfBoundsException();
      return elements[index];
   }

   // Removes the element at position index
   public void remove(int index) {
      if (index < 0 || index >= n) throw new ArrayIndexOutOfBoundsException();
      for (int i = index + 1; i < n; i++)
         elements[i-1] = elements[i];
      n--;
   }

   // Returns the index of the first occurrence of element or -1 if not found
   public int indexOf(E element) {
      for (int i = 0; i < n; i++)
         if (elements[i].equals(element)) return i;
      return -1;
   }

   @Override
   // Returns an iterator that iterates over the items in this list
   public Iterator<E> iterator() {return new ArrayIterator();}
   // an iterator, doesn't implement remove() since it's optional
   private class ArrayIterator implements Iterator<E> {
      private int i = 0;
      public boolean hasNext()  { return i < n;                               }
      public void remove()      { throw new UnsupportedOperationException();  }

      public E next() {
         if (!hasNext()) throw new NoSuchElementException();
         return elements[i++];
      }
   }

   @Override
   // returns a string representation of this list
   public String toString() {
      StringBuilder s = new StringBuilder("[ ");
      if (n == 0) return "This list is empty";
      for (E value : this)
         s.append( value + " ");
      s.append("]");
      return s.toString();
   }

   // move all occurrences of b to the end of the list, mutating the list
   // Big-O running time is O(n)
   ResizingArrayList<Integer> moveToEnd(ResizingArrayList<Integer> list, int b) {
	   if (isEmpty()) {			// if the list is already empty then return an empty list
		   return new ResizingArrayList<>();
	   }
	   
	   int count = 0, i = 0;
	   while (i < list.size()) {	// trace the number of elements that match b
		   if ((int) list.get(i) == b) {
			   count++;
			   list.remove(i);
		   } else {
			   i++;
		   }
	   }
	   
	   while (count > 0) {			// add b at the end of the list
		   list.add(b);
		   count--;
	   }
	   // [1, 2, 3, 4] int b = 3 -> [1, 2, 4, 3]
	   
	   return list;		// return the modified list
   }
   public static void main(String[] args) {
      ResizingArrayList<Integer> list1 = new ResizingArrayList<>();
      list1.add(2);  list1.add(1);  list1.add(2);  list1.add(2);    list1.add(6);  list1.add(8);  //list1.add(2);
      System.out.println("Before: " + list1);
      list1.moveToEnd(list1, 2);    // [1, 6, 8, 2, 2, 2, 2, 2]
      System.out.println("After: " + list1);
      
      ResizingArrayList<Integer> list2 = new ResizingArrayList<>();
      list2.add(1);  list2.add(2);  list2.add(3);  list2.add(4);
      System.out.println("Before: " + list2);
      list2.moveToEnd(list2, 3);
      System.out.println("After: " + list2);   // [1, 2, 4, 3]
      
      ResizingArrayList<Integer> list3 = new ResizingArrayList<>();
      list3.add(1);  list3.add(1);  list3.add(1);  list3.add(1);
      System.out.println("Before: " + list3);
      list3.moveToEnd(list3, 4);
      System.out.println("After: " + list3);   // [1, 1, 1, 1]
   }
   
/* Exercise 10.1 - Why bother with two different representations of a list?
 * To accommodate different purposes with arrays handling
 * If need frequent access to the list elements: Array-backed list
 * If add or remove items from anywhere in the list often: LinkedList
 * 
 * 
 * Exercise 10.2 - ArrayList vs. LinkedList - worst case time complexity comparisons of methods
 * 		Method				ArrayList		LinkedList
 * indexOf(E element)			O(n)			O(n)
 * add(int index, E element)	O(n)			O(n)
 * add(E element)				O(1)			O(1)
 * remove(int index)			O(n)			O(n)
 * set(int index, E element)	O(1)			O(n)
 * get(int index)				O(1)			O(n)
 * Iterator.remove()			O(n)			O(n)
*/
   
}