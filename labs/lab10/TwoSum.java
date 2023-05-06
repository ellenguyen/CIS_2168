// Exercise 17.1
import java.util.*;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> index = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (index.containsKey(diff)) {
				return new int[] {index.get(diff), i};	// return indeces of the element and corresponding element
			} else {
				index.put(nums[i], i);		// map the element to its index
			}
		}
		return new int[] {};
	}
	
	public static void main(String[] args) {
		TwoSum answer = new TwoSum();
		int[] a = {2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(answer.twoSum(a, target))); // [0, 1]
		
		a = new int[]{2, 1, 6};
		target = 8;
		System.out.println(Arrays.toString(answer.twoSum(a, target))); // [0, 2]
	}
}