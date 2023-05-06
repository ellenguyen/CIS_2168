import java.util.*;

public class Reverser {
	public int[] reverse(int[] nums) {
		for (int i = 0; i < nums.length / 2; i++) {
			exch(nums, i, nums.length - 1 - i);
		}
		return nums;
	}
	
	private void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}