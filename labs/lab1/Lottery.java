import java.util.*;

public class Lottery {
	
	public static void main(String[] args) {
		int n = 49;
		int k = 6;
		int[] numbers = new int[n]; // a reference to an object of type int array (contains primitive int)
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		
		int[] result = new int[k]; // a reference to an int array
		for (int i = 0; i < result.length; i++) {
			int r = (int) (Math.random() * n);
			
			// pick the element at random location of the numbers array
			result[i] = numbers[r];
			
			// move the last element of the numbers array to the randomly generated location
			numbers[r] = numbers[n - 1];
			n--;
		}
		
		System.out.println(Arrays.toString(numbers));
		System.out.println("drawn: " + Arrays.toString(result));
	}
}
