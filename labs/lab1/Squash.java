import java.util.*;

public class Squash {
	
	public static void main(String[] args) {
		int[] arr = {0, 0, 0, 0, 1, 1, 0, 0, 0, 7, 7, 7, 1, 1, 0};
		int[] new_arr = squash(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(new_arr));
	}
	
	public static int[] squash(int[] arr) {
		int match = 0, index = 1;
		int[] new_arr = new int[arr.length];
		
		new_arr[0] = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				match++;
			} else {
				new_arr[index] = arr[i];
				index++;
			}
		}
		
		for (int i = arr.length - match; i < arr.length; i++) {
			new_arr[i] = -1;
		}
		return new_arr;
	}
}