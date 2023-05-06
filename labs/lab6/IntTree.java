import java.util.*;
// 11.4 - Part a - create an IntTree class
public class IntTree {
	private Node root;
	
	private class Node {
		int data;
		Node left, right;
		public Node(int data) { this(data, null, null); }
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	public IntTree(int size) {
		root = buildTree(1, size);
	}
	
	private Node buildTree(int n, int size) {
		if (n > size) return null;
		else {
			Node left = buildTree(2 * n, size);
			Node right = buildTree(2 * n + 1, size);
			return new Node(n, left, right);
		}
	}
	
	// left - root - right
	public void inorderTraversal() {
		   System.out.print("inorder: ");
		   inorderHelper(root);
	   }
	   
	private void inorderHelper(Node node) {
		if (node != null) {
			inorderHelper(node.left);
			System.out.print(" " + node.data);
			inorderHelper(node.right);
		}
	}
	
	public void printSideways() { 
		   printSideways(root, 0);
	   }
	   
	private void printSideways(Node root, int level) { 
		if (root != null) {
			printSideways(root.right, level + 1);
			for (int i = 0; i < level; i++) {
				System.out.print("     ");
			}
			System.out.println(root.data);
			printSideways(root.left, level + 1);
		}
	}
	   
	// 11.4 - Part b1 - preorderTraversal method
	// root - left - right
	public void preorderTraversal() {
		System.out.print("preorder: ");
		preorderHelper(root);
	}
	
	private void preorderHelper(Node node) {
		if (node != null) {
			System.out.print(" " + node.data);
			preorderHelper(node.left);
			preorderHelper(node.right);
		}
	}
	
	// 11. 4 - Part b2 - postorderTraversal method
	// left - right - root
	public void postorderTraversal() {
		System.out.print("postorder: ");
		postorderHelper(root);
	}
		
	private void postorderHelper(Node node) {
		if (node != null) {
			postorderHelper(node.left);
			postorderHelper(node.right);
			System.out.print(" " + node.data);
		}
	}
	
	// 11.4 - Part c - sum method - calculate the sum of values stored in tree
	public int sum() {
		return sum(root);
	}
	
	private int sum(Node node) {
		int sum = 0;
		if (node != null) {
			sum = node.data + sum(node.left) + sum(node.right);
		}
		return sum;
	}
	
	// 11.4 - Part d - countLevels method - the number of tree levels
	public int countLevels() {
		return countLevels(root);
	}
	
	private int countLevels(Node node) {
		if (node == null) return 0;
		else 			  return Math.max(countLevels(node.left), countLevels(node.right)) + 1;
	}
	
	// 11.4 - Part e - countLeaves method - the number of leaves
	public int countLeaves() {
		return countLeaves(root);
	}
	
	private int countLeaves(Node node) {
		int leaves = 0;
		if (node == null) 								  return 0;
		else if (node.left == null && node.right == null) return 1;
		else 											  leaves = countLeaves(node.left) + countLeaves(node.right);
		return leaves;
	}
	public static void main(String[] args) {
		IntTree tree = new IntTree(5);
		
		tree.printSideways();
		
		tree.inorderTraversal();					// 4 2 5 1 3
		System.out.println();
		
		tree.preorderTraversal();					// 1 2 4 5 3
		System.out.println();
		
		tree.postorderTraversal();					// 4 5 2 3 1
		System.out.println();
		
		System.out.println(tree.sum());				// 15
		
		System.out.println(tree.countLeaves());		// 3
		
		System.out.println(tree.countLevels());		// 3
	}

}
