import java.util.*;

/**
 *  An implementation of the stack data structure.
 *  supports the usual push and pop operations, along with methods for peeking
 *  at the top item, testing if the stack is empty, and iterating through the
 *  items in LIFO (Last In First Out) order.
 *
 *  This implementation uses a resizing array, which doubles the underlying array
 *  when it is full and halves the underlying array when it is one-quarter full.
 *  The push and pop operations take constant amortized time. The size, peek, and
 *  is-empty operations take constant time in the worst case.
 */

public class Stack<Item> implements Iterable<Item> {
   private Item[] a;         // array of items
   private int n;            // number of elements on stack


   // Initializes an empty stack.
   public Stack() {
      a = (Item[]) new Object[2];
      n = 0;
   }

   // Is this stack empty?
   public boolean isEmpty() { return n == 0; }

   // Returns the number of items in the stack.
   public int size() { return n; }


   // resize the underlying array holding the elements
   private void resize(int capacity) {
      assert capacity >= n;
      a = Arrays.copyOf(a, capacity);
   }

   // Adds the item to this stack.
   public void push(Item item) {
      if (n == a.length) resize(2*a.length); // double size of array if necessary
      a[n++] = item;                                 // add item
   }

   // Removes and returns the item most recently added to this stack.
   // Throws java.util.NoSuchElementException if this stack is empty.
   public Item pop() {
      if (isEmpty()) throw new NoSuchElementException("Stack underflow");
      Item item = a[n-1];
      a[n-1] = null;                              // to avoid loitering
      n--;
      // shrink size of array if necessary
      if (n > 0 && n == a.length/4) resize(a.length/2);
      return item;
   }


   // Returns (but does not remove) the item most recently added to this stack.
   public Item peek() {
      if (isEmpty()) throw new NoSuchElementException("Stack underflow");
      return a[n-1];
   }

   // Returns an iterator to this stack that iterates through the items in LIFO order.
   public Iterator<Item> iterator() {
      return new ReverseArrayIterator();
   }

   // an iterator, doesn't implement remove() since it's optional
   private class ReverseArrayIterator implements Iterator<Item> {
      private int i;
      public ReverseArrayIterator() {
         i = n-1;
      }
      public boolean hasNext() {
         return i >= 0;
      }
      public void remove() {
         throw new UnsupportedOperationException();
      }
      public Item next() {
         if (!hasNext()) throw new NoSuchElementException();
         return a[i--];
      }
   }
   
   // Assignment SunsetViews - Running time is O(n)
   public List<Integer> sunsetViews(int[] buildings, String direction) {
	   Stack<Integer> sunfacing = new Stack<>();
	   
	   if (direction.equals("EAST")) {				// if the sun is east
		   int i = 0;								// start looping from left to right
		   while (i < buildings.length) {
			   int height = buildings[i];
			   while ((sunfacing.size()) > 0 && (buildings[sunfacing.peek()]) <= height) {	// if the new height is taller
				   sunfacing.pop();															// remove the current one and add the new one 
			   }
			   sunfacing.push(i);
			   i++;
		   }
	   } else {										// if the sun is west
		   int i = buildings.length - 1;			// start looping from right to left
		   while (i >= 0) {
			   int height = buildings[i];
			   while ((sunfacing.size()) > 0 && (buildings[sunfacing.peek()]) <= height) {	// if the new height is taller
				   sunfacing.pop();															// remove the current one and add the new one 
			   }
			   sunfacing.push(i);
			   i--;
		   }
	   }
	   
	   List<Integer> index = new ArrayList<>();		// store the output as a list
	   while (!sunfacing.isEmpty()) {
		   Integer element = sunfacing.pop();
		   index.add(element);
	   }
	   
	   if (direction.equals("EAST")) {
		   return reverse(index);
	   }
	   return index;	// return the list containing the indices of buildings that can see the sun
   }
   
   // A method that reverses the element order
   public static List<Integer> reverse(List<Integer> list) {
		for (int i = 0; i < list.size() / 2; i++) {
			Integer temp = list.get(i);
			list.set(i, list.get(list.size() - 1 - i));
			list.set(list.size() - 1 - i, temp);		
		}
		return list;
	}
   
   @Override
   public String toString() {
	   if (isEmpty()) return "This stack is empty";
	   StringBuilder s = new StringBuilder("[");
	   for (Item value : this) {
		   if (s.length() > 1) s.append(",");
		   s.append(" " + value);
	   }
	   s.append(" ]");
	   return s.toString();
   }
   
   // Unit tests the Stack data type.
   public static void main(String[] args) {
	   Stack<Integer> solution = new Stack<>();
	   int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};	// <- the sun from east
	   System.out.println("East: " + solution.sunsetViews(buildings, "EAST")); // [1, 3, 6, 7]
	   System.out.println("West: " + solution.sunsetViews(buildings, "WEST"));
	   
	   // test 2
	   buildings = new int[]{0, 1};
	   System.out.println("East: " + solution.sunsetViews(buildings, "EAST")); // prints [1]
	   System.out.println("West: " + solution.sunsetViews(buildings, "WEST")); // prints [1]

	   // test 3
	   buildings = new int[]{};
	   System.out.println("East: " + solution.sunsetViews(buildings, "EAST")); // prints []
	   System.out.println("West: " + solution.sunsetViews(buildings, "WEST")); // prints []

	   // test 4
	   buildings = new int[]{1, 2, 3, 1, 5, 6, 9, 1, 9, 9, 11, 10, 9, 12, 8};
	   System.out.println("East: " + solution.sunsetViews(buildings, "EAST")); // prints [13, 14]
	   System.out.println("West: " + solution.sunsetViews(buildings, "WEST")); // prints [0, 1, 2, 4, 5, 6, 10, 13]
   }
}