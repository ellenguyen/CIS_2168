import java.util.Arrays;

public class TestReverser {

	public static void main(String[] args) {
		int[] a = {2, 1, 6, 8};
		Reverser reverser = new Reverser();
		int[] aReversed = reverser.reverse(a);
		System.out.println(Arrays.toString(aReversed));
		
		int[] b = {2, 1, 5};
		int[] bReversed = reverser.reverse(b);
		System.out.println(Arrays.toString(bReversed));
	}
}