// 11.10
// If we change the order of integers in the array keys on line 5 then we still get the same output
// Because add method sorts the order that each element will be positioned in the binary search tree

public class TestBST {
	public static void main(String[] args) {
		BST<Integer> tree = new BST<>();
		Integer[] keys = {49, 28, 83, 18, 40, 71, 97, 11, 19, 32, 44, 69, 72, 92, 99};
		
		System.out.println("Inserting the following keys: ");
		for (Integer key : keys) {
			System.out.printf("%d ", key);
			tree.add(key);
		}
		
		System.out.printf("%n%nPreorder traversal%n");
		tree.preorderTraversal();
		
		System.out.printf("%n%nInorder traversal%n");
		tree.inorderTraversal();
		
		System.out.printf("%n%nPostorder traversal%n");
		tree.postorderTraversal();
		
		System.out.println("\n\n" + tree.contains(12));
	}
}