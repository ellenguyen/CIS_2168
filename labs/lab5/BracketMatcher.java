import java.util.Stack;

public class BracketMatcher {
	public static void matches(String text) {
		Stack<Character> openingBrackets = new Stack<>();
		int position;
		char next;
		for (position = 1; position <= text.length(); position++) {
	    	 next = text.charAt(position - 1);
	         if (next == '[' || next == '{' || next == '(') {
	        	 openingBrackets.push(next);		// add the opening brackets onto the stack
	         } else if ((next == ']' && !openingBrackets.isEmpty() && openingBrackets.peek() == '[')
	        		 || (next == '}' && !openingBrackets.isEmpty() && openingBrackets.peek() == '{')
	        		 || (next == ')' && !openingBrackets.isEmpty() && openingBrackets.peek() == '(')) {
	        	 openingBrackets.pop();				// if the brackets match then remove that element
	         } 
		}
		
		if (openingBrackets.isEmpty()) {			// after iterating, if the final stack is empty then succeed
			System.out.println("SUCCESS!");
		} else {
			System.out.println(position - 1);		// if there is still brackets not matching then print out position
		}
	}

	public static void main(String[] args) {
		String text1 = "foo(bar[i])";
		System.out.println("processing: " + text1);
		matches(text1);		// SUCCESS
		
		String text2 = "[](){}";
		System.out.println("processing: " + text2);
		matches(text2);		// SUCCESS
		
		String text3 = "{";
		System.out.println("processing: " + text3);
		matches(text3);		// 1
		
		String text4 = "[()]";
		System.out.println("processing: " + text4);
		matches(text2);		// SUCCESS
		
		String text5 = "[[]](()";
		System.out.println("processing: " + text5);
		matches(text5);		// 7
	}
}