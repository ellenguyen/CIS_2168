import java.util.*;
import java.io.*;

public class Exercise2 {
	public static void main(String[] args) {
		int[] arr1 = {2, 11, 7, 50};
		int[] arr2 = {2, 1, 6, 8};
		int[] arr3 = {21, -301, -12, -4, -65, 47, -56, -210, -356, 9, 0, -3, 1024};
		System.out.println(Arrays.toString(twoSum(arr1, 9))); // [2, 7]
		System.out.println(Arrays.toString(twoSum(arr2, 10))); // [2, 8]
		System.out.println(Arrays.toString(twoSum(arr3, -163))); // [47, -210]
	}
	
	public static int[] twoSum(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == target) {
					return new int[] {arr[i], arr[j]};
				}
			}
		}
		return new int[] {};
	}
}